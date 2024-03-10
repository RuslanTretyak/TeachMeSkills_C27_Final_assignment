package util;

import consts.*;
import validation.FileContentValidator;
import validation.FileNameValidator;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FileHandler {
    public static List<File> getFilesFromDirectory(String directoryPath, FileNamePattern fileNamePattern) {
        File file = new File(directoryPath);
        List<File> rowListOfFiles;
        List<File> resultListOfFiles = new ArrayList<>();
        if (file.listFiles() != null) {
            rowListOfFiles = Arrays.asList(file.listFiles());
            Iterator<File> iterator = rowListOfFiles.listIterator();
            while (iterator.hasNext()) {
                File tempFile = iterator.next();
                if (FileNameValidator.isFileValid(fileNamePattern.getPattern(), tempFile)) {
                    resultListOfFiles.add(tempFile);
                } else {
                    moveFile(tempFile, FilePathConst.NON_VALID_FILE_PATH);
                }
            }
        } else {
            throw new EmptyStackException();
        }
        return resultListOfFiles;
    }

    public static Map<String, List<String>> getDataFromFiles(List<File> listOfFiles) {
        Map<String, List<String>> resultData = new HashMap<>();
        for (File tempFile : listOfFiles) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(tempFile))) {
                resultData.put(tempFile.getAbsolutePath(),
                        bufferedReader.lines().map(String::trim).collect(Collectors.toList()));
            } catch (FileNotFoundException e) {
                System.out.println("file not found");
            } catch (IOException e) {
                System.out.println("IOex");
            } catch (Exception e) {
                System.out.println("ex");
            }
        }
        return resultData;
    }

    public static double processFiles(FileNamePattern fileNamePattern, Map<String, List<String>> listOfData) {
        double sum = 0;
        for (Map.Entry<String, List<String>> entry : listOfData.entrySet()) {
            switch (fileNamePattern) {
                case CHECK_NAME_PATTERN:
                    if (FileContentValidator.checkCheckContentValid(entry.getValue())) {
                        sum += getAmount(entry.getValue(), CheckContentPatterns.AMOUNT_LINE);
                    } else {
                        moveFile(new File(entry.getKey()), FilePathConst.NON_VALID_FILE_PATH);
                    }
                    break;
                case INVOICE_NAME_PATTERN:
                    if (FileContentValidator.checkInvoiceContentValid(entry.getValue())) {
                        sum += getAmount(entry.getValue(), InvoiceContentPatterns.AMOUNT_LINE);
                    } else {
                        moveFile(new File(entry.getKey()), FilePathConst.NON_VALID_FILE_PATH);
                    }
                    break;
                case ORDER_NAME_PATTERN:
                    if (FileContentValidator.checkOrderContentValid(entry.getValue())) {
                        sum += getAmount(entry.getValue(), OrderContentPattern.AMOUNT_LINE);
                    } else {
                        moveFile(new File(entry.getKey()), FilePathConst.NON_VALID_FILE_PATH);
                    }
                    break;
            }
        }
        return sum;
    }

    private static boolean moveFile(File fileToMove, FilePathConst pathToMove) {
        File newFile = new File(pathToMove.getPath() + "\\" + fileToMove.getName());
        boolean isFileCreated = false;
        boolean isFileCopied = false;
        boolean isFileDeleted;
        try {
            isFileCreated = newFile.createNewFile();
        } catch (IOException e) {
            System.out.println("IOex");
        } catch (Exception e) {
            System.out.println("ex");
        }
        if (isFileCreated) {
            try (FileInputStream fileInputStream = new FileInputStream(fileToMove);
                 FileOutputStream fileOutputStream = new FileOutputStream(newFile)) {
                fileOutputStream.write(fileInputStream.readAllBytes());
                isFileCopied = true;

            } catch (FileNotFoundException e) {
                System.out.println("FileNotFoundException");
            } catch (IOException e) {
                System.out.println("IOException");
            } catch (Exception e) {
                System.out.println("Exception");
            }
        }
        isFileDeleted = fileToMove.delete();
        return isFileCreated && isFileCopied && isFileDeleted;
    }

    private static double getAmount(List<String> lines, String amountPattern) {
        double result = 0;
        String amountLine = "0";
        for (String line : lines) {
            if (line.toLowerCase().matches(amountPattern)) {
                amountLine = line;
            }
        }
        if (amountPattern.equals(CheckContentPatterns.AMOUNT_LINE)) {
            amountLine = amountLine.replace(",", ".");
        } else {
            amountLine = amountLine.replaceAll(",", "");
        }
        Pattern pattern = Pattern.compile("[0-9(,)*]+(.[0-9]{2})?");
        Matcher matcher = pattern.matcher(amountLine);

        if (matcher.find()) {
            String group = matcher.group();
            try {
                result = Double.parseDouble(group);
            } catch (NumberFormatException e) {
                System.out.println("NumberFormatException");
            }
        }
        return result;
    }
}

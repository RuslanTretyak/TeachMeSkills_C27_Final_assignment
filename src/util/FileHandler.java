package util;

import consts.FileNamePattern;
import consts.FilePathConst;
import validation.FileNameValidator;

import java.io.*;
import java.util.*;
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
                    moveFile(tempFile);
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

                    break;
                case INVOICE_NAME_PATTERN:
                    break;
                case ORDER_NAME_PATTERN:
                    break;
            }
        }
        return sum;
    }

    private static boolean moveFile(File fileToMove, FilePathConst pathToMove) {
        File newFile = new File(pathToMove.getPath() + "\\" + fileToMove.getName());
        boolean isFileCreate
        try {
            newFile.createNewFile();

        }

        return true;
    }
}

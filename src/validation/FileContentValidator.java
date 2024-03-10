package validation;

import consts.CheckContentPatterns;
import consts.InvoiceContentPatterns;
import consts.OrderContentPattern;
import exception.IncorrectContentInFileException;

import java.util.List;

public class FileContentValidator {
    public static boolean checkCheckContentValid(String fileName, List<String> lines) throws IncorrectContentInFileException {
        boolean checkingStage1 = false;
        boolean checkingStage2 = false;
        boolean checkingStage3 = false;
        for (String line : lines) {
            if (line.toLowerCase().matches(CheckContentPatterns.NAME_LINE)) {
                checkingStage1 = true;
            } else if (line.toLowerCase().matches(CheckContentPatterns.DATE_LINE)) {
                checkingStage2 = true;
            } else if (line.toLowerCase().matches(CheckContentPatterns.AMOUNT_LINE)) {
                checkingStage3 = true;
            }
        }
        if(!(checkingStage1 && checkingStage2 && checkingStage3)) {
            throw new IncorrectContentInFileException("incorrect content in file '" + fileName + "'");
        }
        return true;
    }
    public static boolean checkInvoiceContentValid(String fileName, List<String> lines) throws IncorrectContentInFileException {
        boolean checkingStage1 = false;
        boolean checkingStage2 = false;
        boolean checkingStage3 = false;
        for (String line : lines) {
            if (line.toLowerCase().matches(InvoiceContentPatterns.NAME_LINE)) {
                checkingStage1 = true;
            } else if (line.toLowerCase().matches(InvoiceContentPatterns.DATE_LINE)) {
                checkingStage2 = true;
            } else if (line.toLowerCase().matches(InvoiceContentPatterns.AMOUNT_LINE)) {
                checkingStage3 = true;
            }
        }
        if(!(checkingStage1 && checkingStage2 && checkingStage3)) {
            throw new IncorrectContentInFileException("incorrect content in file '" + fileName + "'");
        }
        return true;
    }
    public static boolean checkOrderContentValid(String fileName, List<String> lines) throws IncorrectContentInFileException {
        boolean checkingStage1 = false;
        boolean checkingStage2 = false;
        for (String line : lines) {
            if (line.toLowerCase().matches(OrderContentPattern.NAME_LINE)) {
                checkingStage1 = true;
            } else if (line.toLowerCase().matches(OrderContentPattern.AMOUNT_LINE)) {
                checkingStage2 = true;
            }
        }
        if(!(checkingStage1 && checkingStage2)) {
            throw new IncorrectContentInFileException("incorrect content in file '" + fileName + "'");
        }
        return true;
    }
}

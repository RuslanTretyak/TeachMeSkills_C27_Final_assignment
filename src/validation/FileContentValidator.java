package validation;

import consts.CheckContentPatterns;
import consts.InvoiceContentPatterns;

import java.util.List;

public class FileContentValidator {
    public static boolean isCheckContentValid(List<String> lines) {
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
        return checkingStage1 && checkingStage2 && checkingStage3;
    }
    public static boolean isInvoiceContentValid(List<String> lines) {
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
        return checkingStage1 && checkingStage2 && checkingStage3;
    }
}

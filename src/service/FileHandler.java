package service;

import consts.FileNamePattern;
import exception.EmptyDirectoryException;
import exception.IncorrectDirectoryPathException;
import logger.Logger;
import util.FileHandlerUtils;
import util.StatisticWriter;
import java.io.File;
import java.math.BigDecimal;

public class FileHandler {
    public static void handleFiles(File directory) {
        boolean isDirectoryPathCorrect = false;
        try {
            isDirectoryPathCorrect = FileHandlerUtils.checkInputDirectory(directory);
        } catch (IncorrectDirectoryPathException e) {
            System.out.println(e.getMessage());
            Logger.writeExceptionLog(e.getMessage());
        }
        if (isDirectoryPathCorrect) {
            BigDecimal checkStatistic = new BigDecimal(0);
            BigDecimal invoiceStatistic = new BigDecimal(0);
            BigDecimal orderStatistic = new BigDecimal(0);
            try {
                checkStatistic = FileHandlerUtils.processFiles(FileNamePattern.CHECK_NAME_PATTERN,
                        FileHandlerUtils.getDataFromFiles(FileHandlerUtils.
                                getFilesFromDirectory(directory.getPath() + "\\checks",
                                        FileNamePattern.CHECK_NAME_PATTERN)));
            } catch (EmptyDirectoryException e) {
                System.out.println(e.getMessage());
                Logger.writeExceptionLog(e.getMessage());
            }
            try {
                invoiceStatistic = FileHandlerUtils.processFiles(FileNamePattern.INVOICE_NAME_PATTERN,
                        FileHandlerUtils.getDataFromFiles(FileHandlerUtils.
                                getFilesFromDirectory(directory.getPath() + "\\invoices",
                                        FileNamePattern.INVOICE_NAME_PATTERN)));
            } catch (EmptyDirectoryException e) {
                System.out.println(e.getMessage());
                Logger.writeExceptionLog(e.getMessage());
            }
            try {
                orderStatistic = FileHandlerUtils.processFiles(FileNamePattern.ORDER_NAME_PATTERN,
                        FileHandlerUtils.getDataFromFiles(FileHandlerUtils.
                                getFilesFromDirectory(directory.getPath() + "\\orders",
                                        FileNamePattern.ORDER_NAME_PATTERN)));
            } catch (EmptyDirectoryException e) {
                System.out.println(e.getMessage());
                Logger.writeExceptionLog(e.getMessage());
            }
            BigDecimal totalStatistic = checkStatistic.add(invoiceStatistic).add(orderStatistic);
            StatisticWriter.writeDataToStatisticFile("total turnover for the year", totalStatistic.toString());
            StatisticWriter.writeDataToStatisticFile("total turnover for all invoices", invoiceStatistic.toString());
            StatisticWriter.writeDataToStatisticFile("total turnover for all orders", orderStatistic.toString());
            StatisticWriter.writeDataToStatisticFile("total turnover for all checks", checkStatistic.toString());
        }
    }
}

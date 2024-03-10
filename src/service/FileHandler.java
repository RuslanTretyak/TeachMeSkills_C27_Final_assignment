package service;

import consts.FileNamePattern;
import util.FileHandlerUtils;
import util.StatisticWriter;
import java.math.BigDecimal;

public class FileHandler {
    public static void handleFiles(String pathToDirectory) {
        BigDecimal checkStatistic = FileHandlerUtils.processFiles(FileNamePattern.CHECK_NAME_PATTERN,
                FileHandlerUtils.getDataFromFiles(FileHandlerUtils.getFilesFromDirectory(pathToDirectory + "\\checks", FileNamePattern.CHECK_NAME_PATTERN)));
        BigDecimal invoiceStatistic = FileHandlerUtils.processFiles(FileNamePattern.INVOICE_NAME_PATTERN,
                FileHandlerUtils.getDataFromFiles(FileHandlerUtils.getFilesFromDirectory(pathToDirectory + "\\invoices", FileNamePattern.INVOICE_NAME_PATTERN)));
        BigDecimal orderStatistic = FileHandlerUtils.processFiles(FileNamePattern.ORDER_NAME_PATTERN,
                FileHandlerUtils.getDataFromFiles(FileHandlerUtils.getFilesFromDirectory(pathToDirectory + "\\orders", FileNamePattern.ORDER_NAME_PATTERN)));
        BigDecimal totalStatistic = checkStatistic.add(invoiceStatistic).add(orderStatistic);
        StatisticWriter.writeDataToStatisticFile("total turnover for the year", totalStatistic.toString());
        StatisticWriter.writeDataToStatisticFile("total turnover for all invoices", invoiceStatistic.toString());
        StatisticWriter.writeDataToStatisticFile("total turnover for all orders", orderStatistic.toString());
        StatisticWriter.writeDataToStatisticFile("total turnover for all checks", checkStatistic.toString());


    }
}

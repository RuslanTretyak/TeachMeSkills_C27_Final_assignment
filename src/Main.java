import consts.FileNamePattern;
import service.FileHandler;
import util.FileHandlerUtils;
import validation.FileContentValidator;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        /*File file = new File("D:\\Java\\Final_assignment\\TeachMeSkills_C27_Final_assignment\\data");
        System.out.println(Arrays.toString(file.listFiles()));
        System.out.println(FileHandlerUtils.getFilesFromDirectory("D:\\Java\\Final_assignment\\TeachMeSkills_C27_Final_assignment\\data\\invoices", FileNamePattern.INVOICE_NAME_PATTERN));
        System.out.println(FileHandlerUtils.getFilesFromDirectory("D:\\Java\\Final_assignment\\TeachMeSkills_C27_Final_assignment\\data\\checks", FileNamePattern.CHECK_NAME_PATTERN));
        System.out.println(FileHandlerUtils.getFilesFromDirectory("D:\\Java\\Final_assignment\\TeachMeSkills_C27_Final_assignment\\data\\orders", FileNamePattern.ORDER_NAME_PATTERN));
        System.out.println(FileHandlerUtils.getDataFromFiles(FileHandlerUtils.getFilesFromDirectory("D:\\Java\\Final_assignment\\TeachMeSkills_C27_Final_assignment\\data\\invoices", FileNamePattern.INVOICE_NAME_PATTERN)));
        Map<String, List<String>> map = FileHandlerUtils.getDataFromFiles(FileHandlerUtils.getFilesFromDirectory("D:\\Java\\Final_assignment\\TeachMeSkills_C27_Final_assignment\\data\\checks", FileNamePattern.CHECK_NAME_PATTERN));
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " == " + FileContentValidator.checkCheckContentValid(entry.getValue()));
        }
        System.out.println(FileHandlerUtils.processFiles(FileNamePattern.CHECK_NAME_PATTERN, map));
        Map<String, List<String>> map2 = FileHandlerUtils.getDataFromFiles(FileHandlerUtils.getFilesFromDirectory("D:\\Java\\Final_assignment\\TeachMeSkills_C27_Final_assignment\\data\\invoices", FileNamePattern.INVOICE_NAME_PATTERN));
        for (Map.Entry<String, List<String>> entry : map2.entrySet()) {
            System.out.println(entry.getKey() + " == " + FileContentValidator.checkInvoiceContentValid(entry.getValue()));
        }
        System.out.println(FileHandlerUtils.processFiles(FileNamePattern.INVOICE_NAME_PATTERN, map2));
        Map<String, List<String>> map3 = FileHandlerUtils.getDataFromFiles(FileHandlerUtils.getFilesFromDirectory("D:\\Java\\Final_assignment\\TeachMeSkills_C27_Final_assignment\\data\\orders", FileNamePattern.ORDER_NAME_PATTERN));
        for (Map.Entry<String, List<String>> entry : map3.entrySet()) {
            System.out.println(entry.getKey() + " == " + FileContentValidator.checkOrderContentValid(entry.getValue()));
        }
        System.out.println(FileHandlerUtils.processFiles(FileNamePattern.ORDER_NAME_PATTERN, map3));*/
        FileHandler.handleFiles("D:\\Java\\Final_assignment\\TeachMeSkills_C27_Final_assignment\\data");
    }
}

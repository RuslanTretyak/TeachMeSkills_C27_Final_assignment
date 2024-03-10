package util;

import consts.FilePathConst;
import logger.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class StatisticWriter {
    public static void writeDataToStatisticFile(String lineDescription, String data) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FilePathConst.STATISTIC_FILE_PATH.getPath(), true))) {
            bufferedWriter.write(lineDescription + ": " + data + "\n");
        } catch (IOException e) {
            System.out.println("file '" + FilePathConst.STATISTIC_FILE_PATH.getPath() + "' access error");
            Logger.writeExceptionLog("file '" + FilePathConst.STATISTIC_FILE_PATH.getPath() + "' access error");
        } catch (Exception e) {
            System.out.println("error while writing file '" + FilePathConst.STATISTIC_FILE_PATH.getPath() + "'");
            Logger.writeExceptionLog("error while writing file '" + FilePathConst.STATISTIC_FILE_PATH.getPath() + "'");
        }
    }
}

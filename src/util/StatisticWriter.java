package util;

import consts.FilePathConst;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class StatisticWriter {
    public static void writeDataToStatisticFile(String lineDescription, String data) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FilePathConst.STATISTIC_FILE.getPath(), true))) {
            bufferedWriter.write(lineDescription + ": " + data + "\n");
        } catch (IOException e) {
            System.out.println("io");
        } catch (Exception e) {
            System.out.println("ex");
        }
    }
}

package validation;

import java.io.File;

public class FileNameValidator {
    public static boolean isFileValid(String pattern, File file) {
        if (!file.getName().endsWith(".txt")) {
            return false;
        } else {
            return file.getName().toLowerCase().matches(pattern);
        }
    }
}

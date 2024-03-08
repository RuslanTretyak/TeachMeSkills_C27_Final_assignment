package validation;

import consts.CheckContentPatterns;

import java.util.Iterator;
import java.util.List;

public class FileContentValidator {
    public static boolean isCheckContentValid(List<String> lines) {
        Iterator<String> iterator = lines.listIterator();
        if (iterator.hasNext() && iterator.next().matches(CheckContentPatterns.nameLine))
        return true;
    }
}

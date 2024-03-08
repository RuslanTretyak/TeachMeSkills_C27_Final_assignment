package consts;

public interface CheckContentPatterns {
    String nameLine = "^check # [0-9]+$";
    String dateLine = "^date: [0-9]{2}.[0-9]{2}.2023$";
    String amountLine = "^bill total amount euro [0-9]+,[0-9]{2}$";
}

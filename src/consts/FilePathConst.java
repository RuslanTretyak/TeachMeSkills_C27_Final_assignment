package consts;

public enum FilePathConst {
    NON_VALID_FILE_PATH ("data\\nonvalid");
    private String path;

    FilePathConst(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}

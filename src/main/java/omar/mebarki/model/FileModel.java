package omar.mebarki.model;

public class FileModel {
    private final boolean isDir;
    private final String name;

    public FileModel(boolean isDir, String name) {
        this.isDir = isDir;
        this.name = name;
    }

    public boolean isDir() {
        return isDir;
    }

    public String getName() {
        return name;
    }

}

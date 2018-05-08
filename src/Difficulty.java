import java.io.File;

public enum Difficulty {
    EASY("maps" + File.separator + "easy_map.txt", "Könnyű"),
    MEDIUM("maps" + File.separator + "normal_map.txt", "Közepes"),
    HARD("maps" + File.separator + "hard_map.txt", "Nehéz");

    private String mapFilePath;

    private String name;

    Difficulty(String filePath, String name) {
        mapFilePath = filePath;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getMapFilePath() {
        return mapFilePath;
    }
}

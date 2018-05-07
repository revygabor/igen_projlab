public enum Difficulty {
    EASY("", "Könnyű"),
    MEDIUM("", "Közepes"),
    HARD("", "Nehéz");

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

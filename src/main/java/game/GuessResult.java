package game;

public enum GuessResult {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱"),
    ;

    private final String displayName;

    GuessResult(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

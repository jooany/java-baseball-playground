package game;

//TODO: 환경변수로
public enum BaseballGameSetting {
    NUMBER_LENGTH(3),
    ;

    public final int value;

    BaseballGameSetting(int value) {
        this.value = value;
    }
}

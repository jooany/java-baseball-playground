package game;

public enum YesOrNo {
    YES("1"),
    NO("2"),
    ;

    private final String value;

    YesOrNo(String value) {
        this.value = value;
    }

    public static YesOrNo fromValue(String value) {
        for (YesOrNo yesOrNo : values()) {
            if (yesOrNo.value.equals(value)) {
                return yesOrNo;
            }
        }
        throw new IllegalArgumentException("unexpected value: " + value);
    }

    public String getValue() {
        return value;
    }
}

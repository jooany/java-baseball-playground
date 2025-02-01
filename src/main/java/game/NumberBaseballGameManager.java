package game;


public class NumberBaseballGameManager {
    public static final NumberBaseballGameManager INSTANCE = new NumberBaseballGameManager();
    public static final int NUMBER_LENGTH = 3;
    private String correctResult;

    private NumberBaseballGameManager() {
        initialize();
    }

    public void initialize() {
        this.correctResult = String.format("%s%s%s", randomDigit(), randomDigit(), randomDigit());
    }

    private int randomDigit() {
        return (int) (Math.random() * 9) + 1;
    }

    public GuessResultMap evaluateGuess(String guess) {
        char[] guessChars = guess.toCharArray();
        char[] correctResultChars = correctResult.toCharArray();
        GuessResultMap guessResultMap = new GuessResultMap();

        for (int i = 0; i < NUMBER_LENGTH; i++) {
            GuessResult guessResult = evaluateGuessChar(guessChars[i], correctResultChars[i]);
            putGuessResult(guessResultMap, guessResult);
        }
        return guessResultMap;
    }

    private void putGuessResult(GuessResultMap guessResultMap, GuessResult guessResult) {
        if (guessResult == GuessResult.NOTHING) {
            return;
        }
        guessResultMap.put(guessResult);
    }

    private GuessResult evaluateGuessChar(char guessChar, char correctResultChar) {
        if (guessChar == correctResultChar) {
            return GuessResult.STRIKE;
        }
        if (correctResult.contains(String.valueOf(guessChar))) {
            return GuessResult.BALL;
        }
        return GuessResult.NOTHING;
    }
}

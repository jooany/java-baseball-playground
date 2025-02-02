package game;


import static game.BaseballGameSetting.NUMBER_LENGTH;

public class BaseballGameEvaluator {
    public static final BaseballGameEvaluator INSTANCE = new BaseballGameEvaluator();

    private BaseballGameEvaluator() {
    }

    public GuessResultMap evaluateGuess(String guess, String correctResult) {
        char[] guessDigits = guess.toCharArray();
        char[] correctResultDigits = correctResult.toCharArray();
        GuessResultMap guessResultMap = new GuessResultMap();

        for (int i = 0; i < NUMBER_LENGTH.value; i++) {
            GuessResult guessResult = evaluateGuessDigit(guessDigits[i], correctResultDigits[i], correctResult);

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

    private GuessResult evaluateGuessDigit(char guessDigit, char correctResultDigit, String correctResult) {
        if (guessDigit == correctResultDigit) {
            return GuessResult.STRIKE;
        }
        if (correctResult.contains(String.valueOf(guessDigit))) {
            return GuessResult.BALL;
        }
        return GuessResult.NOTHING;
    }
}

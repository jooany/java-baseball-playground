package game;

import java.util.HashMap;

public class GuessResultMap {
    private final HashMap<GuessResult, Integer> result;

    public GuessResultMap() {
        this.result = new HashMap<>();
    }

    public int getStrikeCount() {
        return result.getOrDefault(GuessResult.STRIKE, 0);
    }

    public int getBallCount() {
        return result.getOrDefault(GuessResult.BALL, 0);
    }

    public boolean isNothing() {
        return getBallCount() == 0 && getStrikeCount() == 0;
    }

    public void put(GuessResult guessResult) {
        result.put(guessResult, result.getOrDefault(guessResult, 0) + 1);

    }

    public void clear() {
        result.clear();
    }

    public boolean isAllStrike() {
        return getStrikeCount() == NumberBaseballGameManager.NUMBER_LENGTH;
    }
}

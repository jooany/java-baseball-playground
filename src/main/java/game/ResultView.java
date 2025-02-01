package game;

public class ResultView {

    public static void printResult(GuessResultMap guessResultMap) {
        if (guessResultMap.isNothing()) {
            System.out.println(GuessResult.NOTHING.getDisplayName());
            return;
        }

        if (guessResultMap.getBallCount() > 0) {
            System.out.printf("%s%s ", guessResultMap.getBallCount(), GuessResult.BALL.getDisplayName());
        }

        if (guessResultMap.getStrikeCount() > 0) {
            System.out.printf("%s%s", guessResultMap.getStrikeCount(), GuessResult.STRIKE.getDisplayName());
        }

        System.out.println();
    }

    public static void printAllStrike() {
        System.out.printf("%s개의 숫자를 모두 맞히셨습니다! 게임 종료", NumberBaseballGameManager.NUMBER_LENGTH);
    }
}
import game.GuessResultMap;
import game.InputView;
import game.NumberBaseballGameManager;
import game.ResultView;
import game.YesOrNo;

public class main {
    public static void main(String[] args) {
        InputView inputView = InputView.INSTANCE;
        NumberBaseballGameManager gameManager = NumberBaseballGameManager.INSTANCE;

        while (true) {
            String input = inputView.requestNumberInput();

            GuessResultMap guessResultMap = gameManager.evaluateGuess(input);

            ResultView.printResult(guessResultMap);

            if (!guessResultMap.isAllStrike()) continue;

            guessResultMap.clear();
            ResultView.printAllStrike();
            YesOrNo restartChoice = inputView.requestRestartChoiceInput();

            if (restartChoice == YesOrNo.NO) break;

            gameManager.initialize();
        }
    }
}

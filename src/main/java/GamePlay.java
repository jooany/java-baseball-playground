import game.BaseballGameEvaluator;
import game.BaseballGameNumberGenerator;
import game.GuessResultMap;
import game.InputView;
import game.ResultView;
import game.YesOrNo;

public class GamePlay {
    public static void main(String[] args) {
        InputView inputView = InputView.INSTANCE;
        BaseballGameEvaluator gameEvaluator = BaseballGameEvaluator.INSTANCE;

        String correctAnswer = BaseballGameNumberGenerator.generate();

        while (true) {
            String input = inputView.requestNumberInput();
            GuessResultMap guessResultMap = gameEvaluator.evaluateGuess(input, correctAnswer);
            ResultView.printResult(guessResultMap);

            if (!guessResultMap.isAllStrike()) continue;
            ResultView.printAllStrike();

            YesOrNo restartChoice = inputView.requestRestartChoiceInput();
            if (restartChoice == YesOrNo.NO) break;

            correctAnswer = BaseballGameNumberGenerator.generate();
        }
    }
}

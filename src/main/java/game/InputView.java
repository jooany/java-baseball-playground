package game;

import java.util.Scanner;

import static game.BaseballGameSetting.NUMBER_LENGTH;

public class InputView {
    public static final InputView INSTANCE = new InputView();
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public String requestNumberInput() {
        System.out.print("숫자를 입력해 주세요 : ");
        String input = SCANNER.next();

        if (input.contains("0")) {
            System.out.println("0은 입력할 수 없습니다.");
            return requestNumberInput();
        }

        if (input.length() != NUMBER_LENGTH.value) {
            System.out.printf("%s자리 숫자만 입력할 수 있습니다.%n", NUMBER_LENGTH.value);
            return requestNumberInput();
        }

        return input;
    }

    public YesOrNo requestRestartChoiceInput() {
        System.out.printf("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.%n", YesOrNo.YES.getValue(), YesOrNo.NO.getValue());

        if (SCANNER.hasNextLine()) {
            SCANNER.nextLine();
        }

        String input = SCANNER.nextLine().trim();

        YesOrNo answer;
        try {
            answer = YesOrNo.fromValue(input);
        } catch (IllegalArgumentException e) {
            System.out.printf("%s 또는 %s를 입력하셔야 합니다.%n", YesOrNo.YES.getValue(), YesOrNo.NO.getValue());
            return requestRestartChoiceInput();
        }

        return answer;
    }
}

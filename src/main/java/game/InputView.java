package game;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static final InputView INSTANCE = new InputView();

    private InputView() {
    }

    public String requestNumberInput() {
        System.out.print("숫자를 입력해 주세요 : ");
        String input = SCANNER.next();

        if (input.contains("0")) {
            System.out.println("0은 입력할 수 없습니다. 다시 입력해 주세요 : ");
            return requestNumberInput();
        }

        if (input.length() != 3) {
            System.out.println("3자리 숫자를 입력해 주세요.");
            return requestNumberInput();
        }

        return input;
    }

    public YesOrNo requestRestartChoiceInput() {
        System.out.printf("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.%n", YesOrNo.YES.getValue(), YesOrNo.NO.getValue());
        String input = SCANNER.next();

        YesOrNo answer;
        try {
            answer = YesOrNo.fromValue(input);
        } catch (IllegalArgumentException e) {
            System.out.printf("%s 또는 %s를 입력해 주세요.%n", YesOrNo.YES.getValue(), YesOrNo.NO.getValue());
            return requestRestartChoiceInput();
        }

        return answer;
    }
}

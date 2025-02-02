package game;

import java.util.HashSet;
import java.util.Set;

import static game.BaseballGameSetting.NUMBER_LENGTH;

public interface BaseballGameNumberGenerator {
    static String generate() {
        Set<Integer> uniqueNumbers = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        while (uniqueNumbers.size() < NUMBER_LENGTH.value) {
            int digit = randomDigit();

            if (uniqueNumbers.add(digit)) {
                sb.append(digit);
            }
        }

        return sb.toString();
    }

    static private int randomDigit() {
        return (int) (Math.random() * 9) + 1;
    }
}

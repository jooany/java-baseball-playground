package study;

import game.BaseballGameEvaluator;
import game.GuessResultMap;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    @Test
    void 정답이_123일_때_456을_제시한_경우_낫싱() {
        // given
        // when
        GuessResultMap resultMap = BaseballGameEvaluator.INSTANCE.evaluateGuess("456", "123");

        // then
        assertThat(resultMap.isNothing()).isTrue();
    }

    @Test
    void 정답이_123일_때_156을_제시한_경우_1스트라이크() {
        // given
        // when
        GuessResultMap resultMap = BaseballGameEvaluator.INSTANCE.evaluateGuess("156", "123");

        // then
        assertThat(resultMap.getStrikeCount()).isEqualTo(1);
        assertThat(resultMap.getBallCount()).isEqualTo(0);
        assertThat(resultMap.isNothing()).isFalse();
    }

    @Test
    void 정답이_123일_때_123을_제시한_경우_3스트라이크() {
        // given
        // when
        GuessResultMap resultMap = BaseballGameEvaluator.INSTANCE.evaluateGuess("123", "123");

        // then
        assertThat(resultMap.getStrikeCount()).isEqualTo(3);
        assertThat(resultMap.getBallCount()).isEqualTo(0);
        assertThat(resultMap.isNothing()).isFalse();
    }

    @Test
    void 정답이_123일_때_136을_제시한_경우_1볼1스트라이크() {
        // given
        // when
        GuessResultMap resultMap = BaseballGameEvaluator.INSTANCE.evaluateGuess("136", "123");

        // then
        assertThat(resultMap.getStrikeCount()).isEqualTo(1);
        assertThat(resultMap.getBallCount()).isEqualTo(1);
        assertThat(resultMap.isNothing()).isFalse();
    }

    @Test
    void 정답이_123일_때_321을_제시한_경우_3볼() {
        // given
        // when
        GuessResultMap resultMap = BaseballGameEvaluator.INSTANCE.evaluateGuess("312", "123");

        // then
        assertThat(resultMap.getStrikeCount()).isEqualTo(0);
        assertThat(resultMap.getBallCount()).isEqualTo(3);
        assertThat(resultMap.isNothing()).isFalse();
    }
}

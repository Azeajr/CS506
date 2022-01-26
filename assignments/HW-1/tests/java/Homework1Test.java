import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Homework1Test {

    private static Stream<Arguments> ArraysFindLast() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, 2, 1),
                Arguments.of(new int[]{1, 2, 3}, 1, 0),
                Arguments.of(new int[]{0, 1, 2, 3}, 1, 1),
                Arguments.of(new int[]{2, 3, 5}, 2, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("ArraysFindLast")
    void findLast(int[] x, int y, int expected) {
        assertEquals(expected, Homework1.findLast(x, y));
    }

    @Test
    void countOccurrence() {
    }

    @Test
    void countPositive() {
    }

    @Test
    void addCommasToDigitString() {
    }
}
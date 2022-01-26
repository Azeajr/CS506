import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Homework1Test {

    private static Stream<Arguments> ArraysFindLast() {
        return Stream.of(
                Arguments.of(null, 2, -1),
                Arguments.of(new int[]{}, 2, -1),
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

    private static Stream<Arguments> StringsCountOccurence() {
        return Stream.of(
                Arguments.of(null, null, 0),
                Arguments.of("", null, 0),
                Arguments.of("", "Antonio", 0),
                Arguments.of("", "", 1),
                Arguments.of("Antonio Antonio", " ", 0),
                Arguments.of("Antonio Antonio", "", 0),
                Arguments.of(" ", " ", 0),
                Arguments.of("Antonio Antonio", "Antonio", 2),
                Arguments.of("What is Software Testing? Why is Software Testing so important?", "Software", 2)
        );
    }

    @ParameterizedTest
    @MethodSource("StringsCountOccurence")
    void countOccurrence(String source, String word, int expected) {
        assertEquals(expected, Homework1.countOccurrence(source, word));
    }

    @Test
    void countPositive() {
    }

    @Test
    void addCommasToDigitString() {
    }
}
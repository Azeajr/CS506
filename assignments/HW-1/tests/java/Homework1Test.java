import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Homework1Test {

    private static Stream<Arguments> ArraysFindLast() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, 5}, 2, 0),
                Arguments.of(new int[]{7, 15, 22}, 3, -1),
                // Arguments.of(null, 2, -1),
                Arguments.of(new int[]{}, 2, -1),
                Arguments.of(new int[]{1, 2, 3}, 2, 1),
                Arguments.of(new int[]{1, 2, 3}, 1, 0),
                Arguments.of(new int[]{0, 1, 2, 3}, 1, 1)

        );
    }

    @ParameterizedTest
    @MethodSource("ArraysFindLast")
    void findLast(int[] x, int y, int expected) {
        assertEquals(expected, Homework1.findLast(x, y));
    }

    private static Stream<Arguments> StringsCountOccurrence() {
        return Stream.of(
                // Arguments.of(null, null, 0),
                // Arguments.of("", null, 0),
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
    @MethodSource("StringsCountOccurrence")
    void countOccurrence(String source, String word, int expected) {
        assertEquals(expected, Homework1.countOccurrence(source, word));
    }

    private static Stream<Arguments> ArraysCountPositive() {
        return Stream.of(
                // Arguments.of(null, 0),
//                Arguments.of(new int[]{}, 0),
                Arguments.of(new int[]{-4, 2, 0, 2}, 2),
                Arguments.of(new int[]{-4, -22, 2, -2}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("ArraysCountPositive")
    void countPositive(int[] x, int expected) {
        assertEquals(expected, Homework1.countPositive(x));
    }

    private static Stream<Arguments> StringsAddCommasToDigitString() {
        return Stream.of(
                Arguments.of("", ""),
                Arguments.of("12", "12"),
                Arguments.of("123", "123"),
                Arguments.of("1234", "1,234"),
                Arguments.of("12345", "12,345"),
                Arguments.of("123456", "123,456"),
                Arguments.of("1234567", "1,234,567"),
                Arguments.of("12345678", "12,345,678"),
                Arguments.of("123456789", "123,456,789"),
                Arguments.of("1234567890", "1,234,567,890"),
                Arguments.of("456646546113", "456,646,546,113"),
                Arguments.of("1456646546113", "1,456,646,546,113")
        );
    }

    @ParameterizedTest
    @MethodSource("StringsAddCommasToDigitString")
    void addCommasToDigitString(String digits, String expected) {
        assertEquals(expected, Homework1.addCommasToDigitString(digits));
    }
}
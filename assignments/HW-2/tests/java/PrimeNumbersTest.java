import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PrimeNumbersTest {
    PrimeNumbers primeNumbers;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    private static Stream<Arguments> IntsComputePrimes(){
        return Stream.of(
                Arguments.of(7, "[2, 3, 5, 7, 11, 13, 17]"),
                Arguments.of(8, "[2, 3, 5, 7, 11, 13, 17, 19]"),
                Arguments.of(9, "[2, 3, 5, 7, 11, 13, 17, 19, 23]"),
                Arguments.of(10, "[2, 3, 5, 7, 11, 13, 17, 19, 23, 29]")
        );
    }


    @ParameterizedTest
    @MethodSource("IntsComputePrimes")
    void computePrimes(int n, String expected) {
        primeNumbers = new PrimeNumbers();
        primeNumbers.computePrimes(n);
        assertEquals(expected, primeNumbers.toString());
    }

    @Test
    void iterator() {
    }

    @Test
    void testToString() {
    }
}
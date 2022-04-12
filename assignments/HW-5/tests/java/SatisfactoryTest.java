import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SatisfactoryTest {

    private static Stream<Arguments> CACCisSatisfactoryInputs() {
        return Stream.of(
                Arguments.of("(2,6)", true, true, false, true, false, true, false, false),
                Arguments.of("(2,7)", true, true, false, true, false, false, true, false),
                Arguments.of("(3,6)", true, false, true, true, false, true, false, false),
                Arguments.of("(3,7)", true, false, true, true, false, false, true, false),

                Arguments.of("(2,4)", true, true, false, true, true, false, false, false),
                Arguments.of("(2,7)", true, true, false, true, false, false, true, false),
                Arguments.of("(5,4)", false, true, true, true, true, false, false, false),
                Arguments.of("(5,7)", false, true, true, true, false, false, true, false),

                Arguments.of("(3,4)", true, false, true, true, true, false, false, false),
                Arguments.of("(3,6)", true, false, true, true, false, true, false, false),
                Arguments.of("(5,4)", false, true, true, true, true, false, false, false),
                Arguments.of("(5,6)", false, true, true, true, false, true, false, false)
        );
    }

    @ParameterizedTest(name = "CACC test {0}")
    @MethodSource("CACCisSatisfactoryInputs")
    void CACCTesting(String name, boolean good1, boolean fast1, boolean cheap1, boolean expected1, boolean good2, boolean fast2, boolean cheap2, boolean expected2) {
        assertEquals(expected1, Satisfactory.isSatisfactory(good1, fast1, cheap1));
        assertEquals(expected2, Satisfactory.isSatisfactory(good2, fast2, cheap2));
    }

    @Test
    void isSatisfactoryRefactored() {
    }
}
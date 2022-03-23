import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    Point p1, p2;
    Set<Point> points;

    private static Stream<Arguments> pointsHashSet() {
        return Stream.of(
                Arguments.of(1, 2, 1, 2, 1),
                Arguments.of(2, 1, 2, 1, 1),
                Arguments.of(1, 2, 2, 1, 2)
        );
    }

    @ParameterizedTest(name = "First Point({0},{1}) Second Point({2},{3}) Expected Size of Hashset: {4}")
    @MethodSource("pointsHashSet")
    void hashSetTest(int x1, int y1, int x2, int y2, int expected) {
        p1 = new Point(x1, y1);
        p2 = new Point(x2, y2);

        points = new HashSet();
        points.add(p1);
        points.add(p2);

        assertEquals(expected, points.size());
    }

    private static Stream<Arguments> pointsEqual(){
        return Stream.of(
                Arguments.of(1, 2, 1, 2, true),
                Arguments.of(2, 1, 2, 1, true),
                Arguments.of(1, 2, 2, 1, false)
        );
    }

    @ParameterizedTest(name = "First Point({0},{1}) Second Point({2},{3}) Expected equality: {4}")
    @MethodSource("pointsEqual")
    void equalsTest(int x1, int y1, int x2, int y2, boolean expected){
        p1 = new Point(x1, y1);
        p2 = new Point(x2, y2);

        assertEquals(expected, p1.equals(p2));
    }

    private static Stream<Arguments> pointsHashCodeEqual(){
        return Stream.of(
                Arguments.of(1, 2, 1, 2, true),
                Arguments.of(2, 1, 2, 1, true),
                Arguments.of(1, 2, 2, 1, false)
        );
    }

    @ParameterizedTest(name = "First Point({0},{1}) Second Point({2},{3}) Expected hashCode equality: {4}")
    @MethodSource("pointsHashCodeEqual")
    void hashCodeTest(int x1, int y1, int x2, int y2, boolean expected){
        int hashCode1 = new Point(x1, y1).hashCode();
        int hashCode2 = new Point(x2, y2).hashCode();

        assertEquals(expected, hashCode1 == hashCode2);
    }

}
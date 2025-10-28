package testsLesson_7;

import org.Aston_study.Lesson_7.TriangleSquare;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleSquareTest {
    @Test
    void calculateByBaseAndHeight() {
        assertEquals(25.0, TriangleSquare.calculateByBaseAndHeight(10, 5));
        assertEquals(12.5, TriangleSquare.calculateByBaseAndHeight(5, 5));
        assertEquals(50.0, TriangleSquare.calculateByBaseAndHeight(10, 10));
        assertEquals(0.5, TriangleSquare.calculateByBaseAndHeight(1, 1));
        assertEquals(6.0, TriangleSquare.calculateByBaseAndHeight(3, 4));
    }

    @Test
    void calculateBySides_valid() {
        assertEquals(6.0, TriangleSquare.calculateBySides(3, 4, 5), 0.001);
        assertEquals(6.928, TriangleSquare.calculateBySides(4, 4, 4), 0.001);
        assertEquals(12.0, TriangleSquare.calculateBySides(5, 5, 6), 0.001);
    }

    @Test
    void calculateBySides_invalid() {
        assertEquals(6.0, TriangleSquare.calculateBySides(3, 4, 100), 0.001);
        assertEquals(6.0, TriangleSquare.calculateBySides(4, 4, 1), 0.001);

    }
}

import org.Aston_study.Lesson_7.NumberComparator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NumberComparatorTest {
    @Test
    void testCompare_FirstNumberGreater() {
        assertEquals("10 > 5", NumberComparator.compare(10, 5));
    }

    @Test
    void testCompare_SecondNumberGreater() {
        assertEquals("3 < 8", NumberComparator.compare(3, 8));
    }

    @Test
    void testIsGreater_ReturnsTrue() {
        assertTrue(NumberComparator.isGreater(15, 10));
    }

    @Test
    void testIsGreater_ReturnsFalse() {
        assertFalse(NumberComparator.isGreater(5, 10));
    }

    @Test
    void testIsLess_ReturnsTrue() {
        assertTrue(NumberComparator.isLess(2, 9));
    }

    @Test
    void testIsLess_ReturnsFalse() {
        assertFalse(NumberComparator.isLess(9, 2));
    }


    @Test
    void testIsEqual_ReturnsTrue() {
        assertTrue(NumberComparator.isEqual(10, 10));
    }

    @Test
    void testCompare_NumbersEqual() {
        assertEquals("7 = 7", NumberComparator.compare(7, 7));
    }

    @Test
    void testIsEqual_ReturnsFalse() {
        assertFalse(NumberComparator.isEqual(10, 5));
    }
}

import org.Aston_study.Lesson_7.ArithmeticOperations;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArithmeticOperationTest {
    @Test
    void testSum() {
        assertEquals(15, ArithmeticOperations.sum(5, 10));
    }

    @Test
    void testSubtract() {
        assertEquals(5, ArithmeticOperations.subtract(10, 5));
    }

    @Test
    void testMultiply() {
        assertEquals(20, ArithmeticOperations.multiply(5, 4));
    }

    @Test
    void testDivide() {
        assertEquals(3, ArithmeticOperations.divide(15, 5));
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            ArithmeticOperations.divide(10, 0);
        });
    }
}

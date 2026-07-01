import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void testAssertions() {
        Calculator calc = new Calculator();

        // Assert equals
        assertEquals(5, calc.add(2, 3));

        // Assert true
        assertTrue(calc.isGreaterThan(5, 3));

        // Assert false
        assertFalse(calc.isGreaterThan(3, 5));

        // Assert not null
        assertNotNull(calc);
    }
}
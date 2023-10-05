package mycalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTests {
    
    private Calculator calc;

    @Before
    public void setUp() {
        calc = new Calculator();
    }

    @Test
    public void testAdd() {
        calc.push(1);
        calc.push(2);
        calc.add();
        Integer result = calc.pop();
        assertEquals(Integer.valueOf(3), result);
    }

    @Test
    public void testOverflow() {
        calc.push(Integer.MAX_VALUE);
        calc.push(1);
        assertThrows( ArithmeticException.class, () -> calc.add() );
    }
}

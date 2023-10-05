import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class CalculatorTests {
    
    private Calculator calc;

    @BeforeEach
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

    @RepeatedTest(1000)
    public void testLotsOfAdds() {
        int a = (int) (Math.random() * 100);
        int b = (int) (Math.random() * 100);
        calc.push(a);
        calc.push(b);
        calc.add();
        Integer result = calc.pop();
        assertEquals(Integer.valueOf(a + b), result);
    }

    @Test
    public void testOverflow() {
        calc.push(Integer.MAX_VALUE);
        calc.push(1);
        assertThrows( ArithmeticException.class, () -> calc.add() );
    }
}

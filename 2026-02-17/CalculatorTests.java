import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTests {
    
    private Calculator calc;

    @BeforeEach
    public void setUp() {
        System.out.println("Setting up calculator");
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

    @RepeatedTest(50)
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


    @ParameterizedTest
    @ValueSource( ints = { 1, 2, -3, 4, 5, Integer.MAX_VALUE, Integer.MIN_VALUE } )
    public void testPushPop( int n ) {
        calc.push(n);
        Integer result = calc.pop();
        assertEquals(Integer.valueOf(n), result);
    }

}

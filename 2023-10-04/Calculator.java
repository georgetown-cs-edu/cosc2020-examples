import java.util.Vector;

public class Calculator {

    private Vector<Integer> stack;

    public Calculator() {
        stack = new Vector<Integer>();
    }

    public void push(Integer n) {
        stack.add(n);
    }

    public Integer pop() {
        return stack.remove(stack.size() - 1);
    }

    public void add() throws ArithmeticException {
        Integer a = pop();
        Integer b = pop();
        // ADD ERROR HERE
        if (Integer.MAX_VALUE - a < b) {
            throw new ArithmeticException("Integer overflow");
        }
        push(a + b);
    }

    public void sub() {
        Integer a = pop();
        Integer b = pop();
        push(a - b);
    }


    
}
public class Complex {

    // Member fields
    private double re, im;

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public void set(double re, double im) {
        this.re = re;
        this.im = im;
    }

    @Override
    public String toString() {
        return String.format("%f + %fi", re, im);
    }

    @Override
    public Complex clone() {
        return new Complex(re, im);
    }

    public static void main( String args[]) {
        Complex c = new Complex(3, 4);
        System.out.println("c is " + c);

        Complex d = c;
         
        d.set(5, 6);

        System.out.println("d is " + d);
        System.out.println("c is " + c);

    }
}

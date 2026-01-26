public class Runner {
    public static void main(String[] args) {
        Shape square = new Square(10);
        System.out.println("the area of the square is " + square.getArea());

        Shape triangle = new Triangle(5,10);
        System.out.println("the area of the triangle is " + triangle.getArea());

    }
}

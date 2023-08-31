public class Triangle implements Shape {
    public double height;
    public double base;

    public Triangle(double height, double base) {
        this.height = height;
        this.base = base;
    }

    public double getArea() {
        return base * height * 0.5;
    }
}

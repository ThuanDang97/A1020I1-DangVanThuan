package B5_AccessModifier.BaiTap;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea(){
        return Math.PI*(this.radius*this.radius);
    }

    public static void main(String[] args) {
        Circle circle1 = new Circle();
        circle1.radius = 5;
        System.out.println(circle1.getArea());
    }
}

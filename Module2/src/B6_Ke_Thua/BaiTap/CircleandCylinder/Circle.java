package B6_Ke_Thua.BaiTap.CircleandCylinder;

public class Circle {
    private double radius;
    private String color;

    public Circle() {
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }
    public double getArea(){
        return (this.radius * this.radius) * Math.PI;
    }

    @Override
    public String toString() {
        return "radius=" + radius +
                ", color='" + color + '\'' +
                ", Area= " + getArea() +
                '}';
    }
}

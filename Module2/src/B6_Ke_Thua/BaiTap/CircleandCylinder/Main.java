package B6_Ke_Thua.BaiTap.CircleandCylinder;

public class Main {
    public static void main(String[] args) {
        // test circle
        System.out.println("Circle");
        Circle circle = new Circle(2.5,"Blue");
        circle.getArea();
        System.out.println(circle);

        // test cylinder
        System.out.println("Cylinder");
        Cylinder cylinder = new Cylinder(2,"Red",3);
        cylinder.getArea();
        System.out.println(cylinder);
    }
}

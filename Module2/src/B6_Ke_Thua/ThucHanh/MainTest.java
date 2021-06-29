package B6_Ke_Thua.ThucHanh;

public class MainTest {
    public static void main(String[] args) {
        // test Shape
        System.out.println("Shape");
        Shape shape = new Shape();
        System.out.println(shape);

        shape = new Shape("red", false);
        System.out.println(shape);

        // test circle
        System.out.println("Circle");
        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle(3.5);
        System.out.println(circle);

        circle = new Circle("indigo", false, 3.5);
        System.out.println(circle);

        // test rectangle
        System.out.println("RectAngle");
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);

        rectangle = new Rectangle(2.3, 5.8);
        System.out.println(rectangle);

        rectangle = new Rectangle("orange", true, 2.5, 3.8);
        System.out.println(rectangle);

        // test square
        System.out.println("Square");
        Square square = new Square();
        System.out.println(square);

        square = new Square(2.3);
        System.out.println(square);

        square = new Square(5.8, "yellow", true);
        System.out.println(square);
    }
}

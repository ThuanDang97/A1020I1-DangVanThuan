package B7_AbstractClass_and_Interface.BaiTap.Shape;

import B7_AbstractClass_and_Interface.BaiTap.Shape.Circle;
import B7_AbstractClass_and_Interface.BaiTap.Shape.Rectangle;
import B7_AbstractClass_and_Interface.BaiTap.Shape.Shape;
import B7_AbstractClass_and_Interface.BaiTap.Shape.Square;

import java.util.Arrays;

public class TestResizeable {
    public static void main(String[] args) {
        int x = (int) Math.floor(Math.random() * 10);
        System.out.println(x);
        Shape[] shape = new Shape[3];
        shape[0] = new Circle(x,"Blue",true);
        shape[1] = new Rectangle("Yellow",true,x,x);
        shape[2] = new Square(x,"Green",true);

        for (Shape shape1 : shape){
            System.out.println(shape1);
        }
        for (Shape shape1 : shape){
            shape1.resize((int)Math.floor(Math.random()*100));
        }
        System.out.println("\n");
        System.out.println(Arrays.toString(shape));
    }
}

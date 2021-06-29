package B7_AbstractClass_and_Interface.BaiTap.Shape;

public class MainTestColorable {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[2];
        shapes[0] = new Square(7,"Yellow",false);
        shapes[1] = new Square(5,"Blue",true);

        for (Shape shape : shapes){
            System.out.println(shape);
            if (shape.getColor()!=null){
                shape.howToColor();
            }
        }
    }
}

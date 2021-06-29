package B7_AbstractClass_and_Interface.BaiTap.Shape;

public class Square extends Rectangle {
    private double side;
    public Square() {
    }

    public Square(double side) {
        super(side,side);
    }

    public Square(double side, String color, boolean filled) {
        super(color,filled,side,side);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public void setWidth(double width) {
        setSide(width);
    }

    @Override
    public void setLength(double length) {
        setSide(length);
    }

    @Override
    public String toString() {
        return "A Square with side="
                + getSide()
                + ", Color = "
                + getColor()
                + ", Area = "
                + getArea();
    }
    public double getArea() {
        return getWidth() * getLength();
    }

    @Override
    public void resize(double percent) {
        this.side *= percent;
    }
    @Override
    public void howToColor() {
        System.out.println("Color all four sides..");
    }
}


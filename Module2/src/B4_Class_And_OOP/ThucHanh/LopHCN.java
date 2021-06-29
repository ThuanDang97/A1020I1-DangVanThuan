package B4_Class_And_OOP.ThucHanh;
public class LopHCN {
    public double width;
    public double height;

    public void getArea(double width, double height){
        double area = width*height;
        System.out.println("Area: " + area);
    }
    public void getPerimeter(double width, double height){
        double perimeter = (width+height)*2;
        System.out.println("Perimeter: " + perimeter);
    }

    public static void main(String[] args) {
        LopHCN hcn1 = new LopHCN();
        hcn1.width = 15;
        hcn1.height = 20;

        hcn1.getArea(hcn1.width,hcn1.height);
        hcn1.getPerimeter(hcn1.width,hcn1.height);

    }


}

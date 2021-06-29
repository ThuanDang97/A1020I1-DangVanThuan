package B15_Xu_Li_Ngoai_Le_Va_Debug.BaiTap;

public class Triangle {
    public int a;
    public int b;
    public int c;

    public Triangle() {
    }

    public Triangle(int a, int b, int c) throws IllegalTriangleException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalTriangleException("Canh nho hon 0!!!");
        } else if ((a + b) < c || (a + c) < b || (b + c) < a) {
            throw new IllegalTriangleException("Tong 2 canh nho hon 1 canh!!!");
        } else {
            this.a = a;
            this.b = b;
            this.c = c;
        }

    }


    public static void main(String[] args) {
        try {
            Triangle triangle = new Triangle(0, 3, 1);
        } catch (IllegalTriangleException e) {
            e.printStackTrace();
        }


    }
}

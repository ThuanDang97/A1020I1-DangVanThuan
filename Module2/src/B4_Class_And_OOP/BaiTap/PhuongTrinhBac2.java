package B4_Class_And_OOP.BaiTap;

import java.sql.SQLOutput;
import java.util.Scanner;

public class PhuongTrinhBac2 {
    private double a;
    private double b;
    private double c;

//    public double getA() {
//        return a;
//    }
//
//    public double getB() {
//        return b;
//    }
//
//    public double getC() {
//        return c;
//    }


    public PhuongTrinhBac2() {
    }

    public double getDiscriminant() {
        return (b * b) - 4 * (a * c);
    }

    private void getRoot1() {
        System.out.println((-b + Math.sqrt(getDiscriminant())) / (2 * a));
    }

    private void getRoot2() {
        System.out.println((-b - Math.sqrt(getDiscriminant())) / (2 * a));
    }

    private void getRoot3() {
        // return khi delta = 0;
        System.out.println(-b / (2 * a));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PhuongTrinhBac2 pt1 = new PhuongTrinhBac2();
        System.out.print("Nhập A: ");
        pt1.a = input.nextDouble();
        System.out.print("Nhập B: ");
        pt1.b = input.nextDouble();
        System.out.print("Nhập C: ");
        pt1.c = input.nextDouble();

        System.out.println(pt1.getDiscriminant());
        if (pt1.getDiscriminant() > 0) {
            System.out.println("Phương trình có 2 nghiệm là: ");
            pt1.getRoot1();
            pt1.getRoot2();
        } else if (pt1.getDiscriminant() == 0) {
            pt1.getRoot3();
        } else if (pt1.getDiscriminant() < 0) {
            System.out.println("0");
        } else {
            System.out.println("The equation has no roots");
        }

    }
}

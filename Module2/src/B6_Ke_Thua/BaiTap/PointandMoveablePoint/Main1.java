package B6_Ke_Thua.BaiTap.PointandMoveablePoint;

import java.util.Arrays;

public class Main1 {
    public static void main(String[] args) {
//        // test Point
//        Point point = new Point(4,5);
//        point.setXY(point.x,point.y);
//        System.out.println(Arrays.toString(point.getXY()));
//        System.out.println(point);
//        System.out.println();
        // test Move
        MoveablePoint point1 = new MoveablePoint(4,5,3,4);
        System.out.println(point1);
        System.out.print("Point late move: ");
        System.out.println(point1.move());
    }
}

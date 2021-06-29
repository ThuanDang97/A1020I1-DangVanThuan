package B6_Ke_Thua.BaiTap.Point2DandPoint3D;

public class Point3D extends Point2D{
    protected double z;

    public Point3D() {
    }

    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public void setXYZ(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double[] getXYZ(){
        return new double[]{x,y,z};
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "z=" + z +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}

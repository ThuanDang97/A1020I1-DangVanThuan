package B6_Ke_Thua.BaiTap.PointandMoveablePoint;

public class MoveablePoint extends Point{
    private double xSpeed;
    private double ySpeed;

    public MoveablePoint() {
    }

    public MoveablePoint(double xSpeed, double ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint(double x, double y, double xSpeed, double ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public double getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(double xSpeed) {
        this.xSpeed = xSpeed;
    }

    public double getySpeed() {
        return ySpeed;
    }

    public void setySpeed(double ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(double xSpeed, double ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public double[] getSpeed(){
        return new double[] {xSpeed, ySpeed};
    }

    @Override
    public String toString() {
        return "MoveablePoint{" +
                "Speed= (" + xSpeed + ", "+ ySpeed +
                ")," + super.toString();
    }

    public String move(){
        this.x += xSpeed;
        this.y += ySpeed;
        return "x = " + x + ", y = " + y;
    }
}

package B4_Class_And_OOP.BaiTap;

public class Fan {
    final int slow = 1;
    final int medium = 2;
    final int fast = 3;
    private int speed = this.slow;
    private boolean on = false;
    private double radius = 5;
    private String color = "Blue";

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Fan() {
    }

    @Override
    public String toString() {
        return "Fan{" +
                "speed=" + speed +
                ", on=" + on +
                ", radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }

    public static void main(String[] args) {
        // Fan 1:
        Fan fan1 = new Fan();
        fan1.setSpeed(fan1.fast);
        fan1.setRadius(10);
        fan1.setColor("Yellow");
        fan1.setOn(true);
        System.out.println(fan1);
        //Fan 2:
        Fan fan2 = new Fan();
        fan2.setSpeed(fan1.medium);
        fan2.setRadius(5);
        fan2.getColor();
        fan2.isOn();
        System.out.println(fan2);
    }
}

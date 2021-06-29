package B5_AccessModifier.ThucHanh.ThucHanh;

public class main {
    public static void main(String[] args) {

        StaticProperty.Car car1 = new StaticProperty.Car("Mazda 3","Skyactiv 3");

        System.out.println(StaticProperty.Car.numberOfCars);

        StaticProperty.Car car2 = new StaticProperty.Car("Mazda 6","Skyactiv 6");

        System.out.println(StaticProperty.Car.numberOfCars);
        System.out.println();
    }
}

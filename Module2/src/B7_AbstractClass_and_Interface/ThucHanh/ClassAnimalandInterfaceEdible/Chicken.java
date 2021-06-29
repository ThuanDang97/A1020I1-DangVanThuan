package B7_AbstractClass_and_Interface.ThucHanh.ClassAnimalandInterfaceEdible;

public class Chicken extends Animal implements Edible{
    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck!";
    }

    @Override
    public String howToEat() {
        return "could be fried";
    }
}

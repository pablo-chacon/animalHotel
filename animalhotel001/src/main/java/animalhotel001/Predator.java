package animalhotel001;

public class Predator extends Animal {

    //Constructor,
    public Predator(String name, String activity, String food) {
        super(name, activity, food);
    }

    //Override super.
    @Override
    public String getInfo() {
        String s = super.getInfo();
        return s + " ";
    }
}



package animalhotel001;

public class Meek extends Animal {

    //Constructor
    public Meek(String name, String activity, String food) {
        super(name, activity, food);
    }



    @Override
    public String getInfo() {
        String s = super.getInfo();
        return s + " ";
    }





}

package animalhotel001;

public class Bird extends Animal {

    //Constructor
   public Bird(String name, String activity, String food) {
        super(name, activity, food);
    }



    @Override
    public String getInfo() {
        String s = super.getInfo();
        return s + " ";
    }
}
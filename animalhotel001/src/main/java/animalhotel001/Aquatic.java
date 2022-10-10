package animalhotel001;

public class Aquatic extends Animal {

     //Constructor
      public Aquatic(String name, String favoriteActivity, String favoriteFood) {
         super(name, favoriteActivity, favoriteFood);
      }


    @Override
    public String getInfo() {
        String s = super.getInfo();
        return s + " ";
    }
}





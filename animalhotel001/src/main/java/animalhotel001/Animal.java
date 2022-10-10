package animalhotel001;

public class Animal {

    //Attributes
    private String name;
    private String activity;
    private String food;

    //Constructor
    public Animal(String name, String favoriteActivity, String food) {

        this.setName(name);
        this.setActivity(favoriteActivity);
        this.setFood(food);
    }

    //Getters/Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getInfo() {
        return (name + " " + " " + " Favorite activity:" + " " + activity + "\nFavorite food:" + " " + food);
    }
}



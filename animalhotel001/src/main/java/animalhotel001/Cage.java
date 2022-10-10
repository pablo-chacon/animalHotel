package animalhotel001;

public class Cage extends Room {

    //Constructor
    public Cage(String roomNum, int price) {
        super(roomNum, price);
        roomType = "Cage";
    }

    //Method
    public String getDescription() {
        String description = "Comfy cage with a view.";
        return description;
    }
}

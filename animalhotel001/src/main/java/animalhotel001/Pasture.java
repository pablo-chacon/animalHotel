package animalhotel001;

public class Pasture extends Room {

    //Constructor
    public Pasture(String roomNum, int price) {
        super(roomNum, price);
        roomType = "Pasture";
    }

    //Method
    public String getDescription() {
        String description = "PastureLand";
        return description;
    }
}

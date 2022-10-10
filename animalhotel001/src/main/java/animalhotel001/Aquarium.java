package animalhotel001;

public class Aquarium extends Room {

    //Constructor
    public Aquarium(String roomNum, int price) {
        super(roomNum, price);
        roomType = "Aquarium";
    }

    //Method Override
    public String getDescription() {
        return  "Aquarium with mermaid background.";

    }
}

package animalhotel001;

public class Room {

    //Attributer
    public String roomType;
    public String roomNum;
    public int price;
    public String description;
    public Animal guest;
    public boolean isAvailable;


    //Necessary constructors for room management.
    public Room(String roomNum, int price, Animal guest) {

        this.setRoomNum(roomNum);
        this.setPrice(price);
        this.setDescription(" normal room with normal sized bed");
        this.setGuest(guest);
        this.roomType = "Room";
        isAvailable = false;
    }

    public Room(String roomNum, int price) {

        this.setRoomNum(roomNum);
        this.setPrice(price);
        this.setDescription(" normal room with normal sized bed");
        this.roomType = "Room";
        isAvailable = true;
    }

    public Room() {}


    //Getters & Setters
    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    //Overriding method --> overridden in the three separate sub-room classes
    String getDescription() {
        return "Rooms by Animals, For Animals";
    }

    private void setDescription(String description) {
        this.description = description;
    }

    public Animal getGuest() {
        return guest;
    }

    public void setGuest(Animal guest) {
        this.guest = guest;
        isAvailable = false;
    }

    //Methods

    public void book(Animal a) {
        guest = a;
        isAvailable = false;
    }

    public void removeBooking() {
        guest = null;
        isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getStatus() {
        if (isAvailable)
            return "Available.";
        else
            return "Occupied.";
    }

    public String toString() {
        return roomNum + " " + price + " " + description + " " + guest + " "
                + isAvailable;
    }

}
package animalhotel001;


import java.util.ArrayList;
import java.util.Scanner;

public class HotSys {

    static ArrayList<Room> rooms = new ArrayList<>();

    static String slogan;

    public HotSys(String slogan) {
        this.slogan = slogan;
    }


    public static void start() {

        //Read only rooms, Hard coded.
        Pasture room02 = new Pasture("101", 20);
        rooms.add(room02);

        Cage room03 = new Cage("102", 50);
        rooms.add(room03);

        Aquarium room04 = new Aquarium("103", 60);
        rooms.add(room04);


        boolean runProgram = true;
        while (runProgram) {
            printMenu();
            int dataInput = getUserInt();
            switch (dataInput) {
                case 1 -> outputRooms();
                case 2 -> newBooking();
                case 3 -> outputBookings();
                case 4 -> updateBooking();
                case 5 -> deleteBooking();
                case 6 -> searchBookings();
                case 7 -> searchGuests();
                case 8 -> {
                    runProgram = false;
                    System.out.println(" Thank you and welcome back");
                }
            }
        }
    }

    public static void printMenu() {
        System.out.println("""
        ============================
        The shittiest hotel of all.
        ============================
        1. List Availability.
        2. Book/Check-in.
        3. Display bookings.
        4. Update booking.
        5. Delete/Check-out.
        6. Search booking.
        7. Filter search.
        8. Quit program.
        =============================""");
    }


    public static String getUserString() {
        Scanner myScan = new Scanner(System.in);
        String userInput = myScan.nextLine();

        return userInput;
    }

    public static int getUserInt() {
        //Convert int to String.
        Scanner myScan = new Scanner(System.in);
        int userInput;

        while (true) {
            try {
                userInput = Integer.parseInt(myScan.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Only numbers allowed. Try again");
            }

        }
        return userInput;
    }

    //For-Each loop through all Arraylist.
    public static void outputRooms() {
        System.out.println(slogan);
        System.out.println(" \n");

        int counter = 1;
        for (Room rooms : HotSys.rooms) {
            System.out.println(counter + ". " + rooms.roomType + ": " + rooms.getStatus() + " - " + rooms.getDescription() + " and it costs " + rooms.getPrice() + " $ /night");
            counter++;
        }
    }

    //Output loop results.
    public static void outputBookings() {

        int counter = 1;
        for (Room rooms : HotSys.rooms) {
            if (!rooms.isAvailable()) {
                System.out.println(" " + rooms.roomType + " Rooms Number " + counter + ":  " + rooms.getStatus() + " by " + rooms.getGuest().getName() +
                        ("\nFavorite food: ") + rooms.getGuest().getFood() + ("\nFavorite activity: ") + rooms.getGuest().getActivity());
            }
            counter++;
        }
    }

    public static void newBooking() {
        System.out.println("Rooms available:\n> ");
        outputRooms();

        System.out.println("Input guest info:\nAnimal type:\n> ");
        String animalType = getUserString();

        System.out.println("Name:\n> ");
        String guestName = getUserString();

        System.out.println("Favorite activity:\n> ");
        String favoriteActivity = getUserString();

        System.out.println("Favorite food");
        String favoriteFood = getUserString();

        outputRooms();
        System.out.println("Choose Rooms:\n> ");
        int r = Integer.parseInt(getUserString());
        System.out.println("Rooms " + r + " is booked.");

        switch (animalType) {
            case "Meek" -> {
                Meek myMeek = new Meek(guestName, favoriteActivity, favoriteFood);
                rooms.get(r - 1).book(myMeek);
            }
            case "Aquatic" -> {
                Aquatic myAquatic = new Aquatic(guestName, favoriteActivity, favoriteFood);
                rooms.get(r - 1).book(myAquatic);

            }
            case "Bird" -> {
                Bird myBird = new Bird(guestName, favoriteActivity, favoriteFood);
                rooms.get(r - 1).book(myBird);
            }
            case "Predator" -> {
                Predator myPredator = new Predator(guestName, favoriteActivity, favoriteFood);
                rooms.get(r - 1).book(myPredator);

            }
            default -> {
                Animal x = new Animal(guestName, favoriteActivity, favoriteFood);
                rooms.get(r - 1).book(x);
            }
        }
    }

    public static void updateBooking() {

        System.out.println("Update Room Number:\n> ");
        int n1 = getUserInt();

        System.out.println("Update:\n1. Favourite Activity\n2. Favourite Food");

        int n2 = getUserInt();
        System.out.println(" Other Update?");
        String s = getUserString();
        // End User int -1 to correct arrayList index.
        if (n2 == 1 && !rooms.get(n1 - 1).isAvailable) {
            rooms.get(n1 - 1).getGuest().setActivity(s);
        } else if (n2 == 2 && !rooms.get(n1 - 1).isAvailable) {
            rooms.get(n1 - 1).getGuest().setFood(s);

        } else {
            System.out.println("Invalid input");
        }
    }

    public static void searchBookings() {
        /*
        If statement to validate User Input as String, Integer or invalid.
        For loop through Arraylist index.
        */
        System.out.println("Search:\n> ");
        String s1 = getUserString();

        if (s1.equals("guest")) {
            System.out.println("Guest name:\n> ");
            String s2 = getUserString();
            String resp = "No guest with that name.";
            for (int i = 0; i < rooms.size(); i++) {
                if (!rooms.get(i).isAvailable()) {

                    if (rooms.get(i).getGuest().getName().equals(s2)) {
                        resp = (rooms.get(i).getGuest().getInfo() + "\n" +
                                "Rooms " + rooms.get(i).getRoomNum() + ", " + rooms.get(i).getPrice() + "$/night\n"
                                + rooms.get(i).getDescription());
                        i = rooms.size();
                    }
                }
            }
            System.out.println(resp);

        } else if (s1.equals("room")) {
            System.out.println("Rooms number:\n> ");
            int n = getUserInt() - 1;
            if (!rooms.get(n).isAvailable()) {
                System.out.println(rooms.get(n).getGuest().getInfo());

            } else {
                System.out.println("Rooms is available.");
            }

        } else {
            System.out.println("Invalid input");
        }
    }


    public static void searchGuests() {
        System.out.println("Name Search:\n> ");
        String letter = getUserString().toLowerCase();
        boolean target = false;

        // Input to lower case for search purpose. Loop through Arraylist, if statements to find matching elements.
        for (int i = 0; i < rooms.size(); i++) {
            //Find matching objects by comparing.
            if (rooms.get(i).getGuest() != null && rooms.get(i).getGuest().getName().toLowerCase().contains(letter)) {
                System.out.println("Guest name: " + rooms.get(i).getGuest().getName());
                target = true;
            }
            if (!target) {
                System.out.println("Couldn't find any matching results." + letter);
            }
        }
    }

    public static void deleteBooking() {
        System.out.println("Room number:");
        int n = getUserInt();

        if (!rooms.get(n - 1).isAvailable()) {
            rooms.get(n - 1).removeBooking();
            System.out.println("Booking canceled");

        } else {
            System.out.println(" This room is not booked");
        }
    }
}







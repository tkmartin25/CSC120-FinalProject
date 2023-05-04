import java.util.ArrayList;

/** creates a train composed of an engine and a number of cars */
public class House {
    String name;
    int year_built;
    private ArrayList<Room> rooms;
    int num_floors;

    /** train constructor */
    public House() {
        this.name = "Haunted House";
        this.year_built = 1727;
        this.rooms = new ArrayList<Room>();
    }


    /** 
    * adds an existing room to house
    * @param room to be added to house
    */
    public void addRoom(Room r) {
        rooms.add(r);
    }
    
    /** for testing */
    public static void main(String[] args) {
        User User = new User("Babby");
        House Haunted_House = new House();
        Room Foyer = new Room("Foyer", 80, 100, 120, 200, 0, 100, 1);
        Room LivingRoom = new Room("Living Room", 120, 150, 0, 120, 0, 150, 1);
        Room DiningRoom = new Room("Dining Room", 100, 60, 200, 300, 0, 60, 1);
        Room Kitchen = new Room ("Kitchen", 100, 90, 200, 300, 60, 150, 1);
        Room Bathroom = new Room("Bathroom", 50, 50, 250, 300, 150, 200, 1);
        Room Closet = new Room("Closet", 10, 50, 190, 200, 100, 150, 1);
        Haunted_House.addRoom(Foyer);
        Haunted_House.addRoom(LivingRoom);
        Haunted_House.addRoom(DiningRoom);
        Haunted_House.addRoom(Kitchen);
        Haunted_House.addRoom(Bathroom);
        Haunted_House.addRoom(Closet);
        User.checkCoordinates();
        User.go("up");
        User.enter();
        User.checkCoordinates();
        //User.checkLocation();
        User.go("a");
        User.go("up");
        User.checkCoordinates();
        User.go("d");
        User.go("d");
        User.go("up");
        User.go("w");
        User.go("a");
        User.go("d");
        User.go("w");
        User.checkTracker();
    }



}

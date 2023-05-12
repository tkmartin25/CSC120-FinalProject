import java.util.ArrayList;


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

    /**
    * builds house with predetermined rooms
    */
    public void buildHouse() {
        Room Foyer = new Room("Foyer", 80, 100, 120, 200, 0, 100, 1);
        Room LivingRoom = new Room("Living Room", 120, 150, 0, 120, 0, 150, 1);
        Room DiningRoom = new Room("Dining Room", 100, 60, 200, 300, 0, 60, 1);
        Room Kitchen = new Room ("Kitchen", 100, 90, 200, 300, 60, 150, 1);
        Room SecretRoom = new Room("Secret Room", 50, 50, 250, 300, 150, 200, 1);
        Room Bathroom = new Room("Bathroom", 70, 50, 120, 200, 150, 200, 1);
        Room Closet = new Room("Closet", 10, 50, 190, 200, 100, 150, 1);
        Room MasterBedroom = new Room("Master Bedroom", 120, 130, 0, 120, 0, 130, 2);
        Room Office = new Room("Office", 80, 50, 120, 200, 100, 150, 2);
        Room MasterBathroom = new Room("Master Bathroom", 70, 20, 0, 70, 130, 150, 2);
        Room Closet2 = new Room("Master Closet", 50, 20, 70, 120, 130, 150, 2);
        Room Bedroom = new Room("Bedroom", 100, 90, 200, 300, 0, 90, 2);
        Room Hallway = new Room("Hallway", 180, 10, 120, 300, 90, 100, 2);
        Room Bathroom2 = new Room("Bathroom", 180, 10, 120, 300, 90, 100, 2);
        Room Attic = new Room("Attic", 300, 150, 0, 300, 0, 150, 3);
        Item Potion = new Item("Healing Potion", "Potion", "", 0);
    }
    




}

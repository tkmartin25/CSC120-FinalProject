import java.util.ArrayList;

/** House class */
public class House {

    /** name of house */
    String name;

    /** year the house was built */
    int year_built;

    /** an array list that stores all the rooms of the house */
    public ArrayList<Room> rooms;

    /** number of floors of the house */
    int num_floors;

    /** house constructor */
    public House() {
        this.name = "Haunted House";
        this.year_built = 1727;
        this.rooms = new ArrayList<Room>();
        this.num_floors = 4;
    }

    /**
    * adds an existing room to the house
    * @param room to be added to house
    */
    public void addRoom(Room r) {
        rooms.add(r);
    }

    /**
    * builds house with predetermined rooms
    */
    public void buildHouse() {
        Room Foyer = new Room("Foyer", 80, 100, 120, 200, 0, 100, 1, "A quaint room with a grand staircase leading upstairs. Towards the left of the room, you see status of an elephant, a ghost, and a ghoul.");
        Room LivingRoom = new Room("Living Room", 120, 150, 0, 120, 0, 150, 1, "A very large room with red couches. On the ceiling, you see a painting of bubble tea.");
        Room DiningRoom = new Room("Dining Room", 100, 60, 200, 300, 0, 60, 1, "A room with a long dining table with eight chairs. There is a chandelier from the ceiling.");
        Room Kitchen = new Room ("Kitchen", 100, 90, 200, 300, 60, 150, 1, "A pristinely clean kitchen with many cabinets for storage. At the center of the room, you see potions.");
        Room SecretRoom = new Room("Secret Room", 50, 50, 250, 300, 150, 200, 1, "An empty room. You see a scroll on the floor that reads: Do not drink the red potion.");
        Room Bathroom = new Room("Bathroom", 70, 50, 120, 200, 150, 200, 1, "A regular bathroom. There is a painting of an old sailor on the wall.");
        Room Closet = new Room("Closet", 10, 50, 190, 200, 100, 150, 1, "A closet that seems to have a locked latch on the ground. You wonder where it leads to. On the wall, you see a painting of a young girl holding a yellow dog in a lemon orchard.");
        Room MasterBedroom = new Room("Master Bedroom", 120, 130, 0, 120, 0, 130, 2, "A room with a grand bed that looks perfect for jumping on.");
        Room Office = new Room("Office", 80, 50, 120, 200, 100, 150, 2, "An office room with two windows. There are five bookshelves.");
        Room MasterBathroom = new Room("Master Bathroom", 70, 20, 0, 70, 130, 150, 2, "A small but beautiful bathroom. The tiles on the floor are royal blue. You notice a name carved into one of the walls near the floor: Juliet.");
        Room Closet2 = new Room("Master Closet", 50, 20, 70, 120, 130, 150, 2, "A closet full of clothes.");
        Room Bedroom = new Room("Bedroom", 100, 90, 200, 300, 0, 90, 2, "A children's bedrom. There are many dolls in the room but one of them perched on top of the shelf catches your eye. On her necklace, you see the initial E.");
        Room Hallway = new Room("Hallway", 180, 10, 120, 300, 90, 100, 2, "A hallway with 7 different portraits against the wall. There is a latch on the ceiling leading to the attic.");
        Room Bathroom2 = new Room("Bathroom", 180, 10, 120, 300, 90, 100, 2, "A bathroom full of cobwebs. There is a black and white painting on the wall of 6 women. The one in the middle seems to be staring at you directly.");
        Room Attic = new Room("Attic", 300, 150, 0, 300, 0, 150, 3, "It's dark.");
        rooms.add(Foyer);
        rooms.add(LivingRoom);
        rooms.add(Kitchen);
        rooms.add(SecretRoom);
        rooms.add(Bathroom);
        rooms.add(Closet);
        rooms.add(MasterBedroom);
        rooms.add(Office);
        rooms.add(MasterBathroom);
        rooms.add(Closet2);
        rooms.add(Bedroom);
        rooms.add(Hallway);
        rooms.add(DiningRoom);
        rooms.add(Bathroom2);
        rooms.add(Attic);
    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class User {

    /** player name */
    String name;

    /** favorite food, used in determining what the golden potion smells like */
    static String favorite_thing;

    /** alive or dead */
    boolean living;

    /** current energy level  */
    int current_energy;

    /** maximum energy level */
    int max_energy;

    /** size of character */
    // am planning to have places you can only access if you are a certain size
    int size;

    /** max size character can reach */
    int maxSize;

    /** min size character can reach */
    int minSize;

    /** x coordinate of house where character is located */
    int house_x;

    /** y coordinate of house where character is located */
    int house_y;

    /** which floor the user is on */
    int floor;

    /** stores which items user possesses */
    ArrayList<Item> items;

    /** player's notebook to write in */
    ArrayList<String> notebook;

    /** device that can be used by the player to see all locations the player has been to */
    ArrayList<String> tracker;

    /** note to be added to the player's notebook */
    String note;

    /** if the player has won yet */
    static boolean win;

    /** User constructor
     * @param name
     * @param favorite_thing
     */
    public User(String name, String favorite_thing) {
        this.name = name;
        this.favorite_thing = favorite_thing;
        this.living = true;
        this.max_energy = 100;
        this.current_energy = max_energy;
        this.size = 50;
        this.maxSize = 90;
        this.minSize = 10;
        this.house_x = -1;
        this.house_y = -1;
        this.floor = -1;
        this.notebook = new ArrayList<String>(5);
        this.tracker = new ArrayList<String>();
        this.items = new ArrayList<Item>();
        this.win = false;
    }

    /** 
     * function for entering Haunted House 
     */
    public void enter(){
        if (this.house_x < 0 || this.house_y < 0) {
            this.house_x = 160;
            this.house_y = 1;
            this.floor = 1;
            this.track();
            System.out.println("You have entered the Haunted House.");
        }
        else {
            throw new RuntimeException("You are already in the Haunted House.");
        }
    }

    /**
     * function to easily change energy levels
     * @param e integer amount of energy to change current_energy by
     */
    public void changeEnergy(int e) {
        // e is positive, increase in energy
        if (e > 0) {
            // increasing energy
            if  (this.current_energy + e <= this.max_energy) {
                this.current_energy = this.current_energy + e;
            }
            // ensuring that current energy does not exceed max energy
            else if (this.current_energy + e > this.max_energy) {
                this.current_energy = this.max_energy;
            }
        }
        // e is negative, decrease in energy
        else if (e < 0) {
            // current energy minus e will not lead to zero energy
            if (this.current_energy > e) {
                this.current_energy = this.current_energy + e;
            }
            else {
                System.out.println("Your energy is too low. You died.");
                this.living = false;
            }
        }
    }

    /**
     * allows user to see how much energy they have and their max energy
     */
    public void checkEnergy() {
        System.out.println("Your current energy level is " + this.current_energy + ", with a max energy level of " + this.max_energy + ".");
    }

    /**
     * checks if user's current location is in tracker. If not, it adds the location to the tracker.
     */
    public void track() {
        if (!this.tracker.contains(this.Locate())) {
            this.tracker.add(this.Locate());
        }
    }

    /**
     * prints out which rooms the user has been in
     */
    public void checkTracker() {
        for(int i = 0; i < this.tracker.size(); i++){
            System.out.println(this.tracker.get(i));
        }
    }

    /**
     * prints out which items are in the user's posession
     */
    public void checkItems() {
        System.out.println("Here are the items currently in your posession: ");
        for(int i = 0; i < this.items.size(); i++){
            System.out.println(i + ": " + this.items.get(i).name);
        }
    }

    /**
     * adds items to user's posession
     * @param item item to be taken into posession
     */
    public void take(Item item) {
        if (this.Locate() == item.initial_location && !this.items.contains(item)) {
            this.items.add(item);
        }
        else {
            System.out.println("You can't take an item you aren't near.");
        }
    }

    /**
    * based on the direction north, south, east, or west, the bat moves coordinates by a unit of 1
    * @param direction for bat to walk in
    */
    public void go(String direction) {
        // formatting of user inputted direction
        direction = direction.toLowerCase();
        // moving up 1 floor
        if (direction == "up") {
            if (this.Locate() == "Foyer" && tracker.contains("Bathroom") && tracker.contains("Closet")) {
                this.floor = 2;
                this.house_x = 195;
                this.house_y = 95;
                System.out.println("You walked up the stairs to the second floor hallway.");
            }
            else if (this.Locate() == "Hallway" && tracker.contains("Master Bathroom") && tracker.contains("Office") && tracker.contains("Bedroom")) {
                Scanner UserInputAttic = new Scanner(System.in);
                System.out.println("Are you sure you want to go up? You won't be able to come back down if you choose to go up now. (Y or N)");
                String UserInputAtticChoice = UserInputAttic.nextLine();
                if (UserInputAtticChoice.equals("Y")) {
                    Room Attic = new Room("Attic", 300, 150, 0, 300, 0, 150, 3, "It's dark.");
                    Lucretia Lucretia = new Lucretia(Attic);
                    this.floor = 3;
                    this.house_x = 150;
                    this.house_y = 100;
                    System.out.println("You pulled the ceiling tab and climbed up to the attic.");
                    System.out.println("You see a ghost in the center of the room. She makes her way over to you.");
                    Lucretia.firstTest();
                    Lucretia.secondTest();
                    if (this.living = true) {
                        Lucretia.thirdTest();
                    }
                }
                else {
                    System.out.println("You decided against going up to the attic.");
                }
            }
            else {
                System.out.println("You can't go up from here.");
            }
        }
        // moving down 1 floor
        else if (direction == "down") {
            if (this.Locate() == "Hallway") {
                this.floor = 1;
                this.house_x = 195;
                this.house_y = 10;
                System.out.println("You walked down the stairs to the foyer.");
            }
            else {
                System.out.println("You can't go down from here.");
            }
        }
        // moving to the left
        else if (direction == "a") {
            if (this.Locate() == "Foyer") {
                this.house_x = 115;
                this.house_y = 10;
                System.out.println("You are now in the living room.");
            }
            else if (this.Locate() == "Dining Room") {
                this.house_x = 195;
                this.house_y = 10;
                System.out.println("You are now in the foyer.");
            }
            else if (this.Locate() == "Kitchen") {
                this.house_x = 195;
                this.house_y = 140;
                System.out.println("You are now in the closet.");
            }
            else if (this.Locate() == "Bathroom" && this.floor == 1) {
                this.house_x = 115;
                this.house_y = 110;
                System.out.println("You are now in the living room.");
            }
            else if (this.Locate() == "Hallway" && this.house_x < 200) {
                this.house_x = 115;
                this.house_y = 65;
                System.out.println("You are now in the master bedroom.");
            }
            else if (this.Locate() == "Hallway" && this.house_x > 200) {
                this.house_x = 160;
                this.house_y = 95;
                System.out.println("You moved to the other side of the hallway.");
            }
            else if (this.Locate() == "Master Bedroom" && this.house_x > 70) {
                this.house_x = 35;
                this.house_y = 65;
                System.out.println("You moved to the other side of the master bedroom.");
            }
            else {
                System.out.println("You can't go to the left from here.");
            }
        }
        // moving to the right
        else if (direction == "d") {
            if (this.Locate() == "Living Room" && this.house_y < 100) {
                this.house_x = 125;
                this.house_y = 10;
                System.out.println("You are now in the foyer.");
            }
            else if (this.Locate() == "Living Room" && this.house_y > 100) {
                this.house_x = 125;
                this.house_y = 110;
                System.out.println("You are now in the first floor bathroom.");
            }
            else if (this.Locate() == "Foyer") {
                this.house_x = 205;
                this.house_y = 10;
                System.out.println("You are now in the dining room.");
            }
            else if (this.Locate() == "Closet" && this.floor == 1) {
                this.house_x = 205;
                this.house_y = 140;
                System.out.println("You are now in the kitchen.");
            }
            else if (this.Locate() == "Master Bedroom" && this.house_x < 70) {
                this.house_x = 115;
                this.house_y = 65;
                System.out.println("You moved to the other side of the master bedroom.");
            }
            else if (this.Locate() == "Master Bedroom" && this.house_x > 70) {
                this.house_x = 160;
                this.house_y = 95;
                System.out.println("You are now in the hallway.");
            }
            else if (this.Locate() == "Hallway" && this.house_x < 200) {
                this.house_x = 250;
                this.house_y = 95;
                System.out.println("You moved to the other side of the hallway.");
            }
            else {
                System.out.println("You can't go to the right from here.");
            }
        }
        // moving "up", towards the back of the house
        else if (direction == "w") {
            if (this.Locate() == "Dining Room") {
                this.house_x = 250;
                this.house_y = 70;
                System.out.println("You are now in the kitchen.");
            }
            else if (this.Locate() == "Kitchen" && this.size < 31) {
                this.house_x = 275;
                this.house_y = 160;
                System.out.println("You are now in a small room.");
            }
            else if (this.Locate() == "Living Room" && this.house_y < 100) {
                this.house_x = 60;
                this.house_y = 110;
                System.out.println("You moved to the other side of the living room.");
            }
            else if (this.Locate() == "Master Bedroom" && this.house_x < 70) {
                this.house_x = 35;
                this.house_y = 140;
                System.out.println("You are now in the master bathroom.");
            }
            else if (this.Locate() == "Master Bedroom" && this.house_x > 70) {
                this.house_x = 95;
                this.house_y = 140;
                System.out.println("You are now in the closet.");
            }
            else if (this.Locate() == "Hallway" && this.house_x < 200) {
                this.house_x = 160;
                this.house_y = 125;
                System.out.println("You are now in the office.");
            }
            else if (this.Locate() == "Hallway" && this.house_x > 200) {
                this.house_x = 250;
                this.house_y = 125;
                System.out.println("You are now in the bathroom.");
            }
            else if (this.Locate() == "Bedroom") {
                this.house_x = 250;
                this.house_y = 95;
                System.out.println("You are now in the hallway.");
            }
            else {
                System.out.println("You can't go towards the back of the house from here.");
            }
        }
        // moving "down", towards the front of the house
        else if (direction == "s") {
            if (this.Locate() == "Secret Room") {
                this.house_x = 275;
                this.house_y = 140;
                System.out.println("You are now in the kitchen.");
            }
            else if (this.Locate() == "Kitchen") {
                this.house_x = 250;
                this.house_y = 50;
                System.out.println("You are now in the dining room.");
            }
            else if (this.Locate() == "Living Room" && this.house_y > 100) {
                this.house_x = 60;
                this.house_y = 10;
                System.out.println("You moved to the other side of the living room.");
            }
            else if (this.Locate() == "Master Bathroom") {
                this.house_x = 35;
                this.house_y = 65;
                System.out.println("You are now in the master bedroom.");
            }
            else if (this.Locate() == "Closet" && this.floor == 2) {
                this.house_x = 115;
                this.house_y = 65;
                System.out.println("You are now in the master bedroom.");
            }
            else if (this.Locate() == "Hallway" && this.house_x > 200) {
                this.house_x = 250;
                this.house_y = 45;
                System.out.println("You are now in the bedroom.");
            }
            else if (this.Locate() == "Office") {
                this.house_x = 160;
                this.house_y = 95;
                System.out.println("You are now in the hallway.");
            }
            else if (this.Locate() == "Bathroom" && this.floor == 2) {
                this.house_x = 250;
                this.house_y = 95;
                System.out.println("You are now in the hallway.");
            }
            else {
                System.out.println("You can't go towards the front of the house from here.");
            }
        }
        else {
            throw new RuntimeException("Error: You must input one of the following four directions: 'up', 'down', 'left', or 'right'.");
        }
        this.track();
    }

    /**
     * allows user to write in their notebook
     */
    public void write(){
        Scanner userInput = new Scanner(System.in); 
        System.out.println("Would you like to write in the notebook? You have " + (5 - notebook.size()) + " page(s) remaining. (Y/N)");
        String userChoice = userInput.nextLine();
        if (userChoice.equals("Y") && (5 - notebook.size()) > 0) {
            Scanner userNote = new Scanner(System.in); 
            System.out.println("Write your note for page " + (notebook.size() + 1) + ".");
            String note = userNote.nextLine();
            notebook.add(note);
        }
        else if (userChoice.equals("Y") && (5 - notebook.size()) == 0) {
            System.out.println("Sorry, but you already filled up the notebook.");
        }
        else if (userChoice.equals("N")) {
            System.out.println("You decided not to write in the notebook.");
        }
        else {
            System.out.println(userChoice);
            throw new RuntimeException("Invalid response.");
        }
    }

    /**
     * allows user to read notes that they wrote in their notebook
     * @param pagenum page number of notebook to be read
     */
    public void read(int pagenum) {
        if (pagenum <= notebook.size()) {
            System.out.println("On page " + pagenum + ", you wrote:\n" + notebook.get(pagenum - 1));
        }
        else {
            System.out.println("Page " + pagenum + " is blank.");
        }
    }

    /**
     * allows user to get a description of an item
     * @param item to be examined
     */
    public void examine(Item item) {
        if (this.items.contains(item)) {
            System.out.println(item.name + ": " + item.description);
        }
        else {
            System.out.println("Pick an item that you have with you.");
        }
    }

    /**
     * allows user to check what coordinates they are at
     */
    public void checkCoordinates() {
        System.out.println(this.name + " is at (" + this.house_x + ", " + this.house_y + ", " + this.floor + ").");
    }

    /**
     * locates user in terms of which room they are in in the house
     * @return name of room that the user is currently in
     */
    public String Locate() {
        if (this.house_x < 0 || this.house_y < 0) {
            return("Outside");
        }
        else if (this.floor == 1) {
            if (this.house_x > 120 && this.house_x < 200 && this.house_y > 0 && this.house_y < 100) {
                return("Foyer");
            }
            else if (this.house_x > 0 && this.house_x < 120 && this.house_y > 0 && this.house_y < 150) {
                return("Living Room");
            }
            else if (this.house_x > 200 && this.house_x < 300 && this.house_y > 0 && this.house_y < 60) {
                return("Dining Room");
            }
            else if (this.house_x > 200 && this.house_x < 300 && this.house_y > 60 && this.house_y < 150) {
                return("Kitchen");
            }
            else if (this.house_x > 250 && this.house_x < 300 && this.house_y > 150 && this.house_y < 200) {
                return("Secret Room");
            }
            else if (this.house_x > 190 && this.house_x < 200 && this.house_y > 100 && this.house_y < 150) {
                return("Closet");
            }
            else if (this.house_x > 120 && this.house_x < 190 && this.house_y > 100 && this.house_y < 150) {
                return("Bathroom");
            }
            else {
                return("First floor--somewhere.");
            }
        }
        else if (this.floor == 2) {
            if (this.house_x > 120 && this.house_x < 300 && this.house_y > 90 && this.house_y < 100) {
                return("Hallway");
            }
            else if (this.house_x > 0 && this.house_x < 120 && this.house_y > 0 && this.house_y < 130) {
                return("Master Bedroom");
            }
            else if (this.house_x > 0 && this.house_x < 70 && this.house_y > 130 && this.house_y < 150) {
                return("Master Bathroom");
            }
            else if (this.house_x > 70 && this.house_x < 120 && this.house_y > 130 && this.house_y < 150) {
                return("Closet");
            }
            else if (this.house_x > 120 && this.house_x < 200 && this.house_y > 100 && this.house_y < 150) {
                return("Office");
            }
            else if (this.house_x > 200 && this.house_x < 300 && this.house_y > 100 && this.house_y < 150) {
                return("Bathroom");
            }
            else if (this.house_x > 200 && this.house_x < 300 && this.house_y > 0 && this.house_y < 90) {
                return("Bedroom");
            }
            else {
                return("Second floor.");
            }
        }
        else if (this.floor == 3) {
            return("Attic");
        }
        else {
            return("Inside Haunted House.");
        }
    }

    /**
     * increases character's size
     * @param size integer amount for character's size to change
     */
    public void changeSize(int size){
        if (size > 0) {
            if (this.size + size < this.maxSize) {
                this.size = this.size + size;
            }
            else {
                this.size = this.maxSize;
            }
            System.out.println(this.name + " is now this size: " + this.size);
        }
        else if (size < 0) {
            if (this.size + size > this.minSize) {
                this.size = this.size + size;
            }
            else {
                this.size = this.minSize;
            }
            System.out.println(this.name + " is now this size: " + this.size);
        }
        else {
            System.out.println("No change to size.");
        }
    }

    /**
     * allows user to see their current size
     */
    public void checkSize() {
        System.out.println("Your current size is " + this.size + ".");
    }

    /**
     * accessor for player's favorite food
     * @return favorite_thing
     */
    public static String getfavorite_thing() {
        return favorite_thing;
    }

    /**
     * User dies, ending game
     */
    public void die() {
        this.living = false;
    }

    /**
     * User wins, ending game
     */
    public static void win() {
        win = true;
    }

    /**
     * @param potion to drink
     */
    public void drink(Item potion){
        System.out.println(this.name + " drank a " + potion.name + ".");
        this.changeEnergy(potion.effect);
        this.changeSize(potion.effectsize);
    }
}
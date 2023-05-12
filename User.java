import java.util.ArrayList;
import java.util.Scanner;

public class User {

    /** character name */
    String name;

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

    /** x coordinate of house where character is located */
    int house_x;

    /** y coordinate of house where character is located */
    int house_y;

    /** which floor the user is on */
    int floor;

    /** stores which items user possesses */
    ArrayList<Item> items;

    ArrayList<String> notebook;

    ArrayList<String> tracker;

    String note;

    /** Default constructor
     * @param name
     * @param favorite_thing
     */
    public User(String name, String favorite_thing) {
        this.name = name;
        this.favorite_thing = favorite_thing;
        this.living = true;
        this.max_energy = 100;
        this.current_energy = this.max_energy;
        this.house_x = -1;
        this.house_y = -1;
        this.floor = -1;
        this.notebook = new ArrayList<String>(5);
        this.tracker = new ArrayList<String>();
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
    private void track() {
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
    * based on the direction north, south, east, or west, the bat moves coordinates by a unit of 1
    * @param direction for bat to walk in
    */
    public void go(String direction){
        // formatting of user inputted direction
        direction = direction.toLowerCase();
        // moving up 1 floor
        if (direction == "up") {
            if (this.Locate() == "Foyer") {
                this.floor = 2;
                this.house_x = 195;
                this.house_y = 95;
                System.out.println("You walked up the stairs to the second floor hallway.");
            }
            else if (this.Locate() == "Hallway") {
                Scanner UserInputAttic = new Scanner(System.in);
                System.out.println("Are you sure you want to go up? You won't be able to come back down if you choose to go up now. (Y or N)");
                String UserInputAtticChoice = UserInputAttic.nextLine();
                if (UserInputAtticChoice.equals("Y")) {
                    this.floor = 3;
                    this.house_x = 150;
                    this.house_y = 100;
                    System.out.println("You pulled the ceiling tab and climbed up to the attic.");
                }
                else {
                    System.out.println("You decided against going up to the attic.");
                }
            }
            else {
                System.out.println("You can't go up from here.");
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
            else if (this.Locate() == "Closet") {
                this.house_x = 205;
                this.house_y = 140;
                System.out.println("You are now in the kitchen.");
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
            else if (this.Locate() == "Kitchen") {
                this.house_x = 275;
                this.house_y = 160;
                System.out.println("You are now in a small room.");
            }
            else if (this.Locate() == "Living Room" && this.house_y <100) {
                this.house_x = 60;
                this.house_y = 110;
                System.out.println("You moved to the other side of the living room.");
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
        // if item is in user's possession
        System.out.println(item.name + ": " + item.description);
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
            else {
                return("Second floor.");
            }
        }
        else {
            return("Inside Haunted House.");
        }
    }

    // public void checkLocation() {
    //     if (this.house_x < 0 || this.house_y < 0) {
    //         System.out.println("You are outside the Haunted House. Enter the Haunted House to play.");
    //     }
    //     else if (this.house_x > 120 && this.house_x < 200 && this.house_y > 0 && this.house_y < 100 && this.floor == 1) {
    //         System.out.println("You are inside the Foyer."); 
    //     }
    //     else {
    //         System.out.println("You are somewhere inside the house.");
    //     }
    // }

    /**
     * decreases character's size
     * @return new size after shrinking
     */
    // public Number shrink(){
    //     double amountToShrink = 2;
    //     if (this.size - amountToShrink > 0) {
    //         this.size = this.size - amountToShrink;
    //         System.out.println(this.name + " is now this size: " + this.size);
    //         return this.size;
    //     }
    //     else {
    //         throw new RuntimeException(this.name + " cannot shrink by that amount.");
    //     }
        
    // }

    /**
     * increases character's size
     * @param atg integer amount for character's size to increase
     */
    public void grow(int amountToGrow){
        if (this.size + amountToGrow < this.maxSize) {
            this.size = this.size + amountToGrow;
            System.out.println(this.name + " is now this size: " + this.size);
        }
        else {
            throw new RuntimeException(this.name + " cannot grow by that amount.");
        }
    }

    /**
     * accessor for player's favorite food
     * @return favorite_thing
     */
    public static String getfavorite_thing() {
        return favorite_thing;
    }

    /**
     * character rests, affecting their energy level
     */
    // public void rest(int hours){
    //     System.out.println(this.name + " rested for " + hours + " hours.");
    // }

    /**
     * character rests, affecting their energy level
     */
    //public void drink(potion){
        //System.out.println(this.name + " drank " + potion + ".");
    //}

    /** for testing */
    public static void main(String[] args) {
        // Room Foyer = new Room("Foyer", 80, 100, 120, 200, 0, 100, 1);
        // Room LivingRoom = new Room("Living Room", 120, 150, 0, 120, 0, 150, 1);
        // Room DiningRoom = new Room("Dining Room", 100, 60, 200, 300, 0, 60, 1);
        // Room Kitchen = new Room ("Kitchen", 100, 90, 200, 300, 60, 150, 1);
        // Room SecretRoom = new Room("Secret Room", 50, 50, 250, 300, 150, 200, 1);
        // Room Bathroom = new Room("Bathroom", 70, 50, 120, 200, 150, 200, 1);
        // Room Closet = new Room("Closet", 10, 50, 190, 200, 100, 150, 1);
        // Room MasterBedroom = new Room("Master Bedroom", 120, 130, 0, 120, 0, 130, 2);
        // Room Office = new Room("Office", 80, 50, 120, 200, 100, 150, 2);
        // Room MasterBathroom = new Room("Master Bathroom", 70, 20, 0, 70, 130, 150, 2);
        // Room Closet2 = new Room("Master Closet", 50, 20, 70, 120, 130, 150, 2);
        // Room Bedroom = new Room("Bedroom", 100, 90, 200, 300, 0, 90, 2);
        // Room Hallway = new Room("Hallway", 180, 10, 120, 300, 90, 100, 2);
        // Room Bathroom2 = new Room("Bathroom", 180, 10, 120, 300, 90, 100, 2);
        // Room Attic = new Room("Attic", 300, 150, 0, 300, 0, 150, 3);
        // User.checkCoordinates();
        // User.go("a");
        // User.go("w");
        // User.go("d");
        // User.go("a");
        // User.go("s");  
        // User.go("d");
        // User.go("d");
        // User.go("w");
        // User.go("a");
        // User.go("d");
        // User.go("s");
        // User.go("a");
        // User.checkTracker();
        // Item donut = new Item("Donut", "Food", "A freshly baked donut.");
        // Item potion = new Item("Golden Potion", "Potion", "");
        // Item potion2 = new Item("Potion", "Potion", "");
        // Player.examine(donut);
        // Player.examine(potion);
        // Player.examine(potion2);
        // Player.write();
        // Player.read(1);
        //Player.playGame();
     }

    }


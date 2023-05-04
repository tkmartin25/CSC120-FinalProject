import java.util.ArrayList;
import java.util.Scanner;

public class User {

    /** character name */
    String name;

    /** alive or dead */
    boolean living;

    /** current energy level  */
    int current_energy;

    /** maximum energy level */
    int max_energy;

    /** size of character */
    // am planning to have places you can only access if you are a certain size
    double size;

    /** max size character can reach */
    double maxSize;

    /** x coordinate of house where character is located */
    int house_x;

    /** y coordinate of house where character is located */
    int house_y;

    /** which floor the user is on */
    int floor;

    /** stores which items user possesses */
    ArrayList<Item> items;

    ArrayList<String> notebook;

    String note;

    /** x coordinate of character in terms of the room's coordinates */
    // should be automatically calculated based on house coordinates
    int room_x;
    /** y coordinate of character in terms of the room's coordinates */
    int room_y;



    

    /* Default constructor
     * @param name
     */
    public User(String name) {
        this.name = name;
        this.living = true;
        this.current_energy = this.max_energy;
        this.house_x = -1;
        this.house_y = -1;
        this.floor = -1;
        this.notebook = new ArrayList<String>();
    }

    /** function for entering Haunted House */
    public void enter(){
        if (this.house_x < 0 || this.house_y < 0) {
            this.house_x = 160;
            this.house_y = 1;
            this.floor = 1;
            System.out.println("You have entered the Haunted House.");
        }
        else {
            throw new RuntimeException("You are already in the Haunted House.");
        }
    }

    /**
    * based on the direction north, south, east, or west, the bat moves coordinates by a unit of 1
    * @param direction for bat to walk in
    */
    public void go(String direction){
        direction = direction.toLowerCase();
        if (direction == "up") {
            if (this.Locate() == "Foyer") {
                this.floor = 2;
                this.house_x = 195;
                this.house_y = 90;
                System.out.println("You walked up the stairs to the second floor.");
            }
            else {
                System.out.println("You can't go up from here.");
            }
        }
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
            else {
                System.out.println("You can't go to the left from here.");
            }
        }
        else if (direction == "d") {
            if (this.Locate() == "Living Room") {
                this.house_x = 125;
                this.house_y = 10;
                System.out.println("You are now in the foyer.");
            }
            else if (this.Locate() == "Foyer") {
                this.house_x = 205;
                this.house_y = 10;
                System.out.println("You are now in the dining room.");
            }
            else {
                System.out.println("You can't go to the right from here.");
            }
        }
    //     if (direction == "west") {
    //         System.out.println("You walked west.");
    //         this.x = x - 1;
    //         return true;
    //     }
    //     if (direction == "east") {
    //         System.out.println("You walked east.");
    //         this.x = x + 1;
    //         return true;
    //     }
        else {
            throw new RuntimeException("Error: You must input one of the following four directions: 'up', 'down', 'left', or 'right'.");
        }
    }

    /**
     * allows user to write in their notebook
     */
    public void write(){
        Scanner userInput = new Scanner(System.in); 
        System.out.println("Would you like to write in the notebook? You have " + (5 - notebook.size()) + " page(s) remaining. (Y/N)");
        String userChoice = userInput.nextLine();
        if (userChoice.equals("Y")) {
            Scanner userNote = new Scanner(System.in); 
            System.out.println("Write your note for page " + (notebook.size() + 1) + ".");
            String note = userNote.nextLine();
            notebook.add(note);
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


    //public void use(String item){}

    /**
     * allows user to check what coordinates they are at
     */
    public void checkCoordinates() {
        System.out.println(this.name + " is at (" + this.house_x + ", " + this.house_y + ").");
    }

    /**
     * locates user in terms of which room they are in in the house
     * @return name of room that the user is currently in
     */
    public String Locate() {
        if (this.house_x < 0 || this.house_y < 0) {
            return("Haunted House");
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
            else {
                return("First floor--somewhere.");
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
    public Number shrink(){
        double amountToShrink = 2;
        if (this.size - amountToShrink > 0) {
            this.size = this.size - amountToShrink;
            System.out.println(this.name + " is now this size: " + this.size);
            return this.size;
        }
        else {
            throw new RuntimeException(this.name + " cannot shrink by that amount.");
        }
        
    }

    /**
     * increases character's size
     * @return new size after growing
     */
    public Number grow(){
        double amountToGrow = 2;
        if (this.size + amountToGrow < this.maxSize) {
            this.size = this.size + amountToGrow;
            System.out.println(this.name + " is now this size: " + this.size);
            return this.size;
        }
        else {
            throw new RuntimeException(this.name + " cannot grow by that amount.");
        }
    }

    /**
     * character rests, affecting their energy level
     */
    public void rest(int hours){
        System.out.println(this.name + " rested for " + hours + " hours.");
    }

    /**
     * character rests, affecting their energy level
     */
    //public void drink(potion){
        //System.out.println(this.name + " drank " + potion + ".");
    //}

    /** for testing */
    public static void main(String[] args) {
        Room Foyer = new Room("Foyer", 80, 100, 120, 200, 0, 100, 1);
        Room LivingRoom = new Room("Living Room", 120, 150, 0, 120, 0, 150, 1);
        Room DiningRoom = new Room("Dining Room", 100, 60, 200, 300, 0, 60, 1);
        User User = new User("Babby");
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
        User.write();
        User.read(2);
        User.read(1);
     }

    }


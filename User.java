
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
    }

    /** function for entering Haunted House */
    public void enter(){
        if (this.house_x < 0 || this.house_y < 0) {
            this.house_x = 160;
            this.house_y = 1;
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
            if (this.checkLocation() == "Foyer") {
                this.house_x = 195;
                this.house_y = 90;
                System.out.println("You walked up the stairs to the second floor.");
            }
            else {
                System.out.println("You can't go upstairs from this room.");
            }
        }
       // if (direction == "") {
    //         System.out.println("You walked south.");
    //         this.y = y - 1;
    //         return true;
    //     }
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
    //     else {
    //         throw new RuntimeException("Error: You must input one of the following four directions: 'north', 'south', 'west', or 'east'.");
    //     }
    }



    public void use(String item){

    }

    public void checkCoordinates() {
        System.out.println(this.name + " is at (" + this.house_x + ", " + this.house_y + ").");
    }

    public String checkLocation() {
        if (this.house_x < 0 || this.house_y < 0) {
            System.out.println("You are outside the Haunted House. Enter the Haunted House to play.");
            return("Haunted House");
        }
        elseif (this.house_x > 120 && this.house_x < 200 && this.house_y <)
        else {
            System.out.println("You are somewhere inside the house.");
            return("Inside Haunted House.");
        }
    }

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
        User User = new User("Babby");
        User.checkCoordinates();
        User.enter();
        User.checkCoordinates();
        User.checkLocation();
        User.go("up");
     }

    }


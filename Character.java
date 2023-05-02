public class Character {

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
    public Character(String name) {
        this.name = name;
        this.living = true;
        this.current_energy = this.max_energy;
        this.house_x = -1;
        this.house_y = -1;
    }

    public void use(String item){

    }

    public void checkCoordinates() {
        //System.out.println(this.name + " is at (" + this.x + ", " + this.y + ").");
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


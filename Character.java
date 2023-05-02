public class Character {

    // character name
    String name;
    // alive or dead
    boolean living;
    // x coordinate of house
    int house_x;
    // y coordinate of house
    int house_y;
    // x coordinate of room -- should be automatically calculated based on house coordinates
    int room_x;
    // y coordiinate of room
    int room_y;

    

    /* Default constructor */
    public Character(String name) {
        this.name = name;
        this.living = true;
        this.house_x = -1;
        this.house_y = -1;
    }

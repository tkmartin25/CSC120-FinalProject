public class Room {

    /** name of room */
    String name;
    /** total x 'width' of room */
    int width;
    /** total y 'length' of room */
    int length;
    /** relative to the house, the x coordinate the room starts at */
    int min_x;
    /** relative to the house, the x coordinate the room ends at */
    int max_x;
    /** relative to the house, the y coordinate the room starts at */
    int min_y;
    /** relative to the house, the y coordinate the room ends at */
    int max_y;
    /** which floor the room is on */
    int floor;
    /** text describing the room */
    String description;

    /** Room constructor
     * @param name
     * @param width
     * @param length
     * @param mix_x
     * @param max_x
     * @param min_y
     * @param max_y
     * @param floor
     * @param description
     */
    public Room(String name, int width, int length, int min_x, int max_x, int min_y, int max_y, int floor, String description) {
        this.name = name;
        this.width = width;
        this.length = length;
        this.min_x = min_x;
        this.max_x = max_x;
        this.min_y = min_y;
        this.max_y = max_y;
        this.floor = floor;
        this.description = description;
    }
}

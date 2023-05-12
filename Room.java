public class Room {

    String name;
    int width;
    int length;
    int min_x;
    int max_x;
    int min_y;
    int max_y;
    int floor;

    /** Default constructor
     * @param name
     * @param width
     * @param length
     * @param mix_x
     * @param max_x
     * @param min_y
     * @param max_y
     * @param floor
     */
    public Room(String name, int width, int length, int min_x, int max_x, int min_y, int max_y, int floor) {
        this.name = name;
        this.width = width;
        this.length = length;
        this.min_x = min_x;
        this.max_x = max_x;
        this.min_y = min_y;
        this.max_y = max_y;
        this.floor = floor;
    }

}

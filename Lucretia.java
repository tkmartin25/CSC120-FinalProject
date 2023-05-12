public class Lucretia {

    /** character name */
    String name;
    
    /** alive or dead */
    boolean living;

    /** current energy level  */
    int current_energy;

    /** maximum energy level */
    int max_energy;

   /** location of character */
    Room location;
    
    /** Default constructor
     * @param name
     * @param living
     * @param max_energy
     * @param location
     */
    public Lucretia(String name, boolean living, int max_energy, Room location) {
        this.name = name;
        this.living = living;
        this.max_energy = max_energy;
        this.location = location;
    }

}

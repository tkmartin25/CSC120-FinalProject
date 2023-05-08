public class Item {
    String name;
    String description;
    String type;

    /** 
     * Default constructor
     * @param name
     * @param description
     * @param type
     */
    public Item(String name, String type, String description) {
        this.name = name;
        this.type = type;
        if (type == "Potion") {
            if (name == "Healing Potion") {
                this.description = "A potion that appears pastel pink and blue. It smells sweet and tart.";
            }
            else {
                this.description = "An unknown potion.";
            }
        }
        else {
            this.description = description;
        }
    }
    
}

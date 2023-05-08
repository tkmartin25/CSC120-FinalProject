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
            else if (name == "Shrinking Potion") {
                this.description = "A caramel-colored potion that is contained in a mini jar. It smells of chopped wood and blackberries. When you hold it to your ear, you think you hear mice chittering.";
            }
            else if (name == "Growing Potion") {
                this.description = "A bright pink potion that is contained in a large jar. It smells of forest and roots. When you hold it to your ear, you think you can hear an elephant's trumpet.";
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

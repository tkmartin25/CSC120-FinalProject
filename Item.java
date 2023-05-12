public class Item {
    String name;
    String description;
    String type;
    int effect;
    int effectsize;
    String initial_location;

    /** 
     * constructor for item
     * @param name
     * @param description
     * @param type i.e. potion, food
     * @param effect int change on energy level of user
     * @param effectsize int change on size of user
     */
    public Item(String name, String type, String description, int effect, int effectsize) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.effect = effect;
        this.effectsize = effectsize;
        this.initial_location = "Kitchen";
        if (type == "Potion") {
            if (name == "Healing Potion") {
                this.description = "A potion that appears pastel pink and blue. It smells sweet and tart.";
                this.effect = 30;
            }
            else if (name == "Shrinking Potion") {
                this.description = "A caramel-colored potion that is contained in a mini jar. It smells of chopped wood and blackberries. When you hold it to your ear, you think you hear mice chittering.";
                this.effectsize = -20;
            }
            else if (name == "Growing Potion") {
                this.description = "A bright pink potion that is contained in a large jar. It smells of forest and roots. When you hold it to your ear, you think you can hear an elephant's trumpet.";
                this.effectsize = 20;
            }
            else if (name == "Beauty Potion") {
                this.description = "A periwinkle potion that is contained in a cloud-shaped jar. It smells of lavender and fresh laundry. When you hold it to your ear, you think you hear relaxed breathing.";
            }
            else if (name == "Golden Potion") {
                this.description = "A golden potion that is contained in a star-shaped jar. It smells of " + User.getfavorite_thing() + ".";
                this.effect = 75;
            }
            else if (name == "Maroon Potion") {
                this.description = "A deep red potion that is contained in a thin jar. It smells metallic-like.";
                this.effect = -75;
            }
            else {
                this.description = "An unknown potion.";
            }
        }
    }
}

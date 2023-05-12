public class Egg extends Character {

    public Egg(String name, boolean living, int max_energy, Room location) {
        super(name, living, max_energy, location);
    }

    public void roll() {
        if (Player.Locate() == this.location.name) {
            System.out.println("You see Egg rolling.");
        }
        else if (User.Locate() != this.location.name) {
            System.out.println("Somewhere in the distance, you hear floors creaking.");
        }
    }
    
}

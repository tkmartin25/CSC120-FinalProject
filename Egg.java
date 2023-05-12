public class Egg extends Character {

    public Egg(String name, boolean living, int max_energy, Room location) {
        super(name, living, max_energy, location);
    }

    public void roll() {
        if (Player.Locate() == this.location.name) {

        }
        else if (User.Locate() != this.location.name) {

        }
    }
    
}

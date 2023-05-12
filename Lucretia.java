import java.util.Scanner;

/** Lucretia class */
public class Lucretia {

    /** Lucretia name */
    String name;
    
    /** alive or dead */
    boolean living;

    /** current energy level  */
    int current_energy;

    /** maximum energy level */
    int max_energy;

   /** location of Lucretia */
    Room location;

    /** measure of how angry Lucretia is */
    int anger_meter;
    
    /** Lucretia constructor
     * @param location
     */
    public Lucretia(Room location) {
        this.name = "Lucretia";
        this.living = false;
        this.max_energy = 1000;
        this.location = location;
        this.anger_meter = 20;
    }

    /**
     * prints out message of Lucretia's deadly attack
     */
    public void killMessage() {
        System.out.println("You have made Lucretia unbearably angry. She charges forward and puts a curse on you.");
    }

    /**
     * Lucretia's anger level rises
     */
    public void getAngry() {
        this.anger_meter = this.anger_meter + 20;
    }

    /**
     * Lucretia asks first question
     */
    public void firstTest() {
        System.out.println("Lucretia: So, you've finally made it to the attic. Let's test you on one of the first things you saw.");
        Scanner UserInputTest1 = new Scanner(System.in);
        System.out.println("Lucretia: Name the one of the statues you saw in the foyer.");
        String userAnswer1 = UserInputTest1.nextLine();
        userAnswer1 = userAnswer1.toLowerCase();
        // user correct answer, 2 possible correct answers
        if (userAnswer1.contains("elephant")) {
            System.out.println("Lucretia: Good. The other two were ghost and ghoul.");
        }
        else if (userAnswer1.contains("ghost")) {
            System.out.println("Lucretia: Good. The other two were elephant and ghoul.");
        }
        else if (userAnswer1.contains("ghoul")) {
            System.out.println("Lucretia: Good. The other two were ghost and elephant.");
        }
        // user incorrect answer
        else {
            System.out.println("Lucretia: That's incorrect. I'm not surprised but I am disappointed.");
            this.getAngry();
        }
    }

    /**
     * Lucretia asks second question
     */
    public void secondTest() {
        System.out.println("Lucretia: Let's move on to the second test.");
        Scanner UserInputTest2 = new Scanner(System.in);
        System.out.println("Lucretia: What kind of orchard did you see in the first floor closet painting? Just type the name of the fruit.");
        String userAnswer2 = UserInputTest2.nextLine();
        userAnswer2 = userAnswer2.toLowerCase();
        // user correct answer
        if (userAnswer2.contains("lemon")) {
            System.out.println("Lucretia: Good. That's right. That was her favorite.");
        }
        // user incorrect answer
        else {
            System.out.println("Lucretia: That's incorrect. You should've thought twice before coming in here.");
            this.getAngry();
            if (this.anger_meter > 50) {
                this.killMessage();
                throw new RuntimeException("Sorry, you died from Lucretia's attack. Game over.");
            }
        }
    }

    /**
     * Lucretia asks third question
     */
    public void thirdTest() {
        System.out.println("Lucretia: Let's move on to the final test.");
        Scanner UserInputTest3 = new Scanner(System.in);
        System.out.println("Lucretia: Give me the initial of the doll you spotted in the bedroom.");
        String userAnswer3 = UserInputTest3.nextLine();
        userAnswer3 = userAnswer3.toLowerCase();
        // user correct answer
        if (userAnswer3.equals("e")) {
            System.out.println("Lucretia: Most impressive. You've succeeded in appeasing my concerns about your worth.");
            User.win();
        }
        //third question is wrong, game ends
        else {
            System.out.println("Lucretia: That's incorrect. You don't deserve to be here.");
            this.getAngry();
            this.killMessage();
            throw new RuntimeException("Sorry, you died from Lucretia's attack. Game over.");
        }
    }
}

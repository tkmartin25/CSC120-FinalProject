import java.util.Scanner;

public class Game {

    /** game constructor */
    public Game() {}

    /** 
     * run this method to play game
     */
    public void playGame() {
        House Haunted_house = new House();
        Haunted_house.buildHouse();

        Scanner UserInputName = new Scanner(System.in);
        System.out.println("What is your name?");
        String userName = UserInputName.nextLine();
        
        Scanner UserInputFavoriteThing = new Scanner(System.in);
        System.out.println("What is your favorite food?");
        String userFavoriteThing = UserInputFavoriteThing.nextLine();
        
        User Player = new User(userName, userFavoriteThing);
        Item Potion = new Item("Healing Potion", "Potion", "", 0);
        Player.take(Potion);
        while (Player.living == true) {
            Scanner userInput1 = new Scanner(System.in); 
            System.out.println("What would you like to do?");
            String userCommand = userInput1.nextLine();
            if (userCommand.equals("enter")) {
                Player.enter();
            }
            else if (userCommand.equals("w")) {
                Player.go("w");
                Player.changeEnergy(-5);
            }
            else if (userCommand.equals("s")) {
                Player.go("s");
                Player.changeEnergy(-5);
            }
            else if (userCommand.equals("a")) {
                Player.go("a");
                Player.changeEnergy(-5);
            }
            else if (userCommand.equals("d")) {
                Player.go("d");
                Player.changeEnergy(-5);
            }
            else if (userCommand.equals("up")) {
                Player.go("up");
                Player.changeEnergy(-5);
            }
            else if (userCommand.equals("down")) {
                Player.go("down");
                Player.changeEnergy(-5);
            }
            else if (userCommand.equals("write")) {
                Player.write();
            }
            else if (userCommand.equals("read")) {
                Scanner UserInputpagenum = new Scanner(System.in);
                System.out.println("What page would you like to read? (ex. 1, 2 etc.)");
                int userpagenum = UserInputpagenum.nextInt();
                Player.read(userpagenum);
            }
            else if (userCommand.equals("check coordinates")) {
                Player.checkCoordinates();
            }
            else if (userCommand.equals("check tracker")) {
                Player.checkTracker();
            }
            else if (userCommand.equals("check energy")) {
                Player.checkEnergy();
            }
            else if (userCommand.equals("drink")) {
                Scanner UserInputPotion = new Scanner(System.in);
                Player.checkItems();
                System.out.println("What potion do you want to drink? (Enter the number next to the potion you want to drink.)");
                int userPotionChoice = UserInputPotion.nextInt();
                Player.drink(Player.items.get(userPotionChoice));
            }
            else {
                System.out.println("Please enter a valid command.");
            }
        }
        if (Player.living == false) {
            System.out.println("You lost! Better luck next time.");
        }
    }
    
    /** 
     * run main() to play game
     */
    public static void main(String[] args) {
        Game Game = new Game();
        Game.playGame();
    }
}

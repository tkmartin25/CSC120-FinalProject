import java.util.Scanner;

public class Game {

    /** game constructor */
    public Game() {}

    /** 
     * run this method to play game
     */
    public void playGame() {
        // creates haunted house
        House Haunted_house = new House();
        Haunted_house.buildHouse();
        // asks user's name
        Scanner UserInputName = new Scanner(System.in);
        System.out.println("What is your name?");
        String userName = UserInputName.nextLine();
        // asks user's favorite food
        Scanner UserInputFavoriteThing = new Scanner(System.in);
        System.out.println("What is your favorite food?");
        String userFavoriteThing = UserInputFavoriteThing.nextLine();
        // creates player with User class
        User Player = new User(userName, userFavoriteThing);
    
        Item Potion = new Item("Maroon Potion", "Potion", "", 0);
        Player.take(Potion);
        // while player is alive
        while (Player.living == true) {
            // user inputs command
            Scanner userInput1 = new Scanner(System.in); 
            System.out.println("What would you like to do?");
            String userCommand = userInput1.nextLine();
            // if else ladder for all commands
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
                if (Player.items.size() > 0) {
                    Scanner UserInputPotion = new Scanner(System.in);
                    Player.checkItems();
                    System.out.println("What potion do you want to drink? (Enter the number next to the potion you want to drink.)");
                    int userPotionChoice = UserInputPotion.nextInt();
                    Player.drink(Player.items.get(userPotionChoice));
                    Player.items.remove(userPotionChoice);
                }
                else {
                    System.out.println("Sorry, but you don't have any items to drink at the moment.");
                }
            }
            else if (userCommand.equals("examine")) {
                Scanner UserInputExamine = new Scanner(System.in);
                Player.checkItems();
                System.out.println("What item do you want to examine? (Enter the number next to the item you want to examine.)");
                int userExamineChoice = UserInputExamine.nextInt();
                Player.examine(Player.items.get(userExamineChoice));
            }
            else {
                System.out.println("Please enter a valid command.");
            }
        }
        // player died, game over
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

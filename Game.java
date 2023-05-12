import java.util.Scanner;

public class Game {

    public Game() {}

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

        while (Player.living == true) {
            Scanner userInput1 = new Scanner(System.in); 
            System.out.println("What would you like to do?");
            String userCommand = userInput1.nextLine();
            if (userCommand.equals("enter")) {
                Player.enter();
            }
            else if (userCommand.equals("w")) {
                Player.go("w");
            }
            else if (userCommand.equals("s")) {
                Player.go("s");
            }
            else if (userCommand.equals("a")) {
                Player.go("a");
            }
            else if (userCommand.equals("d")) {
                Player.go("d");
            }
            else if (userCommand.equals("up")) {
                Player.go("up");
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
            else {
                System.out.println("Please enter a valid command.");
            }
        }
    }
    
public static void main(String[] args) {
        Game Game = new Game();
        Game.playGame();
     }

}

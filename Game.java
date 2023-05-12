import java.util.Scanner;

public class Game {

    public Game() {}

    public void playGame() {
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
            else {
                System.out.println("Please enter a valid command.");
            }
        }
    }
    
    public static void main(String[] args) {
        //User Player = new User("Babby", WPG ;) coconut ice cream");
        Room Foyer = new Room("Foyer", 80, 100, 120, 200, 0, 100, 1);
        Room LivingRoom = new Room("Living Room", 120, 150, 0, 120, 0, 150, 1);
        Room DiningRoom = new Room("Dining Room", 100, 60, 200, 300, 0, 60, 1);
        Room Kitchen = new Room ("Kitchen", 100, 90, 200, 300, 60, 150, 1);
        Room SecretRoom = new Room("Secret Room", 50, 50, 250, 300, 150, 200, 1);
        Room Bathroom = new Room("Bathroom", 70, 50, 120, 200, 150, 200, 1);
        Room Closet = new Room("Closet", 10, 50, 190, 200, 100, 150, 1);
        Room MasterBedroom = new Room("Master Bedroom", 120, 130, 0, 120, 0, 130, 2);
        Room Office = new Room("Office", 80, 50, 120, 200, 100, 150, 2);
        Room MasterBathroom = new Room("Master Bathroom", 70, 20, 0, 70, 130, 150, 2);
        Room Closet2 = new Room("Master Closet", 50, 20, 70, 120, 130, 150, 2);
        Room Bedroom = new Room("Bedroom", 100, 90, 200, 300, 0, 90, 2);
        Room Hallway = new Room("Hallway", 180, 10, 120, 300, 90, 100, 2);
        Room Bathroom2 = new Room("Bathroom", 180, 10, 120, 300, 90, 100, 2);
        // User.checkCoordinates();
        // User.go("a");
        // User.go("w");
        // User.go("d");
        // User.go("a");
        // User.go("s");  
        // User.go("d");
        // User.go("d");
        // User.go("w");
        // User.go("a");
        // User.go("d");
        // User.go("s");
        // User.go("a");
        // User.checkTracker();
        // Item donut = new Item("Donut", "Food", "A freshly baked donut.");
        // Item potion = new Item("Golden Potion", "Potion", "");
        // Item potion2 = new Item("Potion", "Potion", "");
        // Player.examine(donut);
        // Player.examine(potion);
        // Player.examine(potion2);
        // Player.write();
        // Player.read(1);
        Game Game = new Game();
        Game.playGame();
     }

}

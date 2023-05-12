import java.util.Scanner;

/** Game class */
public class Game {

    /** game constructor */
    public Game() {}

    /** 
     * run this method to play game
     */
    public void playGame() {
        // creates haunted house
        House Haunted_house = new House();
        Room Foyer = new Room("Foyer", 80, 100, 120, 200, 0, 100, 1, "A quaint room with a grand staircase leading upstairs. Towards the left of the room, you see status of an elephant, a ghost, and a ghoul.");
        Room LivingRoom = new Room("Living Room", 120, 150, 0, 120, 0, 150, 1, "A very large room with red couches. On the ceiling, you see a painting of bubble tea.");
        Room DiningRoom = new Room("Dining Room", 100, 60, 200, 300, 0, 60, 1, "A room with a long dining table with eight chairs. There is a chandelier from the ceiling.");
        Room Kitchen = new Room ("Kitchen", 100, 90, 200, 300, 60, 150, 1, "A pristinely clean kitchen with many cabinets for storage. At the center of the room, you see potions.");
        Room SecretRoom = new Room("Secret Room", 50, 50, 250, 300, 150, 200, 1, "An empty room. You see a scroll on the floor that reads: Do not drink the red potion.");
        Room Bathroom = new Room("Bathroom", 70, 50, 120, 200, 150, 200, 1, "A regular bathroom. There is a painting of an old sailor on the wall.");
        Room Closet = new Room("Closet", 10, 50, 190, 200, 100, 150, 1, "A closet that seems to have a locked latch on the ground. You wonder where it leads to. On the wall, you see a painting of a young girl holding a yellow dog in a lemon orchard.");
        Room MasterBedroom = new Room("Master Bedroom", 120, 130, 0, 120, 0, 130, 2, "A room with a grand bed that looks perfect for jumping on.");
        Room Office = new Room("Office", 80, 50, 120, 200, 100, 150, 2, "An office room with two windows. There are five bookshelves.");
        Room MasterBathroom = new Room("Master Bathroom", 70, 20, 0, 70, 130, 150, 2, "A small but beautiful bathroom. The tiles on the floor are royal blue. You notice a name carved into one of the walls near the floor: Juliet.");
        Room Closet2 = new Room("Master Closet", 50, 20, 70, 120, 130, 150, 2, "A closet full of clothes.");
        Room Bedroom = new Room("Bedroom", 100, 90, 200, 300, 0, 90, 2, "A children's bedrom. There are many dolls in the room but one of them perched on top of the shelf catches your eye. On her necklace, you see the initial E.");
        Room Hallway = new Room("Hallway", 180, 10, 120, 300, 90, 100, 2, "A hallway with 7 different portraits against the wall.");
        Room Bathroom2 = new Room("Bathroom", 180, 10, 120, 300, 90, 100, 2, "A bathroom full of cobwebs. There is a black and white painting on the wall of 6 women. The one in the middle seems to be staring at you directly.");
        Room Attic = new Room("Attic", 300, 150, 0, 300, 0, 150, 3, "It's dark.");
        Haunted_house.buildHouse();
        
        // potions
        Item Potion1 = new Item("Healing Potion", "Potion", "", 0, 0);
        Item Potion2 = new Item("Shrinking Potion", "Potion", "", 0, 0);
        Item Potion3 = new Item("Growing Potion", "Potion", "", 0, 0);
        Item Potion4 = new Item("Beauty Potion", "Potion", "", 0, 0);
        Item Potion5 = new Item("Golden Potion", "Potion", "", 0, 0);
        Item Potion6 = new Item("Maroon Potion", "Potion", "", 0, 0);
        // adding all potions to kitchen
        Kitchen.addPotion(Potion1);
        Kitchen.addPotion(Potion2);
        Kitchen.addPotion(Potion3);
        Kitchen.addPotion(Potion4);
        Kitchen.addPotion(Potion5);
        Kitchen.addPotion(Potion6);
        // counter for how many potions the user has taken
        int counter = 0;
        
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
        
        // while player is alive
        while (Player.living == true && Player.win == false) {
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
            else if (userCommand.equals("check size")) {
                Player.checkSize();
            }
            else if (userCommand.equals("take")) {
                if (Player.Locate() == "Kitchen") {
                    if (counter < 4) {
                        Scanner UserInputTake = new Scanner(System.in);
                        Kitchen.getItems();
                        System.out.println("What item do you want to take? (Enter the number next to the item you want to take.)");
                        int userTakeChoice = UserInputTake.nextInt();
                        Player.take(Kitchen.Roomitems.get(userTakeChoice));
                        counter ++;
                    }
                    else {
                        System.out.println("Sorry, but you've already taken enough from a house that isn't yours.");
                    }
                }
                else {
                    System.out.println("Sorry, but there's nothing to take in this room.");
                }
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
            else if (userCommand.equals("examine Room")) {
                if (Player.Locate() == "Foyer") {
                    Foyer.getDescription();
                }
                else if (Player.Locate() == "Living Room") {
                    LivingRoom.getDescription();
                }
                else if (Player.Locate() == "Dining Room") {
                    DiningRoom.getDescription();
                }
                else if (Player.Locate() == "Bathroom" && Player.floor == 1) {
                    Bathroom.getDescription();
                }
                else if (Player.Locate() == "Bathroom" && Player.floor == 2) {
                    Bathroom2.getDescription();
                }
                else if (Player.Locate() == "Master Bathroom") {
                    MasterBathroom.getDescription();
                }
                else if (Player.Locate() == "Closet" && Player.floor == 1) {
                    Closet.getDescription();
                }
                else if (Player.Locate() == "Closet" && Player.floor == 2) {
                    Closet2.getDescription();
                }
                else if (Player.Locate() == "Kitchen") {
                    Kitchen.getDescription();
                }
                else if (Player.Locate() == "Hallway") {
                    Hallway.getDescription();
                }
                else if (Player.Locate() == "Master Bedroom") {
                    MasterBedroom.getDescription();
                }
                else if (Player.Locate() == "Bedroom") {
                    Bedroom.getDescription();
                }
                else if (Player.Locate() == "Office") {
                    Office.getDescription();
                }
                else if (Player.Locate() == "Secret Room") {
                    SecretRoom.getDescription();
                }
                else if (Player.Locate() == "Attic") {
                    Attic.getDescription();
                }
            }
            else {
                System.out.println("Please enter a valid command.");
            }
        }
        // player died, game over
        if (Player.living == false) {
            System.out.println("You lost! Better luck next time.");
        }
        // player won, congratulations message
        else if (Player.win == true) {
            System.out.println("Congratulations! You won the game.");
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
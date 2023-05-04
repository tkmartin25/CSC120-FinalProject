import java.util.ArrayList;
import java.util.Scanner;

public class Notebook {
    
    String name;
    /** notebook in which user can write notes in to help them */
    ArrayList<String> notebook;

    public Notebook() {
        this.name = "Notebook";
        this.notebook = new ArrayList<String>();
    }

    if (this.notebook.size() < 5) {
        Scanner userInput = new Scanner(System.in); 
        System.out.println("Would you like to write in the notebook? You have " + (5 - this.notebook.size()) + " page(s) remaining. (Y/N)");
        String note = userInput.nextLine();
        this.notebook.add(note);
    }
    else {
        System.out.println("You already used up all your pages.");
    }

    
}

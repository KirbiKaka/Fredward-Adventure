import java.util.ArrayList;

/** A class consisting of static fields and methods for holding the inventory and keeping track of puzzles solved. */
public class Inventory {

    public static final String vowels = "AEIOU";

    public static ArrayList<String> items = new ArrayList<String>();
    public static ArrayList<String> puzzles = new ArrayList<String>();

    public static void printItems() {
        String s = "Let's see, I have...\n";
        boolean first = true;
        if (items.isEmpty()) {
            s += "...nothing! wow!";
        }
        for(String item : items) {
            if(item != null) {
                if (first) {
                    first = false;
                } else {
                    s += ", ";
                }
                if (vowels.indexOf(item.charAt(0)) == -1) {
                    s += "a " + item;
                } else {
                    s += "an " + item;
                }
            }
        }
        TextBox.writeText(s);
    }

}

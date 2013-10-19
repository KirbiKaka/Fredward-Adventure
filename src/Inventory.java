import java.util.ArrayList;


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

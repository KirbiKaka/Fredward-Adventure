/** The first puzzle of the game. In Level_2. Involves 4 Levers. */
public class Puzzle_1 {

    private final Lever a, b, c, d;
    private boolean solved;

    public Puzzle_1(Lever a, Lever b, Lever c, Lever d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public boolean solved() {
        if (!solved && a.isLeft() && !b.isLeft() && !c.isLeft() && d.isLeft()) {
            Inventory.puzzles.add("Fence-Hopping License");
            solved = true;
            TextBox.writeText("And just like that, you hear a voice boom from overhead.\n" +
            		"\"You are now worthy of crossing low fences, use this power wisely.\"\n" +
            		"And here you thought you could already hop fences,\nconsidering you've been doing it for years.");
            return true;
        }
        if (solved) {
            return true;
        }
        return false;
    }

}

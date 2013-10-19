import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/** An entity that is solid, can be interacted with exactly once (pressing the button), and is attached to a puzzle */
public class Button extends InteractableEntity{

    /** The String added to Inventory.puzzles when this button is pressed. */
    private final String puzzle;

    /** Holds the image information for the image of the button pressed down. */
    private Image image2;
    private final String imageDir2;

    private boolean isPressed;

    /** Size is set to default values. */
    public Button(int coordX, int coordY, String imageDir, String imageDir2, String puzzle) {
        super(42, 30, coordX, coordY, imageDir);
        this.puzzle = puzzle;
        this.imageDir2 = imageDir2;
        isPressed = false;
    }

    public Button(int sizeX, int sizeY, int coordX, int coordY, String imageDir, String imageDir2, String puzzle) {
        super(sizeX, sizeY, coordX, coordY, imageDir);
        this.puzzle = puzzle;
        this.imageDir2 = imageDir2;
        isPressed = false;
    }

    @Override
    void interact() {
        if (isPressed) {
            TextBox.writeText("Wow, I'm sure you're accomplishing a lot right now.");
        } else {
            isPressed = true;
            TextBox.writeText("Don't you have anything better to do than go around pushing peoples' buttons?");
            Inventory.puzzles.add(puzzle);
        }
    }

    @Override
    boolean isSolid() {
        return true;
    }

    boolean isPressed() {
        return isPressed;
    }

    @Override
    void draw(Graphics g, int offset) {
        if (!imageCreated) {
            try {
                image = new Image(imageDir);
                image2 = new Image(imageDir2);
            } catch (SlickException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            imageCreated = true;
        }
        if (isVisible) {
            if (!isPressed) {
                g.drawImage(image, coordX - offset, coordY);
            } else {
                g.drawImage(image2, coordX - offset, coordY);
            }
        }
    }

    @Override
    void init() {

    }

    @Override
    void update(int delta) {

    }

}

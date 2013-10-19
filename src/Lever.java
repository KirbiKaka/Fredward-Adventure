import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/** A solid, interactable entity that has 2 states and is linked to a puzzle. */
public class Lever extends InteractableEntity{

    private boolean isLeft;
    private final String imageDir2;
    private Image image2;
    private final String puzzle;
    private final String left, right;

    /** Sets size and messages to default. */
    public Lever(int coordX, int coordY, String imageDir, String imageDir2, String puzzle) {
        super(50, 67, coordX, coordY, imageDir);
        this.imageDir2 = imageDir2;
        this.puzzle = puzzle;
        left = "To the left, to the left.";
        right = "Right, right?";
    }

    /** Sets messages to default. */
    public Lever(int sizeX, int sizeY, int coordX, int coordY, String imageDir, String imageDir2, String puzzle) {
        super(sizeX, sizeY, coordX, coordY, imageDir);
        this.imageDir2 = imageDir2;
        this.puzzle = puzzle;
        left = "To the left, to the left.";
        right = "Right, right?";
    }

    public Lever(int sizeX, int sizeY, int coordX, int coordY, String imageDir, String imageDir2, String puzzle, String left, String right) {
        super(sizeX, sizeY, coordX, coordY, imageDir);
        this.imageDir2 = imageDir2;
        this.puzzle = puzzle;
        this.left = left;
        this.right = right;
    }

    @Override
    void interact() {
        isLeft = !isLeft;
        if (isLeft) {
            TextBox.writeText(left);
        } else {
            TextBox.writeText(right);
        }
    }

    @Override
    boolean isInteractable() {
        return true;
    }

    public boolean isLeft() {
        return isLeft;
    }

    @Override
    boolean isSolid() {
        return true;
    }

    @Override
    void init() {

    }

    @Override
    void update(int delta) {

    }

    @Override
    void draw(Graphics g, int offset) {
        if (!imageCreated) {
            try {
                image = new Image(imageDir);
                image2 = new Image(imageDir2);
            } catch (SlickException e) {
                e.printStackTrace();
            }
            imageCreated = true;
        }
        if (isVisible) {
            if (isLeft) {
                g.drawImage(image, coordX - offset, coordY);
            } else {
                g.drawImage(image2, coordX - offset, coordY);
            }
        }
    }

}

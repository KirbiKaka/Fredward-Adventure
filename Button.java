import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Button extends InteractableEntity{

    private final String puzzle;
    private Image image2;
    private final String imageDir2;
    private boolean isPressed;

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
        // TODO Auto-generated method stub
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
        // TODO Auto-generated method stub
        return true;
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
        // TODO Auto-generated method stub

    }

    @Override
    void update(int delta) {
        // TODO Auto-generated method stub

    }

}

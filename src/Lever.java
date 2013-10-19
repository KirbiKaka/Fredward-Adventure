import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Lever extends InteractableEntity{

    private boolean isLeft;
    private final String imageDir2;
    private Image image2;
    private final String puzzle;
    private final String left, right;

    public Lever(int coordX, int coordY, String imageDir, String imageDir2, String puzzle) {
        super(50, 67, coordX, coordY, imageDir);
        this.imageDir2 = imageDir2;
        this.puzzle = puzzle;
        left = "To the left, to the left.";
        right = "Right, right?";
    }

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
        // TODO Auto-generated method stub
        isLeft = !isLeft;
        if (isLeft) {
            TextBox.writeText(left);
        } else {
            TextBox.writeText(right);
        }
    }

    @Override
    boolean isInteractable() {
        // TODO Auto-generated method stub
        return true;
    }

    public boolean isLeft() {
        return isLeft;
    }

    @Override
    boolean isSolid() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    void init() {
        // TODO Auto-generated method stub

    }

    @Override
    void update(int delta) {
        // TODO Auto-generated method stub

    }

    @Override
    void draw(Graphics g) {
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
            if (isLeft) {
                g.drawImage(image, coordX, coordY);
            } else {
                g.drawImage(image2, coordX, coordY);
            }
        }
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
            if (isLeft) {
                g.drawImage(image, coordX - offset, coordY);
            } else {
                g.drawImage(image2, coordX - offset, coordY);
            }
        }
    }

}

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/** An entity that is interactable and can only become non-solid if a key is present. */
public class Door extends InteractableEntity{

    private final String key;

    /** Holds the information for the image of the Door opened. */
    private final String imageDir2;
    private Image image2;

    private boolean isOpen;

    /** Messages for when interacted with a locked door, an open door, and a closed door. */
    private final String locked, open, closed;

    /** Size and messages are set to default values. */
    public Door(int coordX, int coordY, String imageDir, String imageDir2, String key) {
        super(50, 67, coordX, coordY, imageDir);
        this.imageDir2 = imageDir2;
        this.key = key;
        locked = "Locked... Maybe there's a key?\n                                   \n...nah. Probably not.";
        open = "Jeepers, it's open now!";
        closed = "Let's block out the draft, eh?";
    }

    /** Messages are set to default values. */
    public Door(int sizeX, int sizeY, int coordX, int coordY, String imageDir, String imageDir2, String key) {
        super(sizeX, sizeY, coordX, coordY, imageDir);
        this.imageDir2 = imageDir2;
        this.key = key;
        locked = "Locked... Maybe there's a key?\n                                   \n...nah. Probably not.";
        open = "Jeepers, it's open now!";
        closed = "Let's block out the draft, eh?";
    }

    public Door(int sizeX, int sizeY, int coordX, int coordY, String imageDir, String imageDir2, String key, String locked, String open, String closed) {
        super(sizeX, sizeY, coordX, coordY, imageDir);
        this.imageDir2 = imageDir2;
        this.key = key;
        this.locked = locked;
        this.open = open;
        this.closed = closed;
    }

    /** Can be opened and closed after key is acquired. */
    @Override
    void interact() {
        if (Inventory.items.contains(key)) {
            isOpen = !isOpen;
            if (isOpen) {
                TextBox.writeText(open);
            } else {
                TextBox.writeText(closed);
            }
        } else {
            TextBox.writeText(locked);
        }
    }

    @Override
    boolean isInteractable() {
        return true;
    }

    @Override
    boolean isSolid() {
        return !isOpen;
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
            if (!isOpen) {
                g.drawImage(image, coordX - offset, coordY);
            } else {
                g.drawImage(image2, coordX - offset, coordY);
            }
        }
    }

}

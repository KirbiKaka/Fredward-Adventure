import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Door extends InteractableEntity{

    private boolean isOpen;
    private final String imageDir2;
    private Image image2;
    private final String key;
    private final String locked, open, closed;

    public Door(int coordX, int coordY, String imageDir, String imageDir2, String key) {
        super(50, 67, coordX, coordY, imageDir);
        this.imageDir2 = imageDir2;
        this.key = key;
        locked = "Locked... Maybe there's a key?\n                                   \n...nah. Probably not.";
        open = "Jeepers, it's open now!";
        closed = "Let's block out the draft, eh?";
    }

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

    @Override
    void interact() {
        // TODO Auto-generated method stub
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
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    boolean isSolid() {
        // TODO Auto-generated method stub
        return !isOpen;
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
            if (!isOpen) {
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
            if (!isOpen) {
                g.drawImage(image, coordX - offset, coordY);
            } else {
                g.drawImage(image2, coordX - offset, coordY);
            }
        }
    }

}

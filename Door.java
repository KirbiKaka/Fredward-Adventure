import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Door extends InteractableEntity{

    private boolean isOpen;
    private final String imageDir2;
    private Image image2;

    public Door(int coordX, int coordY, String imageDir, String imageDir2) {
        super(50, 50, coordX, coordY, imageDir);
        this.imageDir2 = imageDir2;
    }

    public Door(int sizeX, int sizeY, int coordX, int coordY, String imageDir, String imageDir2) {
        super(sizeX, sizeY, coordX, coordY, imageDir);
        this.imageDir2 = imageDir2;
    }

    @Override
    void interact() {
        // TODO Auto-generated method stub
        isOpen = !isOpen;
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
        if (!isOpen) {
            g.drawImage(image, coordX, coordY);
        } else {
            g.drawImage(image2, coordX, coordY);
        }
    }

}

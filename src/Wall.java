import org.newdawn.slick.Image;

/** A solid entity that is not interactable. */
public class Wall extends EntityObject {

    private Image image;
    private boolean imageCreated;

    /** Size is set to default. */
    public Wall(int coordX, int coordY, String imageDir) {
        super(20, 11, coordX, coordY, imageDir);
    }

    public Wall(int sizeX, int sizeY, int coordX, int coordY, String imageDir) {
        super(sizeX, sizeY, coordX, coordY, imageDir);
    }

    @Override
    boolean isInteractable() {
        return false;
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

}

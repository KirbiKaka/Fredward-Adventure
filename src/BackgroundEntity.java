import org.newdawn.slick.Image;

/** An entity that is neither interactable, nor solid. Serves as a background image. */
public class BackgroundEntity extends EntityObject {

    private Image image;

    public BackgroundEntity(int coordX, int coordY, String imageDir) {
        super(50, 50, coordX, coordY, imageDir);
    }

    public BackgroundEntity(int sizeX, int sizeY, int coordX, int coordY, String imageDir) {
        super(sizeX, sizeY, coordX, coordY, imageDir);

    }

    @Override
    boolean isInteractable() {
        return false;
    }

    @Override
    boolean isSolid() {
        return false;
    }

    @Override
    void init() {

    }

    @Override
    void update(int delta) {

    }

}

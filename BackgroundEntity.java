import org.newdawn.slick.Image;

public class BackgroundEntity extends EntityObject {

    private Image image;
    private boolean imageCreated;

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
        // TODO Auto-generated method stub

    }

    @Override
    void update(int delta) {
        // TODO Auto-generated method stub

    }

}

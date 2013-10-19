import org.newdawn.slick.Image;

public class Wall extends EntityObject {

    private Image image;
    private boolean imageCreated;

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
        // TODO Auto-generated method stub

    }

    @Override
    void update(int delta) {
        // TODO Auto-generated method stub

    }

}

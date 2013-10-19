

public class Player extends EntityObject {

    public static final int PLAYER_SIZE_X = 100;
    public static final int PLAYER_SIZE_Y = 100;

    public Player(int coordX, int coordY, String imageDir) {
        super(50, 50, coordX, coordY, imageDir);
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
    void update() {

    }


}

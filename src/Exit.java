
public class Exit extends InteractableEntity {

    private final int exitID;
    private final String message;

    public Exit(int sizeX, int sizeY, int coordX, int coordY, String imageDir, int exitID, String message) {
        super(sizeX, sizeY, coordX, coordY, imageDir);
        this.exitID = exitID;
        this.message = message;
    }

    @Override
    void interact() {
        MainGame.changeLevel(exitID);
        TextBox.writeText(message);
    }

    @Override
    boolean isSolid() {
        // TODO Auto-generated method stub
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

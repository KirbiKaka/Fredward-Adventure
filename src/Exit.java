
/** An Entity that is not visible, but acts as an interactable location to move to a new Level. */
public class Exit extends InteractableEntity {

    /** The ID of the Level this Exit points to. */
    private final int exitID;
    /** The message displayed on the TextBox after moving. */
    private final String message;

    public Exit(int sizeX, int sizeY, int coordX, int coordY, String imageDir, int exitID, String message) {
        super(sizeX, sizeY, coordX, coordY, imageDir);
        this.exitID = exitID;
        this.message = message;
        isVisible = false;
    }

    @Override
    void interact() {
        MainGame.changeLevel(exitID);
        TextBox.writeText(message);
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

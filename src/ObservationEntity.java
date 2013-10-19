/** An Entity that is solid and interactable, but interaction only yields a message on the TextBox. */
public class ObservationEntity extends InteractableEntity {

    private final String message;

    public ObservationEntity(int sizeX, int sizeY, int coordX, int coordY,
            String imageDir, String message) {
        super(sizeX, sizeY, coordX, coordY, imageDir);
        this.message = message;
    }

    @Override
    void interact() {
        TextBox.writeText(message);

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

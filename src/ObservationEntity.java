
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
        // TODO Auto-generated method stub
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


public abstract class InteractableEntity extends EntityObject {

    public InteractableEntity(int sizeX, int sizeY, int coordX, int coordY, String imageDir) {
        super(sizeX, sizeY, coordX, coordY, imageDir);
    }

    @Override
    boolean isInteractable() {
        return true;
    }

    abstract void interact();
}

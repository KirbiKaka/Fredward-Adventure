/** An interactable entity that is not solid. When interacted with, it loses visibility and puts an item in the inventory. */
public class Item extends InteractableEntity {

    private boolean taken;
    private final String itemID, message;

    /** Size is set to default. */
    public Item(int coordX, int coordY, String imageDir, String itemID, String message) {
        super(50, 50, coordX, coordY, imageDir);
        taken = false;
        this.itemID = itemID;
        this.message = message;
    }

    public Item(int sizeX, int sizeY, int coordX, int coordY, String imageDir, String itemID, String message) {
        super(sizeX, sizeY, coordX, coordY, imageDir);
        taken = false;
        this.itemID = itemID;
        this.message = message;
    }

    @Override
    void interact() {
        taken = true;
        Inventory.items.add(itemID);
        TextBox.writeText(message);
        hide();
    }

    @Override
    boolean isInteractable() {
        return !taken;
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

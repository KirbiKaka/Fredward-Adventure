import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/** An object that exists in the gamespace during the MainGame State.
 * EntityObjects can be interactable or solid. */
public abstract class EntityObject {
    protected int sizeX, sizeY, coordX, coordY;
    Image image;
    boolean imageCreated;
    String imageDir;
    boolean isVisible;

    public EntityObject(int sizeX, int sizeY, int coordX, int coordY, String imageDir) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.coordX = coordX;
        this.coordY = coordY;
        this.imageDir = imageDir;
        this.isVisible = true;
    }

    abstract boolean isInteractable();
    abstract boolean isSolid();
    abstract void init();
    abstract void update(int delta);


    void draw(Graphics g) {
        if (!imageCreated) {
            try {
                image = new Image(imageDir);
            } catch (SlickException e) {
                e.printStackTrace();
            }
            imageCreated = true;
        }
        if (isVisible) {
            g.drawImage(image, coordX, coordY);
        }
    }

    void draw(Graphics g, int offset) {
        if (!imageCreated) {
            try {
                image = new Image(imageDir);
            } catch (SlickException e) {
                e.printStackTrace();
            }
            imageCreated = true;
        }
        if (isVisible) {
            g.drawImage(image, coordX - offset, coordY);
        }
    }

    public boolean isVisible() {
        return isVisible();
    }

    public void hide() {
        isVisible = false;
    }

    public void show() {
        isVisible = true;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public int getCoordX() {
        return coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void move(int x, int y) {
        coordX = x;
        coordY = y;
    }

    public void moveRelative(int x, int y) {
        coordX += x;
        coordY += y;
    }

    public void moveX(int x) {
        coordX += x;
    }

    public void moveY(int y) {
        coordY += y;
    }

    /** Returns true if moving this EntityObject (x, y) would not cause collision with ent.
     * Mainly tracks the feet/bottom of the EntityObject. */
    public boolean canMove(int x, int y, EntityObject ent) {
        int otherCX = ent.getCoordX();
        int otherCY = ent.getCoordY();
        int otherSX = ent.getSizeX();
        int otherSY = ent.getSizeY();
        boolean leftSideCollide = coordX + x + 5 > otherCX && coordX + x + 5 < otherCX + otherSX;
        boolean rightSideCollide = coordX + sizeX + x - 5 >= otherCX && coordX + sizeX + x - 5 < otherCX + otherSX;
        boolean bottomCollide = coordY + sizeY + y >= otherCY && coordY + sizeY + y < otherCY + otherSY;
        boolean topCollide = coordY + sizeY + y - 10 >= otherCY && coordY + sizeY + y - 10 < otherCY + otherSY;
        if (leftSideCollide || rightSideCollide) {
            if (bottomCollide || topCollide) {
                return false;
            }
        }
        return true;
    }

    /** Returns true is this EntityObject is very close to ent.
     * Mainly tracks the feet/bottom of the EntityObject. */
    public boolean isTouching(EntityObject ent) {
        int otherCX = ent.getCoordX();
        int otherCY = ent.getCoordY();
        int otherSX = ent.getSizeX();
        int otherSY = ent.getSizeY();
        boolean leftSideCollide = (coordX + 20 > otherCX && coordX + 20 < otherCX + otherSX)
                || (coordX - 20 > otherCX && coordX - 20 < otherCX + otherSX);
        boolean rightSideCollide = (coordX + sizeX + 20 > otherCX && coordX + sizeX + 20 < otherCX + otherSX)
                || (coordX + sizeX - 20 > otherCX && coordX + sizeX - 20 < otherCX + otherSX);
        boolean bottomCollide = (coordY + sizeY + 20 > otherCY && coordY + sizeY + 20 < otherCY + otherSY)
                || (coordY + sizeY - 20 > otherCY && coordY + sizeY - 20 < otherCY + otherSY);
        boolean bottomCollide2 = (coordY + sizeY + 10 > otherCY && coordY + sizeY + 10 < otherCY + otherSY)
                || (coordY + sizeY - 10 > otherCY && coordY + sizeY - 10 < otherCY + otherSY);
        if (leftSideCollide || rightSideCollide) {
            if (bottomCollide || bottomCollide2) {
                return true;
            }
        }
        return false;
    }

}

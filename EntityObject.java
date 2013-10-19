import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

//Everything a "thing" on the map should be able to do
public abstract class EntityObject {
    protected int sizeX, sizeY, coordX, coordY;
    Image image;
    boolean imageCreated;
    String imageDir;

    public EntityObject(int sizeX, int sizeY, int coordX, int coordY, String imageDir) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.coordX = coordX;
        this.coordY = coordY;
        this.imageDir = imageDir;
    }

    abstract boolean isInteractable();
    abstract boolean isSolid();
    abstract void init();
    abstract void update();


    void draw(Graphics g) {
        if (!imageCreated) {
            try {
                image = new Image(imageDir);
            } catch (SlickException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            imageCreated = true;
        }
        g.drawImage(image, coordX, coordY);
    }

    void draw(Graphics g, int offset) {
        if (!imageCreated) {
            try {
                image = new Image(imageDir);
            } catch (SlickException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            imageCreated = true;
        }
        g.drawImage(image, coordX - offset, coordY);
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

    // entityObject is a solid entity
    // true if you can move, despite the entity
    public boolean canMove(int x, int y, EntityObject ent) {
        int otherCX = ent.getCoordX();
        int otherCY = ent.getCoordY();
        int otherSX = ent.getSizeX();
        int otherSY = ent.getSizeY();
        boolean leftSideCollide = coordX + x + 2 > otherCX && coordX + x + 2 < otherCX + otherSX;
        boolean rightSideCollide = coordX + sizeX + x - 2 >= otherCX && coordX + sizeX + x - 2 < otherCX + otherSX;
        boolean bottomCollide = coordY + sizeY + y >= otherCY && coordY + sizeY + y < otherCY + otherSY;
        boolean topCollide = coordY + sizeY + y - 10 >= otherCY && coordY + sizeY + y - 10 < otherCY + otherSY;
        if (leftSideCollide || rightSideCollide) {
            if (bottomCollide || topCollide) {
                return false;
            }
        }
        return true;
    }

    public boolean isTouching(EntityObject ent) {
        int otherCX = ent.getCoordX();
        int otherCY = ent.getCoordY();
        int otherSX = ent.getSizeX();
        int otherSY = ent.getSizeY();
        boolean leftSideCollide = (coordX + 10 > otherCX && coordX + 10 < otherCX + otherSX) || (coordX - 10 > otherCX && coordX - 10 < otherCX + otherSX);
        boolean rightSideCollide = (coordX + sizeX + 10 > otherCX && coordX + sizeX + 10 < otherCX + otherSX) || (coordX + sizeX - 10 > otherCX && coordX + sizeX - 10 < otherCX + otherSX);
        boolean bottomCollide = (coordY + sizeY + 10 > otherCY && coordY + sizeY + 10 < otherCY + otherSY) || (coordY + sizeY - 20 > otherCY && coordY + sizeY - 20 < otherCY + otherSY);
        if (leftSideCollide || rightSideCollide) {
            if (bottomCollide) {
                return true;
            }
        }
        return false;
    }

}

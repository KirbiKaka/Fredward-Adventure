import java.util.ArrayList;

import org.newdawn.slick.Graphics;


public abstract class Level {
    protected ArrayList<EntityObject> entities = new ArrayList<EntityObject>();
    protected ArrayList<InteractableEntity> interactables = new ArrayList<InteractableEntity>();
    protected int sizeX, sizeY;
    protected Player player;
    //for scrolling the map
    int offset;

    public Level(Player player) {
        this.player = player;
        offset = 0;
    }

    public abstract void init();

    public void update() {
        if (player.getCoordX() > 200 && offset + 200 < sizeX) {
            offset = player.getCoordX() - 200;
        }
        for (EntityObject ent : entities) {
            ent.update();
        }
        for (InteractableEntity inter : interactables) {
            inter.update();
        }
        player.update();
    }

    public void draw(Graphics g) {
        for (EntityObject ent : entities) {
            if (ent != null) {
                ent.draw(g, offset);
            }
        }
        for (InteractableEntity inter : interactables) {
            if (inter != null) {
                inter.draw(g, offset);
            }
        }
        player.draw(g, offset);
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public Player getPlayer() {
        return player;
    }

    public int getOffset() {
        return offset;
    }

    public boolean movePlayer(int x, int y) {
        for (EntityObject ent : entities) {
            if (ent != null && ent.isSolid() && !(ent instanceof Player)) {
                if (!player.canMove(x, y, ent)) {
                    return false;
                }
            }
        }
        for (InteractableEntity inter : interactables) {
            if (inter != null && inter.isSolid()) {
                if (!player.canMove(x, y, inter)) {
                    return false;
                }
            }
        }
        player.moveRelative(x, y);
        return true;
    }

    public boolean tryInteract() {
        for (InteractableEntity inter : interactables) {
            if (inter != null && inter.isInteractable()) {
                if (player.isTouching(inter)) {
                    inter.interact();
                    return true;
                }
            }
        }
        return false;
    }
}

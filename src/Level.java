import java.util.ArrayList;

import org.newdawn.slick.Graphics;

/** Abstract class for levels/stages in the game */
public abstract class Level {
    private static final double SPEED_FACTOR_SLOW = 0.20;
    private static final double SPEED_FACTOR = 0.25;

    protected ArrayList<EntityObject> entities = new ArrayList<EntityObject>();
    protected ArrayList<InteractableEntity> interactables = new ArrayList<InteractableEntity>();
    protected int sizeX, sizeY;
    protected Player player;
    /** Used for scrolling the camera. */
    int offset;

    public Level(Player player) {
        this.player = player;
        offset = 0;
    }

    public abstract void init();

    public void update(int delta) {
        //Scrolls the camera.
        if (player.getCoordX() - offset > 475 && offset + 800 < sizeX) {
            if (player.getCoordX() - offset > 550) {
                offset += (int)(delta * SPEED_FACTOR);
            } else {
                offset += (int)(delta * SPEED_FACTOR_SLOW);
            }
            if (offset + 800 > sizeX) {
                offset = sizeX - 800;
            }
        } else if (player.getCoordX() - offset < 325 && offset > 0) {
            if (player.getCoordX() - offset < 250) {
                offset -= (int)(delta * SPEED_FACTOR);
            } else {
                offset -= (int)(delta * SPEED_FACTOR_SLOW);
            }
            if (offset < 0) {
                offset = 0;
            }
        }
        //Updates all Entities
        for (EntityObject ent : entities) {
            ent.update(delta);
        }
        for (InteractableEntity inter : interactables) {
            inter.update(delta);
        }
        player.update(delta);
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

    /** Attempts to move the player, only if there will be no collision with any solid entities. */
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

    /** Checks if the player is close to any interactables, and interacts with it. */
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

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/** A special Entity that represents the Player. */
public class Player extends EntityObject {

    public static final int PLAYER_SIZE_X = 100;
    public static final int PLAYER_SIZE_Y = 100;
    private final int animationDelay = 300;

    /** Fields used for animation. */
    private boolean movingLeft, movingRight;
    private double accumulatedDelay;
    private boolean animatedLeft, animatedRight;

    private Image left, right;

    public Player(int coordX, int coordY, String imageDir) {
        super(50, 62, coordX, coordY, imageDir);
    }

    @Override
    public void moveRelative(int x, int y) {
        coordX += x;
        coordY += y;
        if (x > 0) {
            movingRight = true;
        } else if (x < 0 || y > 0) {
            movingLeft = true;
        } else {
            movingRight = true;
        }
    }

    @Override
    void draw(Graphics g, int offset) {
        if (!imageCreated) {
            try {
                image = new Image(imageDir);
                left = new Image("Sprites/spriteLeft.png");
                right = new Image("Sprites/spriteRight.png");
            } catch (SlickException e) {
                e.printStackTrace();
            }
            imageCreated = true;
        }
        /** Controls basic animation. */
        if (isVisible) {
            if (movingRight) {
                if (accumulatedDelay >= animationDelay) {
                    if (animatedRight) {
                        g.drawImage(image, coordX - offset, coordY);
                        movingRight = false;
                        animatedRight = false;
                    } else {
                        g.drawImage(right, coordX - offset, coordY);
                        movingRight = false;
                        animatedRight = true;
                    }
                    accumulatedDelay = 0;
                } else {
                    if (animatedRight) {
                        g.drawImage(right, coordX - offset, coordY);
                    } else {
                        g.drawImage(image, coordX - offset, coordY);
                    }
                }
            } else if (movingLeft) {
                if (accumulatedDelay >= animationDelay) {
                    if (animatedLeft) {
                        g.drawImage(image, coordX - offset, coordY);
                        movingLeft = false;
                        animatedLeft = false;
                    } else {
                        g.drawImage(left, coordX - offset, coordY);
                        movingLeft = false;
                        animatedLeft = true;
                    }
                    accumulatedDelay = 0;
                } else {
                    if (animatedLeft) {
                        g.drawImage(left, coordX - offset, coordY);
                    } else {
                        g.drawImage(image, coordX - offset, coordY);
                    }
                }
            } else {
                g.drawImage(image, coordX - offset, coordY);
            }
        }
    }

    @Override
    boolean isInteractable() {
        return false;
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
        accumulatedDelay += delta;
    }


}

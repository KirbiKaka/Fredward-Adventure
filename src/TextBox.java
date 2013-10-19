import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/** TextBox at the bottom of the screen that controls dialogue and observations. */
public class TextBox extends EntityObject {

    private static final double TEXT_SPEED_FACTOR = 0.10;
    /** Number of miliseconds a completed String stays on the TextBox. */
    private static final int TEXT_DURATION = 5000;
    private static String text;

    /** How much of the String written so far. */
    private static int charsWritten;
    /** How long the String has been completely written. */
    private static double durationDone;

    public TextBox(int coordX, int coordY, String imageDir) {
        super(800, 170, coordX, coordY, imageDir);
        durationDone = -1;
    }

    public TextBox(int sizeX, int sizeY, int coordX, int coordY, String imageDir) {
        super(sizeX, sizeY, coordX, coordY, imageDir);
        durationDone = -1;
    }

    public static void writeText(String text) {
        TextBox.text = text;
        charsWritten = 0;
        durationDone = 0;
    }

    @Override
    boolean isInteractable() {
        return false;
    }

    @Override
    boolean isSolid() {
        return false;
    }

    @Override
    void init() {
    }

    @Override
    void draw(Graphics g) {
        if (!imageCreated) {
            try {
                image = new Image(imageDir);
            } catch (SlickException e) {
                e.printStackTrace();
            }
            imageCreated = true;
        }
        g.drawImage(image, coordX, coordY);
        if (durationDone != -1 && durationDone < TEXT_DURATION) {
            String s = "";
            for (int i = 0; i < charsWritten; i++) {
                s += TextBox.text.charAt(i);
            }
            g.drawString(s, coordX + 20, coordY + 20);
        }
    }

    @Override
    void update(int delta) {
        if (TextBox.text != null) {
            charsWritten += delta * TEXT_SPEED_FACTOR;
            if (charsWritten >= text.length()) {
                charsWritten = text.length();
                durationDone += delta;
            }
        }
    }

}

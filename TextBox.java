import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class TextBox extends EntityObject {

    private static final double TEXT_SPEED_FACTOR = 0.10;
    private static String text;
    //how much of the string is written so far
    private static int charsWritten;
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
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    boolean isSolid() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    void init() {
        // TODO Auto-generated method stub
    }

    @Override
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
        if (durationDone != -1 && durationDone < 3000) {
            String s = "";
            for (int i = 0; i < charsWritten; i++) {
                s += TextBox.text.charAt(i);
            }
            g.drawString(s, coordX + 20, coordY + 20);
        }
    }

    @Override
    void update(int delta) {
        // TODO Auto-generated method stub
        if (TextBox.text != null) {
            charsWritten += delta * TEXT_SPEED_FACTOR;
            if (charsWritten >= text.length()) {
                charsWritten = text.length();
                durationDone += delta;
            }
        }
    }

}

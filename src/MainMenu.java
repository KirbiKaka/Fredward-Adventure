import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class MainMenu extends BasicGameState{
    private boolean imageMade = false;
    public static final int STATE_ID = 0;
    private static final int NUM_OPTIONS = 3;
    private StateBasedGame game;
    private int selection = 0;
    private Image background;
    private Image playGame;
    private Image option;
    private Image quit;
    private Image arrow;
    private Image block;
    private Image sprite;
    /*private static final int SIZE = 34;
    private final float x = 34f;
    private final float y = 34f;*/

    @Override
    public void init(GameContainer container, StateBasedGame game)
        throws SlickException {
        //background = new Image("Sprites/background copy.png");
        this.game = game;

    }
    /** Get the background. */
    Image getBackground() {
        return background;
    }
    /** Get the playGame.*/
    Image getPlayGame() {
        return playGame;
    }
    /** Get the option. */
    Image getOption() {
        return option;
    }
    /** Get the quit. */
    Image getQuit() {
        return quit;
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g)
        throws SlickException {
        if (!imageMade) {
            background = new Image("Sprites/background copy.png"); //dont keep here
            playGame = new Image("Sprites/playgame.png");
            quit = new Image("Sprites/quit.png");
            option = new Image("Sprites/options.png");
            arrow = new Image("Sprites/arrow.png");
            block = new Image("Sprites/block.png");
            sprite = new Image("Sprites/sprite.png");
            imageMade = true;

        }
        g.setColor(Color.white);
        g.drawString("Platformer", 100, 50);
        g.drawImage(background, 0, 0);
        g.drawImage(block, 250, 400);
        g.drawImage(block, 500, 400);
        //g.drawImage(sprite, 50, 550);
        //sprite.draw((int)x, (int)y);
        if (selection == 0) {
            g.drawImage(arrow,0,53);
            g.drawImage(playGame, 200, 50);
            g.drawImage(option, 200, 150);
            g.drawImage(quit, 200, 250);
            /*g.drawString("> 1. Play Game <", 50, 100);
            g.drawString("2. Options", 50, 120);
            g.drawString("3. Quit", 50, 140);*/
        } else if (selection == 1) {
            g.drawImage(playGame, 200, 50);
            g.drawImage(arrow,0,153);
            g.drawImage(option, 200, 150);
            g.drawImage(quit, 200, 250);
            /*g.drawString("1. Play Game", 50, 100);
            g.drawString("> 2. Options <", 50, 120);
            g.drawString("3. Quit", 50, 140);*/
        } else if (selection == 2) {
            g.drawImage(playGame, 200, 50);
            g.drawImage(option, 200, 150);
            g.drawImage(arrow,0,253);
            g.drawImage(quit, 200, 250);
            /*g.drawString("1. Play Game", 50, 100);
            g.drawString("2. Options", 50, 120);
            g.drawString("> 3. Quit <", 50, 140);*/
        }

    }

    @Override
    public void keyReleased(int key, char c) {
        switch(key) {
        case Input.KEY_1:
            game.enterState(MainGame.STATE_ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
            break;
        case Input.KEY_2:
            game.enterState(OptionsMenu.STATE_ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
            break;
        case Input.KEY_3:
            System.exit(1);
            break;
        case Input.KEY_DOWN:
            if (selection < NUM_OPTIONS - 1) {
                selection++;
            }
            break;
        case Input.KEY_UP:
            if (selection > 0) {
                selection--;
            }
            break;
        case Input.KEY_ENTER:
            switch(selection) {
            case 0:
                game.enterState(MainGame.STATE_ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
                break;
            case 1:
                game.enterState(OptionsMenu.STATE_ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
                break;
            case 2:
                System.exit(1);
                break;
            }
            break;
        case Input.KEY_SPACE:
            switch(selection) {
            case 0:
                game.enterState(MainGame.STATE_ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
                break;
            case 1:
                game.enterState(OptionsMenu.STATE_ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
                break;
            case 2:
                System.exit(1);
                break;
            }
            break;
        default:
            break;
        }
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta)
        throws SlickException {
        // TODO Auto-generated method stub

    }

    @Override
    public int getID() {
        // TODO Auto-generated method stub
        return STATE_ID;
    }

}
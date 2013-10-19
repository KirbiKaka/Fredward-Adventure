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

/** Game state for the Main Menu. */
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

    @Override
    public void init(GameContainer container, StateBasedGame game)
        throws SlickException {
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
        if (selection == 0) {
            g.drawImage(arrow,0,53);
            g.drawImage(playGame, 200, 50);
            g.drawImage(option, 200, 150);
            g.drawImage(quit, 198, 250);
        } else if (selection == 1) {
            g.drawImage(playGame, 200, 50);
            g.drawImage(arrow,0,153);
            g.drawImage(option, 200, 150);
            g.drawImage(quit, 198, 250);
        } else if (selection == 2) {
            g.drawImage(playGame, 200, 50);
            g.drawImage(option, 200, 150);
            g.drawImage(arrow,0,253);
            g.drawImage(quit, 198, 250);
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
    }

    @Override
    public int getID() {
        return STATE_ID;
    }

}
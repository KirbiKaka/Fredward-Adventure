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

/** Game state for the Options menu, reachable from the Main Menu. */
public class OptionsMenu extends BasicGameState{
    private boolean imageMade = false;
    public static final int STATE_ID = 1;
    private static final int NUM_OPTIONS = 2;
    private StateBasedGame game;
    private GameContainer container;
    private int selection = 0;
    private Image background;
    private Image option;
    private Image arrow;
    private Image back;
    private Image fullscreenON, fullscreenOFF;

    @Override
    public void init(GameContainer container, StateBasedGame game)
        throws SlickException {
        this.container = container;
        this.game = game;
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g)
        throws SlickException {
        if (!imageMade) {
            background = new Image("Sprites/background copy.png");
            fullscreenON = new Image("Sprites/FullscreenOn.png");
            fullscreenOFF = new Image("Sprites/FullscreenOff.png");
            option = new Image("Sprites/options.png");
            arrow = new Image("Sprites/arrow.png");
            back = new Image("Sprites/back.png");
            imageMade = true;

        }
        g.setColor(Color.white);
        g.drawImage(option,100,50);
        g.drawImage(background, 0, 0);
        if (selection == 0) {
            g.drawImage(arrow, 0, 53);
        } else if (selection == 1) {
            g.drawImage(arrow, 0, 153);
        }

        if (container.isFullscreen()) {
            g.drawImage(fullscreenON, 200, 58);
        } else {
            g.drawImage(fullscreenOFF, 200, 58);
        }
        g.drawImage(back, 210, 148);

    }

    @Override
    public void keyReleased(int key, char c) {
        switch(key) {
        case Input.KEY_1:
            try {
                container.setFullscreen(!container.isFullscreen());
            } catch (SlickException e) {
                e.printStackTrace();
            }
            break;
        case Input.KEY_2:
            game.enterState(MainMenu.STATE_ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
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
                try {
                    container.setFullscreen(!container.isFullscreen());
                } catch (SlickException e) {
                    e.printStackTrace();
                }
                break;
            case 1:
                game.enterState(MainMenu.STATE_ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
                break;
            }
            break;
        case Input.KEY_SPACE:
            switch(selection) {
            case 0:
                try {
                    container.setFullscreen(!container.isFullscreen());
                } catch (SlickException e) {
                    e.printStackTrace();
                }
                break;
            case 1:
                game.enterState(MainMenu.STATE_ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
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
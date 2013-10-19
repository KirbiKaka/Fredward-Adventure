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

public class OptionsMenu extends BasicGameState{
    private boolean imageMade = false;
    public static final int STATE_ID = 1;
    private static final int NUM_OPTIONS = 1;
    private StateBasedGame game;
    private int selection = 0;
    private Image background;
    //private Image playGame;
    private Image option;
    //private Image quit;
    private Image arrow;
    private Image back;


    @Override
    public void init(GameContainer container, StateBasedGame game)
        throws SlickException {

        this.game = game;
        //background = new Image("Sprites/background copy.png");

    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g)
        throws SlickException {
        if (!imageMade) {
            background = new Image("Sprites/background copy.png"); //dont keep here
            //playGame = new Image("Sprites/playgame.png");
            //quit = new Image("Sprites/quit.png");
            option = new Image("Sprites/options.png");
            arrow = new Image("Sprites/arrow.png");
            back = new Image("Sprites/back.png");
            imageMade = true;

        }
        g.setColor(Color.white);
        g.drawImage(option,100,50);
        g.drawImage(background, 0, 0);
        if (selection == 0) {
            g.drawImage(arrow,0, 53);
            g.drawImage(back, 210, 48);
            //g.drawString("> 1. Back <", 50, 100);
        }

    }

    @Override
    public void keyReleased(int key, char c) {
        switch(key) {
        case Input.KEY_1:
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
                game.enterState(MainMenu.STATE_ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
                break;
            }
            break;
        case Input.KEY_SPACE:
            switch(selection) {
            case 0:
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
        // TODO Auto-generated method stub

    }

    @Override
    public int getID() {
        // TODO Auto-generated method stub
        return STATE_ID;
    }

}
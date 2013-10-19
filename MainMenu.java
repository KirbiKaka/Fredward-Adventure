

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class MainMenu extends BasicGameState{

    public static final int STATE_ID = 0;
    private static final int NUM_OPTIONS = 3;
    private StateBasedGame game;
    private int selection = 0;

    @Override
    public void init(GameContainer container, StateBasedGame game)
            throws SlickException {
        this.game = game;

    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g)
            throws SlickException {
        g.setColor(Color.white);
        g.drawString("Platformer", 100, 50);

        if (selection == 0) {
            g.drawString("> 1. Play Game <", 50, 100);
            g.drawString("2. Options", 50, 120);
            g.drawString("3. Quit", 50, 140);
        } else if (selection == 1) {
            g.drawString("1. Play Game", 50, 100);
            g.drawString("> 2. Options <", 50, 120);
            g.drawString("3. Quit", 50, 140);
        } else if (selection == 2) {
            g.drawString("1. Play Game", 50, 100);
            g.drawString("2. Options", 50, 120);
            g.drawString("> 3. Quit <", 50, 140);
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
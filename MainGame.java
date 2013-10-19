

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainGame extends BasicGameState{

    public static final int STATE_ID = 2;
    private StateBasedGame game;

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
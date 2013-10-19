

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainGame extends BasicGameState{

    public static final int STATE_ID = 2;
    private static final int NUM_OF_LEVELS = 1;
    private static final double SPEED_FACTOR = 0.25;


    private StateBasedGame game;
    private Player player;
    public Level[] levels;
    private int currentLevel;
    private boolean isMovingDown, isMovingUp, isMovingLeft, isMovingRight;
    public static TextBox textBox;

    @Override
    public void init(GameContainer container, StateBasedGame game)
            throws SlickException {
        this.game = game;
        player = new Player(0, 0, "Sprites/sprite.png");
        textBox = new TextBox(0, 600-170, "Sprites/textBox.png");
        createLevels();
        levels[0].init();
        changeLevel(0);
        TextBox.writeText("I'm Fredward. Nice to meet you.");
    }

    public void changeLevel(int level) {
        currentLevel = level;
    }

    private void createLevels() {
        levels = new Level[NUM_OF_LEVELS];
        levels[0] = new Level_1(player);
    }

    @Override
    public void keyPressed(int key, char c) {
        switch(key) {
        case Input.KEY_DOWN:
            isMovingDown = true;
            break;
        case Input.KEY_UP:
            isMovingUp = true;
            break;
        case Input.KEY_RIGHT:
            isMovingRight = true;
            break;
        case Input.KEY_LEFT:
            isMovingLeft = true;
            break;
        case Input.KEY_SPACE:
            levels[currentLevel].tryInteract();
            break;
        case Input.KEY_I:
            Inventory.printItems();
            break;
        default:
            break;
        }
    }

    @Override
    public void keyReleased(int key, char c) {
        switch(key) {
        case Input.KEY_DOWN:
            isMovingDown = false;
            break;
        case Input.KEY_UP:
            isMovingUp = false;
            break;
        case Input.KEY_RIGHT:
            isMovingRight = false;
            break;
        case Input.KEY_LEFT:
            isMovingLeft = false;
            break;
        default:
            break;
        }
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g)
            throws SlickException {
        g.setColor(Color.white);

        levels[currentLevel].draw(g);
        textBox.draw(g);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta)
            throws SlickException {
        if (isMovingDown) {
            levels[currentLevel].movePlayer(0, (int)(delta * SPEED_FACTOR));
        }
        if (isMovingUp) {
            levels[currentLevel].movePlayer(0, -(int)(delta * SPEED_FACTOR));
        }
        if (isMovingLeft) {
            levels[currentLevel].movePlayer(-(int)(delta * SPEED_FACTOR), 0);
        }
        if (isMovingRight) {
            levels[currentLevel].movePlayer((int)(delta * SPEED_FACTOR), 0);
        }

        levels[currentLevel].update(delta);
        textBox.update(delta);
    }

    @Override
    public int getID() {
        // TODO Auto-generated method stub
        return STATE_ID;
    }

}
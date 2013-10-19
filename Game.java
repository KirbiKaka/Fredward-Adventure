import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends StateBasedGame {

    public Game() {
        super("SimpleTest");
    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        addState(new MainMenu());
        addState(new OptionsMenu());
        addState(new MainGame());
    }

    public static void main(String[] args) {
        try {
            Game game = new Game();
            AppGameContainer app = new AppGameContainer(game, 800, 600, false);
            game.init(app);
            game.initStatesList(app);
            app.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

}
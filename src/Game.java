import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/** The Main class for the Game. */
public class Game extends StateBasedGame {

    private final MainMenu mainMenu;

    public Game() {
        super("Fredward Adventures");
        mainMenu = new MainMenu();
    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        addState(mainMenu);
        addState(new OptionsMenu());
        addState(new MainGame());
    }

    /** Return the mainMenu. */
    MainMenu getMainMenu() {
        return mainMenu;
    }

    public static void main(String[] args) {
        try {
            Game game = new Game();
            AppGameContainer app = new AppGameContainer(game, 800, 600, false);
            game.init(app);
            game.initStatesList(app);
            app.setVSync(true);
            app.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

}
/** Level 1. */
public class Level_1 extends Level {

    public Level_1(Player player) {
        super(player);
        sizeX = 900;
        sizeY = 600;
    }

    public static int getLevelID() {
        return 0;
    }

    @Override
    public void init() {
        //Starting position.
        player.move(75, 250);



        //Background.
        for (int i = 0; i <= 900; i += 50) {
            entities.add(new Wall(50, 50, i, 400, "Sprites/ground.png"));
        }
        for (int i = 0; i <= 900; i += 50) {
            for (int k = 0; k <= 350; k += 50) {
                entities.add(new BackgroundEntity(50, 50, i, k, "Sprites/sky.png"));
            }
        }
        for (int i = 0; i <= 900; i += 50) {
            for (int k = 350; k >= 250; k -= 50) {
                entities.add(new BackgroundEntity(50, 50, i, k, "Sprites/grass.png"));
            }
        }
        //Exits
        for (int i = 260; i < 410; i += 30) {
            interactables.add(new ObservationEntity(42, 30, 0, i, "Sprites/shortFence.png", "Nothing of interest to see on this side.\nJust your tragic backstory.\n                                       \nUninteresting."));
        }
        interactables.add(new ObservationEntity(63, 39, 360, 260, "Sprites/rock.png", "It rocks! Ever so gently."));
        interactables.add(new Exit(50, 50, 850, 300, "Sprites/grassPathStoneTop.png", Level_1_1.getLevelID(), "The sun beats down on your little head.\nThe sun is such a bully."));
        interactables.add(new Exit(50, 50, 850, 350, "Sprites/grassPathStoneBottom.png", Level_1_1.getLevelID(), "The sun beats down on your little head.\nThe sun is such a bully."));


        //Columns
        interactables.add(new ObservationEntity(42, 100, 870, 160, "Sprites/column.png", "A column. This way leads inside."));
        interactables.add(new ObservationEntity(42, 100, 800, 160, "Sprites/column.png", "A column. I really don't see why it's any different from the others..."));
        interactables.add(new ObservationEntity(42, 100, 730, 160, "Sprites/column.png", "A column. This way leads inside."));
        interactables.add(new ObservationEntity(42, 100, 660, 160, "Sprites/column.png", "A column. This way leads inside."));
        entities.add(new BackgroundEntity(42, 22, 641, 160-22, "Sprites/TanRoofLeftEdge.png"));

        //More Background
        for (int i = 683; i <= 900; i += 42) {
            entities.add(new BackgroundEntity(42, 22, i, 160-22, "Sprites/TanRoof.png"));
        }

        for (int i = 100; i < 300; i += 30) {
            entities.add(new BackgroundEntity(0, 0, i, 370, "Sprites/shrub_green.png"));
        }
        for (int i = 140; i < 330; i += 22) {
            entities.add(new BackgroundEntity(0, 0, i, 360, "Sprites/shrub_green.png"));
        }
        for (int i = 140; i < 250; i += 34) {
            entities.add(new BackgroundEntity(0, 0, i, 345, "Sprites/shrub_green.png"));
        }

        for (int i = 100; i < 300; i += 30) {
            entities.add(new BackgroundEntity(0, 0, i + 450, 264, "Sprites/shrub_green.png"));
        }
        for (int i = 140; i < 330; i += 22) {
            entities.add(new BackgroundEntity(0, 0, i + 450, 300, "Sprites/shrub_green.png"));
        }
        for (int i = 140; i < 250; i += 34) {
            entities.add(new BackgroundEntity(0, 0, i + 450, 276, "Sprites/shrub_green.png"));
        }

        for (int i = 0; i <= 900; i += 20) {
            entities.add(new Wall(i, 250, "Sprites/wall copy.png"));
        }
        for (int i = 0; i <= 600; i += 20) {
            entities.add(new Wall(-25, i, "Sprites/wall copy.png"));
        }
        for (int i = 0; i <= 600; i += 20) {
            entities.add(new Wall(910, i, "Sprites/wall copy.png"));
        }

    }

}

/** Level 1. */
public class Level_1 extends Level {

    public Level_1(Player player) {
        super(player);
        sizeX = 1000;
        sizeY = 600;
    }

    @Override
    public void init() {
        //Starting position.
        player.move(20, 330);

        //Background.
        for (int i = 0; i <= 1000; i += 50) {
            entities.add(new Wall(50, 50, i, 400, "Sprites/ground.png"));
        }
        for (int i = 0; i <= 1000; i += 50) {
            for (int k = 0; k <= 350; k += 50) {
                entities.add(new BackgroundEntity(50, 50, i, k, "Sprites/sky.png"));
            }
        }
        for (int i = 0; i <= 1000; i += 50) {
            for (int k = 350; k >= 250; k -= 50) {
                entities.add(new BackgroundEntity(50, 50, i, k, "Sprites/grass.png"));
            }
        }
        //Exits
        interactables.add(new Exit(50, 50, 950, 300, "Sprites/grassPathStoneTop.png", 1, "Not too shabby for a random castle in the middle of nowhere.\nThe walkway really sells it."));
        interactables.add(new Exit(50, 50, 950, 350, "Sprites/grassPathStoneBottom.png", 1, "Not too shabby for a random castle in the middle of nowhere.\nThe walkway really sells it."));

        //Columns
        interactables.add(new ObservationEntity(42, 100, 970, 160, "Sprites/column.png", "A column. I really don't see why it's any different from the other two..."));
        interactables.add(new ObservationEntity(42, 100, 900, 160, "Sprites/column.png", "A column. This way leads inside."));
        interactables.add(new ObservationEntity(42, 100, 830, 160, "Sprites/column.png", "A column. This way leads inside."));
        entities.add(new BackgroundEntity(42, 22, 811, 160-22, "Sprites/TanRoofLeftEdge.png"));

        //More Background
        for (int i = 853; i <= 1000; i += 42) {
            entities.add(new BackgroundEntity(42, 22, i, 160-22, "Sprites/TanRoof.png"));
        }
        for (int i = 0; i <= 1000; i += 20) {
            entities.add(new Wall(i, 250, "Sprites/wall copy.png"));
        }
        for (int i = 0; i <= 600; i += 20) {
            entities.add(new Wall(-25, i, "Sprites/wall copy.png"));
        }
        for (int i = 0; i <= 600; i += 20) {
            entities.add(new Wall(1010, i, "Sprites/wall copy.png"));
        }

        //Interactables
        interactables.add(new Item(34, 50, 850, 350, "Sprites/key.png", "Yellow Key", "Look, it's a key! Gee, I wonder what those are used for?"));
        interactables.add(new Door(50, 67, 350, 192, "Sprites/DoorClosed.png", "Sprites/DoorOpen.png", "Yellow Key",
                "Locked... Maybe there's a key?\n                                   \n...nah. Probably not.",
                "Woo, it opened! Wait. What.\n...Who left a door in the middle of a clearing?",
                "All there is behind that door is a concrete wall painted black, anyways."));
        interactables.add(new Button(40, 30, 250, 320, "Sprites/buttonRedUp.png", "Sprites/buttonRedDown.png", "Red Button"));

    }

}


public class Level_1 extends Level {

    public Level_1(Player player) {
        super(player);
        sizeX = 1000;
        sizeY = 600;
    }

    @Override
    public void init() {
        player.move(20, 330);
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
        entities.add(new BackgroundEntity(50, 50, 950, 300, "Sprites/grassPathStoneTop.png"));
        entities.add(new BackgroundEntity(50, 50, 950, 350, "Sprites/grassPathStoneBottom.png"));
        interactables.add(new ObservationEntity(42, 100, 970, 160, "Sprites/column.png", "A column. I really don't see why it's any different from the other two..."));
        interactables.add(new ObservationEntity(42, 100, 900, 160, "Sprites/column.png", "A column. This way leads inside."));
        interactables.add(new ObservationEntity(42, 100, 830, 160, "Sprites/column.png", "A column. This way leads inside."));
        entities.add(new BackgroundEntity(42, 22, 811, 160-22, "Sprites/TanRoofLeftEdge.png"));
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
        interactables.add(new Item(34, 50, 850, 350, "Sprites/key.png", "Yellow Key", "Look, it's a key! Gee, I wonder what those are used for?"));
        interactables.add(new Door(350, 192, "Sprites/DoorClosed.png", "Sprites/DoorOpen.png", "Yellow Key"));
        interactables.add(new Button(40, 30, 250, 320, "Sprites/buttonRedUp.png", "Sprites/buttonRedDown.png", "Red Button"));

    }

}

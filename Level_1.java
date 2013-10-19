
public class Level_1 extends Level {

    public Level_1(Player player) {
        super(player);
        sizeX = 1000;
        sizeY = 600;
    }

    @Override
    public void init() {
        player.move(20, 350);
        for (int i = 0; i <= 800; i += 42) {
            entities.add(new Wall(42, 42, i,400, "Sprites/grassmap.png"));
        }
        for (int i = 0; i <= 800; i += 20) {
            entities.add(new Wall(i, 600, "Sprites/wall copy.png"));
        }
        for (int i = 0; i <= 800; i += 20) {
            entities.add(new Wall(i, 300, "Sprites/wall copy.png"));
        }
        for (int i = 0; i <= 600; i += 20) {
            entities.add(new Wall(-50, i, "Sprites/wall copy.png"));
        }
        interactables.add(new Door(550, 300, "Sprites/DoorClosed.png", "Sprites/DoorOpen.png"));
        interactables.add(new Door(250, 300, "Sprites/DoorClosed.png", "Sprites/DoorOpen.png"));

    }

}

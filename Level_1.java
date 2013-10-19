
public class Level_1 extends Level {

    public Level_1(Player player) {
        super(player);
        sizeX = 1000;
        sizeY = 600;
    }

    @Override
    public void init() {
        player.move(20, 400);
        for (int i = 0; i <= 800; i += 50) {
            entities.add(new Wall(i, 600, "Sprites/wall.png"));
        }
        for (int i = 0; i <= 800; i += 50) {
            entities.add(new Wall(i, 300, "Sprites/wall.png"));
        }
        for (int i = 0; i <= 600; i += 50) {
            entities.add(new Wall(-50, i, "Sprites/wall.png"));
        }
        interactables.add(new Door(550, 300, "Sprites/DoorClosed.png", "Sprites/DoorOpen.png"));
        interactables.add(new Door(250, 300, "Sprites/DoorClosed.png", "Sprites/DoorOpen.png"));

    }

}

public class Level_3 extends Level {

    public Level_3 (Player player) {
        super(player);
        sizeX = 1500;
        sizeY = 600;
    }

    @Override
    public void init() {
        player.move(30, 330);



        for (int i = 0; i <= 1500; i += 50) {
            entities.add(new Wall(50, 50, i, 400, "Sprites/StoneGround.png"));
        }
        for (int i = 0; i <= 1500; i += 50) {
            for (int k = 0; k <= 350; k += 50) {
                entities.add(new BackgroundEntity(50, 50, i, k, "Sprites/stoneBG.png"));
            }
        }
        for (int i = 0; i <= 300; i += 20) {
            entities.add(new Wall(50, 20, -20, i, "Sprites/stoneWall.png"));
        }
        for (int i = 0; i <= 1500; i += 50) {
            for (int k = 350; k >= 250; k -= 50) {
                entities.add(new BackgroundEntity(50, 50, i, k, "Sprites/stone.png"));
            }
        }
        for (int i = 0; i <= 1500; i += 20) {
            entities.add(new Wall(50, 20, i, 250, "Sprites/stoneWall.png"));
        }
        for (int i = 5; i <= 600; i += 20) {
            entities.add(new Wall(50, 20, -30, i, "Sprites/stoneWall.png"));
        }

        for (int i = 0; i <= 600; i += 20) {
            entities.add(new Wall(50, 20, 1510, i, "Sprites/stoneWall.png"));
        }
    }

}

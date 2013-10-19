
public class Level_2 extends Level {

    private Puzzle_1 puzzle;

    public Level_2 (Player player) {
        super(player);
        sizeX = 1500;
        sizeY = 600;
    }

    @Override
    public void init() {
        player.move(30, 330);
        Lever a = new Lever(44, 33, 540, 300, "Sprites/leverLeft.png", "Sprites/leverRight.png", "Fence-Hopping License");
        Lever b = new Lever(44, 33, 640, 300, "Sprites/leverLeft.png", "Sprites/leverRight.png", "Fence-Hopping License");
        Lever c = new Lever(44, 33, 740, 300, "Sprites/leverLeft.png", "Sprites/leverRight.png", "Fence-Hopping License");
        Lever d = new Lever(44, 33, 840, 300, "Sprites/leverLeft.png", "Sprites/leverRight.png", "Fence-Hopping License");
        puzzle = new Puzzle_1(a, b, c, d);

        interactables.add(a);
        interactables.add(b);
        interactables.add(c);
        interactables.add(d);

        interactables.add(new ObservationEntity(40, 40, 1250, 260, "Sprites/sign.png", "A little advice:\nLosers rarely read letters.\nAnd if you solve puzzles by randomly hittings things,\nthen \"screw you\" too!"));

        interactables.add(new Exit(50, 50, 1450, 300, "Sprites/stone.png", 2, "As you enter the castle, a wave an anxiety washes over you..." +
        		"                                         " +
        		"\nYou really need to pee."));
        interactables.add(new Exit(50, 50, 1450, 350, "Sprites/stone.png", 2, "As you enter the castle, a wave an anxiety washes over you..." +
        		"                                         " +
        		"\nYou really need to pee."));
        for (int i = 0; i <= 1500; i += 50) {
            entities.add(new Wall(50, 50, i, 400, "Sprites/StoneGround.png"));
        }
        for (int i = 0; i <= 1500; i += 50) {
            for (int k = 0; k <= 350; k += 50) {
                entities.add(new BackgroundEntity(50, 50, i, k, "Sprites/sky.png"));
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

        interactables.add(new PuzzleWall(42, 40, 1350, 280, "Sprites/shortFence.png", "Sprites/shortFence.png", "Fence-Hopping License",
                "You could walk over this really short fence, but you feel you owe it to yourself\nto at least solve the puzzle behind you.",
                "Feeling a little silly, letting that short fence stop you, eh?",
                "Feeling confident with your newly prescribed authoritative affirmations,\nyou cross the fence."));
        interactables.add(new PuzzleWall(42, 40, 1350, 325, "Sprites/shortFence.png", "Sprites/shortFence.png", "Fence-Hopping License",
                "You could walk over this really short fence, but you feel you owe it to yourself\nto at least solve the puzzle behind you.",
                "Feeling a little silly, letting that short fence stop you, eh?",
                "Feeling confident with your newly prescribed authoritative affirmations,\nyou cross the fence."));
        interactables.add(new PuzzleWall(42, 40, 1350, 370, "Sprites/shortFence.png", "Sprites/shortFence.png", "Fence-Hopping License",
                "You could walk over this really short fence, but you feel you owe it to yourself\nto at least solve the puzzle behind you.",
                "Feeling a little silly, letting that short fence stop you, eh?",
                "Feeling confident with your newly prescribed authoritative affirmations,\nyou cross the fence."));
    }

    @Override
    public void update(int delta) {
        super.update(delta);
        if (puzzle != null) {
            puzzle.solved();
        }
    }

}

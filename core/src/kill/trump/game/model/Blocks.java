package kill.trump.game.model;

public class Blocks {
    public Block

    brick1 = new Block("brick1") {
        {
            id = 0;
        }
    },
    brick2 = new Block("brick2") {
        {
            id = 1;
        }
    },
    brick3 = new Block("brick3") {
        {
            id = 2;
        }
    },
    brick4 = new Block("brick4") {
        {
            id = 3;
        }
    },
    brick5 = new Block("brick5") {
        {
            id = 4;
        }
    },
    road = new Block("road") {
        {
            id = 5;
        }
    };

    public Block getBlockWithID(int id) {
        switch (id) {
            case 0: return brick1;
            case 1: return brick2;
            case 2: return brick3;
            case 3: return brick4;
            case 4: return brick5;
            case 5: return road;
        }
        return null;
    }
}

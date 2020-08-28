package kill.trump.game.model;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class World {

    public Player player;
    public Block block;
    public Blocks blocks;
    public Transports transports;

    public int width;
    public int height;

    public Array<Block> blocksArray = new Array<>();
    public Array<Transport> transportArray = new Array<>();

    public World() {
        blocks = new Blocks();
        transports = new Transports();

        createWorld();
    }

    public void createWorld() {
        player = new Player(new Vector2(1,1));


        transports.TankRussia.setPosition(new Vector2(1,2));
        transportArray.add(transports.TankRussia);
        player.inTransport = true;
        player.transport = transports.TankRussia;
    }

    public Array<Block> getBlocks() {
        return blocksArray;
    }

    public Array<Transport> getTransports() {
        return transportArray;
    }
}

package kill.trump.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import kill.trump.game.model.Player;
import kill.trump.game.model.Tank;
import kill.trump.game.model.World;

public class WorldController {

    World world;
    Player player;

    public WorldController(World world) {
        this.world = world;
        player = world.player;
    }

    public void update() {
        processInput();
    }

    public void processInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.W)){
            player.velocity.y += player.currentSpeed;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.S)){
            player.velocity.y += -player.currentSpeed;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.A)){
            player.velocity.x += -player.currentSpeed;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D)){
            player.velocity.x += player.currentSpeed;
        }

        if (player.inTransport) {
            player.transport.move(player.velocity);
        }

    }

}

package kill.trump.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.HashMap;

import kill.trump.game.gameui.HealthBar;
import kill.trump.game.gameui.Joystick;
import kill.trump.game.model.Block;
import kill.trump.game.model.Player;
import kill.trump.game.model.Tank;
import kill.trump.game.model.Transport;
import kill.trump.game.model.World;

public class WorldRenderer {

    public final float CAMERA_WIDTH = 60f;
    public final float CAMERA_HEIGHT = 60f;
    public final float SPRITE_SIZE = 32f;

    public World world;
    public GUIHandler guiHandler;

    public OrthographicCamera camera;
    public SpriteBatch spriteBatch;

    public Texture texture;
    public HashMap<String, Texture> textures = new HashMap<>();

    public WorldRenderer(World world) {
        this.world = world;

        camera = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
        spriteBatch = new SpriteBatch();
        guiHandler = new GUIHandler(world);

        loadTextures();
    }

    public void render() {

        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        drawBlock();
        if (!world.player.inTransport) drawPlayer();
        drawTransport();
        spriteBatch.end();

        guiHandler.draw();

        //world.player.health -= 0.1f;
        setCamera(world.player.position.x * textures.get("player").getWidth(), world.player.position.y * textures.get("player").getHeight());
    }

    public void setCamera(float width, float height) {
        camera.position.set(width, height, 0);
        camera.update();
    }

    public void drawPlayer() {
        if (world.player.state == Player.State.NONE) {
            spriteBatch.draw(textures.get("player"), world.player.position.x * SPRITE_SIZE,
                    world.player.position.y * SPRITE_SIZE,
                    world.player.SIZEX * SPRITE_SIZE,
                    world.player.SIZEY * SPRITE_SIZE );
        } else if (world.player.state == Player.State.DEAD) {
            spriteBatch.draw(textures.get("playerDeath"), world.player.position.x * SPRITE_SIZE,
                    world.player.position.y * SPRITE_SIZE,
                    world.player.SIZEX * SPRITE_SIZE,
                    world.player.SIZEY * SPRITE_SIZE );
        }
    }

    public void drawBlock() {
        for (Block block : world.getBlocks()) {
            Texture texture = textures.get(block.name);
            spriteBatch.draw(texture,
                    block.position.x * SPRITE_SIZE,
                    block.position.y  * SPRITE_SIZE,
                    block.SIZEX * SPRITE_SIZE,
                    block.SIZEY * SPRITE_SIZE);
        }
    }

    public void drawTransport() {
        for (Transport transport : world.getTransports()) {
            transport.draw(spriteBatch, new Sprite(textures.get("russia-tank")),
            new Sprite(textures.get("russia-tank-head")), SPRITE_SIZE);
        }
    }

    public void loadTextures() {
        texture = new Texture(Gdx.files.internal("sprite/player.png"));
        textures.put("player", texture);
        texture = new Texture(Gdx.files.internal("sprite/playerDeath.png"));
        textures.put("playerDeath", texture);
        for (int i = 1; i <= 5; i++) {
            texture = new Texture(Gdx.files.internal("sprite/brick" + i + ".png"));
            textures.put("brick" + i, texture);
        }
        texture = new Texture(Gdx.files.internal("sprite/road.png"));
        textures.put("road", texture);
        texture = new Texture(Gdx.files.internal("sprite/russia-tank.png"));
        textures.put("russia-tank", texture);
        texture = new Texture(Gdx.files.internal("sprite/russia-tank-head.png"));
        textures.put("russia-tank-head", texture);

    }

}

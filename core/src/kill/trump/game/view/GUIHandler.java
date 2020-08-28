package kill.trump.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

import kill.trump.game.gameui.HealthBar;
import kill.trump.game.model.World;

public class GUIHandler {

    public final float CAMERA_WIDTH = 60f;
    public final float CAMERA_HEIGHT = 60f;

    public int WIDTH = Gdx.graphics.getWidth()/12;
    public int HEIGHT = Gdx.graphics.getHeight()/12;

    private World world;

    private Stage stage;
    private OrthographicCamera camera;
    private SpriteBatch spriteBatch;

    private HealthBar healthBar;

    public GUIHandler(World world) {
        this.world = world;

        stage = new Stage();
        camera = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
        spriteBatch = new SpriteBatch();

        Texture healthTexture = new Texture(Gdx.files.internal("sprite/health.png"));
        healthBar = new HealthBar(0, world.player.MAX_HEATLH / 12, healthTexture);

        stage.addActor(healthBar);
    }

    public void update() {
        WIDTH = Gdx.graphics.getWidth();
        HEIGHT = Gdx.graphics.getHeight();

        healthBar.setValue((int) world.player.health / 12);
    }

    public void resize(float width, float height) {
        healthBar.setPosition(-width / 2 + 15,(height-healthBar.getHeight()) / 2 - 15);
    }

    public void draw() {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        spriteBatch.end();

        stage.act();
        stage.draw();

        update();
        setCamera(0, 0);
    }

    private void setCamera(float x, float y) {
        camera.position.set(x, y, 0);
        camera.update();
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public Stage getStage() {
        return stage;
    }
}

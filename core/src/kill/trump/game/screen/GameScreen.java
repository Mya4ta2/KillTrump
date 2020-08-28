package kill.trump.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import kill.trump.game.controller.WorldController;
import kill.trump.game.map.MapReader;
import kill.trump.game.model.Player;
import kill.trump.game.model.World;
import kill.trump.game.view.WorldRenderer;

public class GameScreen implements InputProcessor, Screen {

    World world;
    WorldRenderer worldRenderer;
    WorldController worldController;
    Viewport viewport;
    Viewport guiViewport;

    InputMultiplexer multi;

    @Override
    public void show() {
        world = MapReader.getWorldFromFile(Gdx.files.internal("map.rsav"));
        worldRenderer = new WorldRenderer(world);
        worldController = new WorldController(world);
        viewport = new ScreenViewport(worldRenderer.camera);

        guiViewport = new ScreenViewport(worldRenderer.guiHandler.getCamera());
        worldRenderer.guiHandler.getStage().setViewport(guiViewport);

        multi = new InputMultiplexer(worldRenderer.guiHandler.getStage(), this);
        Gdx.input.setInputProcessor(multi);
    }

    @Override
    public void render(float delta) {
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl20.glClearColor(255/255, 255/225, 255/255, 1f);

        worldRenderer.render();
        worldController.update();
        viewport.apply();
        guiViewport.apply();

        if (world.player.state != Player.State.DEAD) {
            worldRenderer.world.player.update(delta);
        }
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        guiViewport.update(width, height);

        worldRenderer.guiHandler.resize(width, height);

        Gdx.input.setInputProcessor(multi);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

}

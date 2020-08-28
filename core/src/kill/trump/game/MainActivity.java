package kill.trump.game;

import com.badlogic.gdx.Game;

import kill.trump.game.screen.GameScreen;

public class MainActivity extends Game {
    @Override
    public void create() {
        GameScreen gameScreen = new GameScreen();
        setScreen(gameScreen);
    }
}

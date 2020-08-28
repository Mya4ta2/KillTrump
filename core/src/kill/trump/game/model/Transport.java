package kill.trump.game.model;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Transport {
    public enum State {
        NONE, BRAKE
    }

    public static float MAX_HEATLH = 100;
    public static float MAX_FUEL = 2000;
    public static float FUEL_CONSUMPTION = 1f;
    public final float SPEED = 10;
    public final float SPRINT_SPEED = 20;

    public String name;
    public Vector2 position = new Vector2();
    public Vector2 velocity = new Vector2();
    public Rectangle bounds = new Rectangle();
    public Player.State state = Player.State.NONE;

    public int SIZEX = 1, SIZEY = 1;
    public float health = MAX_HEATLH;
    public float fuel = MAX_FUEL;
    public float currentSpeed = SPEED;

    public Transport(String name) {
        this.name = name;
        bounds.x = position.x;
        bounds.width = SIZEX;
        bounds.y = position.y;
        bounds.height = SIZEY;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
        this.bounds.x = position.x;
        this.bounds.y = position.y;
    }

    public void update(float delta) {
        position.add(velocity.scl(delta));
        fuel -= FUEL_CONSUMPTION;

        bounds.x = position.x;
        bounds.y = position.y;

        if (health <= 0){
            state = Player.State.DEAD;
        }
    }

    abstract public void draw(SpriteBatch spriteBatch, Sprite body, Sprite head, float SPRITE_SIZE);

    abstract public void move(Vector2 velocity);
}

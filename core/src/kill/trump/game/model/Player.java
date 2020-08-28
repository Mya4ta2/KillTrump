package kill.trump.game.model;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player {

    public enum State {
        NONE, DEAD
    }

    public final float MAX_HEATLH = 100;
    public final float MAX_ENDURANSE = 100;
    public final float SPEED = 10;
    public final float SPRINT_SPEED = 20;

    public Vector2 position = new Vector2();
    public Vector2 velocity = new Vector2();
    public Rectangle bounds = new Rectangle();
    public State state = State.NONE;
    public boolean inTransport;
    public Transport transport;

    public int SIZEX = 1, SIZEY = 1;
    public float health = MAX_HEATLH;
    public float enduranse = MAX_ENDURANSE;
    public float currentSpeed = SPEED;

    public Player(Vector2 position) {
        this.position = position;
        bounds.x = position.x;
        bounds.width = SIZEX;
        bounds.y = position.y;
        bounds.height = SIZEY;
    }

    public void update(float delta) {
        position.add(velocity.scl(delta));

        if (inTransport) {
            transport.setPosition(position);
        }

        bounds.x = position.x;
        bounds.y = position.y;

        if (health <= 0){
            state = State.DEAD;
        }
    }

}

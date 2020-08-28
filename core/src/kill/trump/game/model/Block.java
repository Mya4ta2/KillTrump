package kill.trump.game.model;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Block extends Placeble {

    public int SIZEX = 1;
    public int SIZEY = 1;

    public String name;
    public Vector2 position = new Vector2();
    public Rectangle bounds = new Rectangle();

    public Block(String name) {
        this.name = name;
        this.bounds.height = SIZEY;
        this.bounds.width = SIZEX;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
        this.bounds.x = position.x;
        this.bounds.y = position.y;
    }

}

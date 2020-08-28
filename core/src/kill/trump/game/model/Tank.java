package kill.trump.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Tank extends Transport {

    private float bodyAngle = -90;
    private float headAngle = -90;
    private float maxHeadAngle = 160;

    public void setBodyAngle(float bodyAngle) {
       this.bodyAngle = bodyAngle;
       headAngle = bodyAngle;
    }

    public void addBodyAngle(float angle) {
        this.bodyAngle += angle;
        headAngle = bodyAngle;
    }

    public float getBodyAngle() {
        return bodyAngle;
    }

    public void setHeadAngle(float headAngle) {
        if (!(headAngle >= maxHeadAngle) &&
                !(headAngle <= -maxHeadAngle)) this.headAngle = headAngle;
    }

    public void addHeadAngle(float angle) {
        if (!(headAngle >= maxHeadAngle) &&
                !(headAngle <= -maxHeadAngle)) headAngle += angle;

    }

    public float getHeadAngle() {
        return headAngle;
    }

    public Tank(String name) {
        super(name);
    }

    @Override
    public void draw(SpriteBatch spriteBatch, Sprite body, Sprite head, float SPRITE_SIZE) {
        body.setRotation(bodyAngle);
        body.setPosition(position.x * SPRITE_SIZE, position.y  * SPRITE_SIZE);
        body.setSize(SIZEX * SPRITE_SIZE, SIZEY * SPRITE_SIZE);
        body.draw(spriteBatch);
        head.setRotation(headAngle);
        head.setPosition(position.x * SPRITE_SIZE, position.y  * SPRITE_SIZE);
        head.setSize(SIZEX * SPRITE_SIZE, SIZEY * SPRITE_SIZE);
        head.draw(spriteBatch);
    }

    @Override
    public void move(Vector2 velocity) {
        //position.y += velocity.y + headAngle;
    }
}

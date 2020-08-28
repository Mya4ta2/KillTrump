package kill.trump.game.model;

public class Placeble implements Cloneable {
    int id;

    public int getId() {
        return id;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}

package src.Cabazes;

public abstract class Entity {
    protected static StringBuffer indent = new StringBuffer();
    public abstract void draw();
    public abstract double getWeight();
}

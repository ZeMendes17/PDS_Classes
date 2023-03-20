package src.Pastelaria;

public abstract class CakeBuilderAbstract implements CakeBuilder {
    protected Cake cake = new Cake();

    public Cake getCake() { return cake; };
    public abstract void setCakeShape(Shape s);
    public abstract void addMessage(String message);
    public abstract void addCakeLayer();
    public abstract void createCake();

    
}

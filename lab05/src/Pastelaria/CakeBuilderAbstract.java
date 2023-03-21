package src.Pastelaria;

// abstract builder defining abstract methids for the Cake creation
public abstract class CakeBuilderAbstract implements CakeBuilder {
    protected Cake cake = new Cake();

    public Cake getCake() { return cake; };
    public abstract void setCakeShape(Shape s);
    public abstract void addMessage(String message);
    public abstract void addCakeLayer();
    public abstract void createCake();

    
}

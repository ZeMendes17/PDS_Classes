package src.Pastelaria;

// interface for a CakeBuilder, methods to create the cake defined
public interface CakeBuilder {
    public void setCakeShape(Shape shape);
    public void addCakeLayer();
    public void addCreamLayer();
    public void addTopLayer();
    public void addTopping();
    public Cake getCake();
    public void createCake();
}

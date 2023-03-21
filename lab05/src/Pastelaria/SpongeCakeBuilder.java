package src.Pastelaria;

// Builder designed for sponge Cakes --> methods done to obtain a Chocolate Cake as requested
public class SpongeCakeBuilder extends CakeBuilderAbstract {

    @Override
    public void addCreamLayer() {
        cake.setMidLayerCream(Cream.Red_Berries);
    }

    @Override
    public void addTopLayer() {
        cake.setTopLayerCream(Cream.Whipped_Cream);
    }

    @Override
    public void addTopping() {
        cake.setTopping(Topping.Fruit);
    }

    @Override
    public void setCakeShape(Shape s) {
        cake.setShape(s);
    }

    @Override
    public void addMessage(String message) {
        cake.setMessage(message);
    }

    @Override
    public void addCakeLayer() {
        cake.setCakeLayer("Sponge");
    }

    @Override
    public void createCake() {

    }
    
}

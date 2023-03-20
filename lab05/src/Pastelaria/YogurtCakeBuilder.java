package src.Pastelaria;

public class YogurtCakeBuilder extends CakeBuilderAbstract {
    @Override
    public void addCreamLayer() {
        cake.setMidLayerCream(Cream.Vanilla);
    }

    @Override
    public void addTopLayer() {
        cake.setTopLayerCream(Cream.Red_Berries);
    }

    @Override
    public void addTopping() {
        cake.setTopping(Topping.Chocolate);
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
        cake.setCakeLayer("Yogurt");
    }

    @Override
    public void createCake() {
        cake.toString();
    }
}

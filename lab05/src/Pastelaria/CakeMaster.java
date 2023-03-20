package src.Pastelaria;

public class CakeMaster {
    private CakeBuilderAbstract cakeBuilder;

    public void setCakeBuilder(CakeBuilderAbstract cb) {
        cakeBuilder = cb;
    }

    public void createCake(Shape s, int layers, String message) {
        cakeBuilder.getCake().setNumCakeLayers(layers);
        cakeBuilder.setCakeShape(s);
        cakeBuilder.addMessage(message);
        cakeBuilder.addCakeLayer();
        cakeBuilder.addCreamLayer(); // it has layers
        cakeBuilder.addTopLayer();
        cakeBuilder.addTopping();
        cakeBuilder.createCake();
    }
    public void createCake(int layers, String message) {
        cakeBuilder.getCake().setNumCakeLayers(layers);
        cakeBuilder.setCakeShape(Shape.Circle);
        cakeBuilder.addMessage(message);
        cakeBuilder.addCakeLayer();
        cakeBuilder.addCreamLayer(); // it has layers
        cakeBuilder.addTopLayer();
        cakeBuilder.addTopping();
        cakeBuilder.createCake();
    }
    public void createCake(String message) {
        cakeBuilder.getCake().setNumCakeLayers(1);
        cakeBuilder.setCakeShape(Shape.Circle);
        cakeBuilder.addMessage(message);
        cakeBuilder.addCakeLayer();
        cakeBuilder.addTopLayer();
        cakeBuilder.addTopping();
        cakeBuilder.createCake();
    }

    public Cake getCake() {
        return cakeBuilder.getCake();
    }
}

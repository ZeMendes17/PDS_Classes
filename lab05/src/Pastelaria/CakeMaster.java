package src.Pastelaria;

// this is the Director
public class CakeMaster {
    // define a Builder
    private CakeBuilderAbstract cakeBuilder;

    // setter for the Builder
    public void setCakeBuilder(CakeBuilderAbstract cb) {
        cakeBuilder = cb;
    }

    // diferent creates depending on what is inserted by the user
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

    // gets the cake when ready
    public Cake getCake() {
        return cakeBuilder.getCake();
    }
}

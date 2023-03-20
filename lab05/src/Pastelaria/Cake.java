package src.Pastelaria;

public class Cake {
    private Shape shape;
    private String cakeLayer;
    private int numCakeLayers;
    private Cream midLayerCream;
    private Cream topLayerCream;
    private Topping topping;
    private String message;

    // setters

    public void setShape(Shape shape) { this.shape = shape; }
    public void setCakeLayer(String cakeLayer) { this.cakeLayer = cakeLayer; }
    public void setNumCakeLayers(int numCakeLayers) { this.numCakeLayers = numCakeLayers; }
    public void setMidLayerCream(Cream midLayerCream) { this.midLayerCream = midLayerCream; }
    public void setTopLayerCream(Cream topLayerCream) { this.topLayerCream = topLayerCream; }
    public void setTopping(Topping topping) { this.topping = topping; }
    public void setMessage(String message) { this.message = message; }


    //getters

    public Shape getShape() { return shape; }
    public String getCakeLayer() { return cakeLayer; }
    public int getNumCakeLayers() { return numCakeLayers; }
    public Cream getMidLayerCream() { return midLayerCream; }
    public Cream getTopLayerCream() { return topLayerCream; }
    public Topping getTopping() { return topping; }
    public String getMessage() { return message; }

    @Override
    public String toString(){
        if (numCakeLayers == 1) {
            return cakeLayer + " cake with 1 layers, topped with " + topLayerCream + " cream and " + topping + ". Message says: " + '"' + message + '"' + ".";
        }

        else 
            return  cakeLayer + " cake with " + numCakeLayers + " layers and " + midLayerCream + " cream, topped with " + topLayerCream + " cream and " + topping + ". Message says: " + '"' + message + '"' + ".";
    }

}

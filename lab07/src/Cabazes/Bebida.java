package src.Cabazes;

public class Bebida extends Entity {
    private String name;
    private double weight;

    public Bebida(String name, double value){
        this.name = name;
        this.weight = value;
    }

    @Override
    public void draw() {
        System.out.println(indent.toString() + "Bebida '" + name + "' - Weight : " + weight);
    }

    @Override
    public double getWeight() {
        return weight;
    }
}

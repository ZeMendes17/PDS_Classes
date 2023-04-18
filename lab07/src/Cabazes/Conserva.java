package src.Cabazes;

public class Conserva extends Entity {
    private String name;
    private double weight;

    public Conserva(String name, double value){
        this.name = name;
        this.weight = value;
    }

    @Override
    public void draw() {
        System.out.println(indent.toString() + "Conserva '" + name + "' - Weight: " + weight);
    }

    @Override
    public double getWeight() {
        return weight;
    }
}

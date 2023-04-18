package src.Cabazes;

public class Doce extends Entity {
    private String name;
    private double weight;

    public Doce(String name, int value){
        this.name = name;
        this.weight = value;
    }

    @Override
    public void draw() {
        System.out.println(indent.toString() + "Doce '" + name + "' - Weight : " + weight);
    }

    @Override
    public double getWeight() {
        return weight;
    }
}

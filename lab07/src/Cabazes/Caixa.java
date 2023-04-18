package src.Cabazes;

import java.util.List;
import java.util.ArrayList;

public class Caixa extends Entity {

    private List<Entity> children = new ArrayList<>();
    private String name;
    private double weight;

    public Caixa(String name, double value){
        this.name = name;
        this.weight = value;
    }

    public void add(Entity e){
        children.add(e);
    }

    @Override
    public void draw() {
        System.out.println(indent.toString() + "* Caixa '" + name + "' [Weight: " + weight + " ; Total: " + getWeight() + "]");
        indent.append("   ");


    for (int i = 0; i < children.size(); i++){
        children.get(i).draw();
    }
    indent.setLength(indent.length() - 3);
    }

    @Override
    public double getWeight() {
        double fullWeight = weight;

        for(Entity e : children)
            fullWeight += e.getWeight();
        return fullWeight;
    }
    
}

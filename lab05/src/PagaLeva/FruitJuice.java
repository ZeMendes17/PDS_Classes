package src.PagaLeva;

import java.util.Random;

// class that represents a fruit juice
public class FruitJuice implements Portion {

    State state;
    Temperature temperature;
    Juice FruitName;

    // constructor
    protected FruitJuice() {
        this.state = State.Liquid;
        this.temperature = Temperature.COLD;
        Juice[] fruitJuice = Juice.values();
        this.FruitName = fruitJuice[new Random().nextInt(fruitJuice.length)]; // gets random juice
    }

    // factory method
    
    @Override
    public Temperature getTemperature() {
        return temperature;
    }

    @Override
    public State getState() {
        return state;
    }

    public Juice getFruitName(){
        return FruitName;
    }
    
    @Override
    public String toString(){
        return "FruitJuice: " + FruitName + ", Temperature " + temperature + ", State " + state;
    }

}

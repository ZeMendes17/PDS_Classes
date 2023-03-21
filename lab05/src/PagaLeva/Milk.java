package src.PagaLeva;

// class that represents a milk
public class Milk implements Portion {

    State state;
    Temperature temperature;

    // constructor
    protected Milk() { // only used by the subtypes
        this.state = State.Liquid;
        this.temperature = Temperature.WARM;
    }

    // factory method
    
    @Override
    public State getState() {
        return state;
    }

    @Override
    public Temperature getTemperature() {
        return temperature;
    }
    
    @Override
    public String toString(){
        return "Milk: Temperature " + temperature + ", State " + state;
    }
}


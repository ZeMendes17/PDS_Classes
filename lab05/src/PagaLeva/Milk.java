package src.PagaLeva;

public class Milk implements Portion {

    State state;
    Temperature temperature;

    protected Milk() { // only used by the subtypes
        this.state = State.Liquid;
        this.temperature = Temperature.WARM;
    }

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


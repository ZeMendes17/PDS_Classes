package src.PagaLeva;

// class that represents a tuna portion
public class Tuna implements Portion{
    State state;
    Temperature temperature;

    // constructor
    protected Tuna() {
        this.state = State.Solid;
        this.temperature = Temperature.COLD;
    }
    
    // factory method
    
    @Override
    public  State getState() {
        return state;
    }

    @Override
    public Temperature getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return "Tuna: Temperature " + temperature + ", State " + state;
    }
}
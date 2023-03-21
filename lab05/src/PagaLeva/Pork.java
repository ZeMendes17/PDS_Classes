package src.PagaLeva;

// class that represents a pork
public class Pork implements Portion{
    State state;
    Temperature temperature;

    // constructor
    protected Pork() {
        this.state = State.Solid;
        this.temperature = Temperature.WARM;
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
        return "Pork: Temperature " + temperature + ", State " + state;
    }
}
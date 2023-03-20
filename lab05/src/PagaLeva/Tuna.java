package src.PagaLeva;

public class Tuna implements Portion{
    State state;
    Temperature temperature;

    protected Tuna() {
        this.state = State.Solid;
        this.temperature = Temperature.COLD;
    }
    
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
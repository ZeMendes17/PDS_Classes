package src.PagaLeva;

public class Pork implements Portion{
    State state;
    Temperature temperature;

    protected Pork() {
        this.state = State.Solid;
        this.temperature = Temperature.WARM;
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
        return "Pork: Temperature " + temperature + ", State " + state;
    }
}
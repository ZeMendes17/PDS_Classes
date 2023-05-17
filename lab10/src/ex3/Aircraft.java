package ex3;

public abstract class Aircraft {
    protected AirTrafficController mediator;
    protected String name;

    public Aircraft(AirTrafficController mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void takeOff();
    public abstract void land();
    public abstract void communicate(String message);
    public abstract void receiveCommunication(String message);
}

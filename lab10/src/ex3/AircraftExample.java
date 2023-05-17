package ex3;

public class AircraftExample extends Aircraft {
    public AircraftExample(AirTrafficController mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void takeOff() {
        System.out.println(name + " is taking off from the airport.");
    }

    @Override
    public void land() {
        System.out.println(name + " is requesting to land.");
        mediator.requestToLand(this);
    }

    @Override
    public void communicate(String message) {
        mediator.communicate(message, this);
    }

    @Override
    public void receiveCommunication(String message) {
        System.out.println(name + " received communication: " + message);
    }
}

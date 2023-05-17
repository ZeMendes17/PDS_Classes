package ex3;

public class Teste {
    public static void main(String[] args) {
        AirTrafficController controller = new AirTrafficController();

        Aircraft airplane1 = new AircraftExample(controller, "Airplane 1");
        Aircraft airplane2 = new AircraftExample(controller, "Airplane 2");

        controller.addAircraft(airplane1);
        controller.addAircraft(airplane2);

        airplane1.takeOff();
        airplane2.takeOff();

        airplane1.communicate("Hello, this is Airplane 1.");
        airplane2.communicate("Hi, Airplane 2 here.");

        airplane1.land();
        airplane2.land();
    }
}

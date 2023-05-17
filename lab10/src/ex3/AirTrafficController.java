package ex3;

import java.util.ArrayList;
import java.util.List;

public class AirTrafficController {
    private List<Aircraft> aircrafts;

    public AirTrafficController() {
        this.aircrafts = new ArrayList<>();
    }

    public void addAircraft(Aircraft aircraft) {
        aircrafts.add(aircraft);
    }

    public void requestToLand(Aircraft aircraft) {
        boolean isClearToLand = true;

        // Aqui seriam as condições de aterragem, mas acho que não é preciso ir tao profundo assim.
        // É aqui que dá erro não sei bem porque
        if (isClearToLand) {
            System.out.println(aircraft.name + " has been granted permission to land.");
            aircraft.land();
            isClearToLand = false;
        } else {
            System.out.println(aircraft.name + " has been denied permission to land at the moment.");
            isClearToLand = true;
        }
    }

    public void communicate(String message, Aircraft sender) {
        for (Aircraft aircraft : aircrafts) {
            if (aircraft != sender) {
                aircraft.receiveCommunication(message);
            }
        }
    }
}

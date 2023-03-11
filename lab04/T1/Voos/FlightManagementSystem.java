package Voos;

import java.util.HashMap;

public class FlightManagementSystem {
    HashMap<String,Flight> flightList; // < fly_code, fly >

    public FlightManagementSystem() {
        flightList = new HashMap<>();
    }

    public void addFlight(Flight flight){
        if (flightList.keySet().contains(flight.getFlight_code()) ){
            System.out.println("Flight already exists");
        }else{
            flightList.put(flight.getFlight_code(), flight);
            int countExecutive = flight.getNumberExecutiveSeats() * flight.getNumberExecutiveRows();
            int countTuristic = flight.getNumberTuristicSeats() * flight.getNumberTuristicRows();
            System.out.printf("Flight code %s. Available Seats: %d lugares em classe Executiva; %d lugares em classe Turística.", flight.getFlight_code(),countExecutive, countTuristic);
        }
    }
    private Flight getFlight(String flightCode){
        return flightList.get(flightCode);
    }

    public String makeReservation(String flightCode, String type, int number){
        Flight flight = getFlight(flightCode);
        if (flight == null){
            System.out.print("Flight doesn't exist.");
            return null;
        }
        String reservationCode;

        if (type.equals("T")){
            reservationCode = flight.makeTuristicReservation(number);

        }else if (type.equals("E")){
            reservationCode = flight.makeExecutiveReservation(number);

        }else{
            System.out.print("Class should be T or E.");
            return null;
        }

        return reservationCode;
    }

    public String cancelReservation(String flightCode, int reservationID){
        Flight flight = getFlight(flightCode);
        if (flight == null){
            return "Flight doesn't exist.";
        }
        String cancelationResult = flight.cancelReservation(reservationID);

        return cancelationResult;
    }

    public void printFlight(String flightCode){
        Flight flight = getFlight(flightCode);
        if (flight == null){
            System.out.println("Flight doesnt exist.");
        }
        flight.print();
    }

}

package Voos;

import java.io.File;

public class FlightGenerator {
    String executiveSeats;
    String turisticSeats;
    String flightCode;

    class FlightInfo {
        int numberExecutiveRows;
        int numberExecutiveSeats;
        int numberTuristicRows;
        int numberTuristicSeats;
    }

    public FlightGenerator( String flightCode, String executiveSeats, String turisticSeats) {
        this.executiveSeats = executiveSeats;
        this.turisticSeats = turisticSeats;
        this.flightCode = flightCode;
    }

    public Flight generate(){
        Flight flight;
        FlightInfo flightInfo; 
        flightInfo = parseFlightInfo(executiveSeats, turisticSeats);
        flight = createFlight(flightCode, flightInfo);
        return flight;
    }
    
    private FlightInfo parseFlightInfo(String executiveSeats,String turisticSeats){
        FlightInfo flightInfo = new FlightInfo();
        String[] executiveInfo = new String[2];
        String[] turisticInfo = new String[2];;

        if (executiveSeats != null){
            executiveInfo  = executiveSeats.split("x");
        }
        turisticInfo  = turisticSeats.split("x");
        if (executiveSeats != null){
            flightInfo.numberExecutiveRows = Integer.parseInt(executiveInfo[0]);
            flightInfo.numberExecutiveSeats = Integer.parseInt(executiveInfo[1]);
            flightInfo.numberTuristicRows = Integer.parseInt(turisticInfo[0]);
            flightInfo.numberTuristicSeats = Integer.parseInt(turisticInfo[1]);
        }else{
            flightInfo.numberExecutiveRows = 0;
            flightInfo.numberExecutiveSeats = 0;
            flightInfo.numberTuristicRows = Integer.parseInt(turisticInfo[0]);
            flightInfo.numberTuristicSeats = Integer.parseInt(turisticInfo[1]);
        }
        return flightInfo;
    }

    private Flight createFlight(String flightCode ,FlightInfo flightInfo){
        return new Flight(flightCode, flightInfo.numberExecutiveRows, flightInfo.numberExecutiveSeats, flightInfo.numberTuristicRows, flightInfo.numberTuristicSeats);
    }
    
}

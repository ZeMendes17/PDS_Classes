package src.Voos;

import java.util.List;

public class DisplaySeats {
    List<String> flight;

    // constructor
    public DisplaySeats(List<String> flight){
        this.flight = flight;
    }

    // getter
    public List<String> getFlight(){
        return flight;
    }
    // setter
    public void setFlight(List<String> flight){
        this.flight = flight;
    }

    public void display(){
        int tourist_row = Integer.parseInt(flight.get(0).split("x")[0]);
        int tourist_col = Integer.parseInt(flight.get(0).split("x")[1]);
        Integer[][] tourist_seats = new Integer[tourist_row][tourist_col];

        try {
            int executive_row = Integer.parseInt(flight.get(1).split("x")[0]);
            int executive_col = Integer.parseInt(flight.get(1).split("x")[1]);
            Integer[][] executive_seats = new Integer[executive_row][executive_col];


        } catch (NumberFormatException e) {
            int col = 0;
            int row;
            for(int i = 1; i < flight.size(); i++){
                if(flight.get(i).split(" ")[0].equals("T")){
                    int passengers = Integer.parseInt(flight.get(i).split(" ")[1]);
                    int count_pass = 0;
                    while(true){
                        if(count_pass >= passengers)
                            break;

                        for(row = 0; row < tourist_col; row++){
                            if(tourist_seats[row][col] == null){
                                tourist_seats[row][col] = i;
                            }
                        }
                    }
                }
            }
        }
    }
}

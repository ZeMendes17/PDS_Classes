package src.Voos;

import java.util.ArrayList;
import java.util.List;

public class Seats {
    List<String> flight;
    List<String> seats;
    List<String> new_seats;

    //constructor
    public Seats(List<String> flight){
        this.flight = flight;
        seats = new ArrayList<>();
    }

    // getter
    public List<String> getFlight(){
        return flight;
    }
    // setter
    public void setFlight(List<String> flight){
        this.flight = flight;
    }

    // method to reserve seats
    public void getPlane(int disp){
        // get number of seats in tourist class and executive class and create matrixes with that size to represent the plane seats
        int tourist_col = Integer.parseInt(flight.get(0).split("x")[0]);
        int tourist_row = Integer.parseInt(flight.get(0).split("x")[1]);

        // make matrix with tourist seats
        Integer[][] tourist_seats = new Integer[tourist_row][tourist_col];
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        try {
            // if there is executive class seats in the flight file, make matrix with executive seats
            int executive_col = Integer.parseInt(flight.get(1).split("x")[0]);
            int executive_row = Integer.parseInt(flight.get(1).split("x")[1]);

            // matrix with executive seats
            Integer[][] executive_seats = new Integer[executive_row][executive_col];

            // separate the seats of the plane into the executive and the tourists seats
            Integer[][] plane_executive = executive_seats;
            Integer[][] plane_tourist = tourist_seats;

            int count = 1;

            // reserve seats for each passenger
            for(int i = 2; i < flight.size(); i++){

                // if passenger is in tourist class
                if(flight.get(i).split(" ")[0].equals("T")){

                    // reserve a seat in the tourist class
                    plane_tourist = reserveSeat(flight.get(i), tourist_seats, count, executive_col);
                    count++;
                
                // if passenger is in executive class
                } else if(flight.get(i).split(" ")[0].equals("E")) {

                    // reserve a seat in the executive class
                    plane_executive = reserveSeat(flight.get(i), executive_seats, count, 0);
                    count++;
                }
            }

            // create a matrix with all seats
            Integer[][] all_seats;

            // if there are more rows in the tourist class
            if(tourist_row > executive_row){

                // create a matrix with the size of the tourist class rows and the sum of the tourist and executive class columns
                all_seats = new Integer[tourist_row][tourist_col+executive_col];

                // puts executive seats in the matrix with all seats
                for(int i = 0; i < plane_executive.length; i++){
                    for(int j = 0; j < plane_executive[0].length; j++){
                        all_seats[i][j] = plane_executive[i][j];
                    }
                }

                // seats that do not exist are represented by -1 in the matrix with all seats
                for(int i = executive_row; i < tourist_row; i++){
                    for(int j = 0; j < plane_executive[0].length; j++){
                        all_seats[i][j] = -1;
                    }
                }

                // puts tourist seats in the matrix with all seats
                for(int i = 0; i < plane_tourist.length; i++){
                    for(int j = plane_executive[0].length; j < all_seats[0].length; j++){
                        all_seats[i][j] = plane_tourist[i][j-plane_executive[0].length];
                    }
                }

            // if there are more rows in the executive class
            } else {

                // create a matrix with the size of the executive class rows and the sum of the tourist and executive class columns
                all_seats = new Integer[executive_row][tourist_col+executive_col];

                // puts executive seats in the matrix with all seats
                for(int i = 0; i < plane_executive.length; i++){
                    for(int j = 0; j < plane_executive[0].length; j++){
                        all_seats[i][j] = plane_executive[i][j];
                    }
                }

                // puts tourist seats in the matrix with all seats
                for(int i = 0; i < plane_tourist.length; i++){
                    for(int j = plane_executive[0].length; j < all_seats[0].length; j++){
                        all_seats[i][j] = plane_tourist[i][j];
                    }
                }

                // seats that do not exist are represented by -1 in the matrix with all seats
                for(int i = tourist_row; i < executive_row; i++){
                    for(int j = 0; j < plane_tourist[0].length; j++){
                        all_seats[i][j] = -1;
                    }
                }
            }

            // create a matrix with the size of the matrix with all seats plus one row and one column to represent the plane
            String[][] result = new String[all_seats.length+1][all_seats[0].length+1];

            // puts letters of seat in the first column of the matrix representing the plane
            for(int i = 1; i < result.length; i++){
                result[i][0] = Character.toString(alpha.charAt(i-1));
            }

            // puts number of seat in the first row of the matrix representing the plane
            for(int i = 1; i < result[0].length; i++){
                result[0][i] = Integer.toString(i);
            }

            // puts clients in the matrix representing the plane
            for(int i = 1; i < result.length; i++){

                for(int j = 1; j < result[0].length; j++){

                    // if there is no seat in that position, put 0
                    if(all_seats[i-1][j-1] == null)
                        result[i][j] = "0";

                    // if there is a seat that does not exist in that position, put ""
                    else if(all_seats[i-1][j-1] == -1)
                        result[i][j] = "";
                    
                    // if there is a seat in that position, put the number of the client
                    else
                        result[i][j] = Integer.toString(all_seats[i-1][j-1]);
                }
            }
            if(disp != 0){
                print(result);
            }

        // if there is no executive class
        } catch (NumberFormatException e) {

            // plane will only have tourist seats
            Integer[][] plane = tourist_seats;

            // reserve seats for each passenger
            for(int i = 1; i < flight.size(); i++){
                if(!flight.get(i).split(" ")[0].equals("T"))
                    continue;

                plane = reserveSeat(flight.get(i), tourist_seats, i, 0);

            }

            // create a matrix with the size of the matrix with all seats plus one row and one column to represent the plane
            String[][] result = new String[tourist_row+1][tourist_col+1];

            // puts letters of seat in the first column of the matrix representing the plane
            for(int i = 1; i < tourist_row+1; i++){
                result[i][0] = Character.toString(alpha.charAt(i-1));
            }

            // puts number of seat in the first row of the matrix representing the plane
            for(int i = 1; i < tourist_col+1; i++){
                result[0][i] = Integer.toString(i);
            }

            // puts clients in the matrix representing the plane
            for(int i = 1; i < tourist_row+1; i++){
                for(int j = 1; j < tourist_col+1; j++){
                    if(plane[i-1][j-1] == null)
                        result[i][j] = "0";
                    else
                        result[i][j] = Integer.toString(plane[i-1][j-1]);
                }
            }
            // displays
            if(disp != 0){
                print(result);
            }
        }
    }
    
    // funtion used to select the seats for the passangers and reserving them in the plane
    public Integer[][] reserveSeat(String passangers, Integer plane[][], int passangers_id, int inicial){

        // String type = passangers.split(" ")[0];
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int number_of_pasengers = Integer.parseInt(passangers.split(" ")[1]);

        // dimensions of the plane
        int width = plane.length;
        int length = plane[0].length;

        int[] plane_row = new int[length]; // number of free seats in each row
        List<Integer> free_cols = new ArrayList<>(); // stores free cols
        int total;
        int totalTotal = 0;

        int p = number_of_pasengers;

        // flags to control the loop and the insertion of the seats
        boolean insert_flag = false;
        boolean free_flag = false;

        // list to store the new seats reserved
        new_seats = new ArrayList<>();

        // while there are still passengers to be seated
        while(number_of_pasengers > 0){

            for(int i = 0; i < length; i++){
                total = 0;
                for(int j = 0; j < width; j++){
                    if(plane[j][i] == null)
                        total++;
                }

                // stores the number of free seats in each column
                plane_row[i] = total;
                if(total == width)
                    free_cols.add(i); // fills the list with free cols

                // stores the total number of free seats
                totalTotal += total;
            }

            // if there are no more free seats
            if(totalTotal < number_of_pasengers){
                return null;
            }

            int index = 0;
            // checks if there are enough free seats in each row
            for(int places : plane_row){
                if(p <= places){

                    // if there are any free cols and there are enough free seats in the row of the free col 
                    if(!free_cols.isEmpty()){

                        // set flag to true
                        insert_flag = true;
                        free_flag = true;

                        // removes the number of passengers that can seat from the total number of passengers to be seated
                        number_of_pasengers -= p;
                        break;
                    }

                    insert_flag = true;
                    number_of_pasengers -= p;
                    break;
                }
                index++;
            }
            
            if(insert_flag == true){

                // inserts the seats in the free cols if there are any free cols
                if(free_flag == true){ // if there are any free cols
                    free_flag = false;
                    index = free_cols.get(0);
                    free_cols.remove(0);
                }

                // inserts the seats in the plane
                int count = 0;
                for(int row = 0; row < width; row++){
                    if(plane[row][index] == null && count <  p){
                        plane[row][index] = passangers_id;
                        StringBuffer sb = new StringBuffer();
                        sb.append(index+inicial+1);
                        sb.append(alpha.charAt(row));
                        seats.add(sb.toString());
                        new_seats.add(sb.toString());
                        count++;
                    }
                }
                p = number_of_pasengers;
                insert_flag = false;
            } else {
                p--;
            }
        }
        // for(String s : result)
        //     System.out.println(s);
        return plane;
    }

    // function used to display the plane
    private void print(String[][] result){
        // displays
        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < result[0].length; j++){
                if(result[i][j] == null)
                    System.out.printf("%-2s ", " ");
                else
                    System.out.printf("%-2s ", result[i][j]);
            }
            System.out.println();
        }
    }
}

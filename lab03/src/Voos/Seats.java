package src.Voos;

import java.util.ArrayList;
import java.util.List;

public class Seats {
    List<String> flight;
    List<String> seats;

    // constructor
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

    public void display(){
        int tourist_col = Integer.parseInt(flight.get(0).split("x")[0]);
        int tourist_row = Integer.parseInt(flight.get(0).split("x")[1]);
        Integer[][] tourist_seats = new Integer[tourist_row][tourist_col];
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        try {
            int executive_col = Integer.parseInt(flight.get(1).split("x")[0]);
            int executive_row = Integer.parseInt(flight.get(1).split("x")[1]);
            Integer[][] executive_seats = new Integer[executive_row][executive_col];
            Integer[][] plane_executive = executive_seats;
            Integer[][] plane_tourist = tourist_seats;

            int count = 1;
            for(int i = 2; i < flight.size(); i++){
                if(flight.get(i).split(" ")[0].equals("T")){
                    plane_tourist = reserveSeat(flight.get(i), tourist_seats, count, executive_col);
                    count++;
                } else if(flight.get(i).split(" ")[0].equals("E")) {
                    plane_executive = reserveSeat(flight.get(i), executive_seats, count, 0);
                    count++;
                }
            }

            Integer[][] all_seats;
            if(tourist_row > executive_row){
                all_seats = new Integer[tourist_row][tourist_col+executive_col];
                // puts executive seats
                for(int i = 0; i < plane_executive.length; i++){
                    for(int j = 0; j < plane_executive[0].length; j++){
                        all_seats[i][j] = plane_executive[i][j];
                    }
                }
                // seats that do not exist are represented by -1
                for(int i = executive_row; i < tourist_row; i++){
                    for(int j = 0; j < plane_executive[0].length; j++){
                        all_seats[i][j] = -1;
                    }
                }

                // puts tourist seats
                for(int i = 0; i < plane_tourist.length; i++){
                    for(int j = plane_executive[0].length; j < all_seats[0].length; j++){
                        all_seats[i][j] = plane_tourist[i][j-plane_executive[0].length];
                    }
                }

            } else {
                all_seats = new Integer[executive_row][tourist_col+executive_col];
                // puts executive seats
                for(int i = 0; i < plane_executive.length; i++){
                    for(int j = 0; j < plane_executive[0].length; j++){
                        all_seats[i][j] = plane_executive[i][j];
                    }
                }
                // puts tourist seats
                for(int i = 0; i < plane_tourist.length; i++){
                    for(int j = plane_executive[0].length; j < all_seats[0].length; j++){
                        all_seats[i][j] = plane_tourist[i][j];
                    }
                }

                // seats that do not exist are represented by -1
                for(int i = tourist_row; i < executive_row; i++){
                    for(int j = 0; j < plane_tourist[0].length; j++){
                        all_seats[i][j] = -1;
                    }
                }
            }
            String[][] result = new String[all_seats.length+1][all_seats[0].length+1];
            // puts letters
            for(int i = 1; i < result.length; i++){
                result[i][0] = Character.toString(alpha.charAt(i-1));
            }
            // puts number of seat
            for(int i = 1; i < result[0].length; i++){
                result[0][i] = Integer.toString(i);
            }

            // puts clients
            for(int i = 1; i < result.length; i++){
                for(int j = 1; j < result[0].length; j++){
                    if(all_seats[i-1][j-1] == null)
                        result[i][j] = "0";
                    else if(all_seats[i-1][j-1] == -1)
                        result[i][j] = "";
                    else
                        result[i][j] = Integer.toString(all_seats[i-1][j-1]);
                }
            }
            print(result);

        } catch (NumberFormatException e) {
            Integer[][] plane = tourist_seats;
            for(int i = 1; i < flight.size(); i++){
                if(!flight.get(i).split(" ")[0].equals("T"))
                    continue;

                plane = reserveSeat(flight.get(i), tourist_seats, i, 0);

            }
            String[][] result = new String[tourist_row+1][tourist_col+1];
            // puts letters
            for(int i = 1; i < tourist_row+1; i++){
                result[i][0] = Character.toString(alpha.charAt(i-1));
            }
            // puts number of seat
            for(int i = 1; i < tourist_col+1; i++){
                result[0][i] = Integer.toString(i);
            }
            // puts clients
            for(int i = 1; i < tourist_row+1; i++){
                for(int j = 1; j < tourist_col+1; j++){
                    if(plane[i-1][j-1] == null)
                        result[i][j] = "0";
                    else
                        result[i][j] = Integer.toString(plane[i-1][j-1]);
                }
            }
            // displays
            print(result);
        }
    }
    
    // funtion used to select the seats for the passangers and reserving them
    public Integer[][] reserveSeat(String passangers, Integer plane[][], int passangers_id, int inicial){
        // String type = passangers.split(" ")[0];
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int number_of_pasengers = Integer.parseInt(passangers.split(" ")[1]);
        int width = plane.length;
        int length = plane[0].length;

        int[] plane_row = new int[length]; // numero de lugares livres
        List<Integer> free_cols = new ArrayList<>(); // stores free cols
        int total;
        int totalTotal = 0;

        int p = number_of_pasengers;
        boolean insert_flag = false;
        boolean free_flag = false;
        while(number_of_pasengers > 0){
            for(int i = 0; i < length; i++){
                total = 0;
                for(int j = 0; j < width; j++){
                    if(plane[j][i] == null)
                        total++;
                }
                plane_row[i] = total;
                if(total == width)
                    free_cols.add(i); // fills the list with free cols
                totalTotal += total;
            }
            if(totalTotal < number_of_pasengers){
                return null;
            }

            int index = 0;
            for(int places : plane_row){
                if(p <= places){
                    if(!free_cols.isEmpty()){
                        insert_flag = true;
                        free_flag = true;
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
                // inserts
                if(free_flag == true){ // if there are any free cols
                    free_flag = false;
                    index = free_cols.get(0);
                    free_cols.remove(0);
                }

                int count = 0;
                for(int row = 0; row < width; row++){
                    if(plane[row][index] == null && count <  p){
                        plane[row][index] = passangers_id;
                        StringBuffer sb = new StringBuffer();
                        sb.append(index+inicial+1);
                        sb.append(alpha.charAt(row));
                        seats.add(sb.toString());
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

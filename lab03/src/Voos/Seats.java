package src.Voos;

import java.util.ArrayList;
import java.util.List;

public class Seats {
    List<String> flight;
    List<String> result;

    // constructor
    public Seats(List<String> flight){
        this.flight = flight;
        result = new ArrayList<>();
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
            int executive_row = Integer.parseInt(flight.get(1).split("x")[0]);
            int executive_col = Integer.parseInt(flight.get(1).split("x")[1]);
            Integer[][] executive_seats = new Integer[executive_row][executive_col];


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

    public Integer[][] reserveSeat(String passangers, Integer plane[][], int passangers_id, int inicial){
        // String type = passangers.split(" ")[0];
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int number_of_pasengers = Integer.parseInt(passangers.split(" ")[1]);
        int width = plane.length;
        int length = plane[0].length;

        int[] plane_row = new int[length]; // numero de lugares livres
        int total;
        int totalTotal = 0;

        int p = number_of_pasengers;
        boolean insert_flag = false;
        while(number_of_pasengers > 0){
            for(int i = 0; i < length; i++){
                total = 0;
                for(int j = 0; j < width; j++){
                    if(plane[j][i] == null)
                        total++;
                }
                plane_row[i] = total;
                totalTotal += total;
            }
            if(totalTotal < number_of_pasengers){
                return null;
            }

            int index = 0;
            for(int places : plane_row){
                if(p <= places){
                    insert_flag = true;
                    number_of_pasengers -= p;
                    break;
                }
                index++;
            }
            
            if(insert_flag == true){
                // inserts
                int count = 0;
                for(int row = 0; row < width; row++){
                    if(plane[row][index] == null && count <  p){
                        plane[row][index] = passangers_id;
                        StringBuffer sb = new StringBuffer();
                        sb.append(index+1);
                        sb.append(alpha.charAt(inicial+row));
                        result.add(sb.toString());
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
}

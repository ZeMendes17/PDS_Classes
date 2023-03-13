package src.Voos;

import java.util.Scanner;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class Voos {
    public static void main(String[] args) {
        // implement options
        Scanner in = new Scanner(System.in);
        String input, option, file;
        int terminate;
        // stores flight and its info
        Map<String, List<String>> map = new HashMap<>();

        while(true){
            // variables used through the options
            terminate = 0;
            System.out.println("Escolha uma opção: (H para ajuda)");
            input = in.nextLine();
            option = input.split(" ")[0]; 

            // sees which option was used
            switch(option){
                // Help option
                case "H":
                    System.out.println(helpMessage());
                    break;

                // Option used to get flight information
                // as seats available and those who cannot be put
                case "I":
                    try {
                        // gets file info started
                        file = input.split(" ")[1];
                        FileInfo f_info = new FileInfo(file);
                        // which is also used to print it
                        List<String> flight = f_info.readFile();
                        // gets the flight code 
                        String flight_name = flight.get(0);
                        flight.remove(0);
                        // puts it in the map with the rest of information
                        map.put(flight_name, flight);
                        break;
                    // if user made a mistake inputing
                    } catch (IndexOutOfBoundsException e) {
                        System.err.println("Wrong arguments\n");
                        System.out.println(helpMessage());
                    }

                // option used to print out the planes seats
                // showing which are occupied
                case "M":
                    if(input.length() <= 2){
                        System.err.println("Wrong arguments\n");
                        System.out.println(helpMessage());
                    }

                    String name = input.split(" ")[1];
                    // if the code does not exist
                    if(map.get(name) == null)
                        System.err.println("No such flight was found");
                    else{
                        // Seat is used to put the passangers and map out the plane
                        Seats plane = new Seats(map.get(name));
                        // 1 to print out
                        plane.getPlane(1);
                    }

                    break;
                
                // option used to store the input flight
                case "F":
                    try {
                        // store the input infp into the main map
                        String flight_code = input.split(" ")[1];
                        List<String> rest = new ArrayList<>();
                        if(map.get(flight_code) != null){
                            System.err.println("Flight already created");
                            break;
                        }
                        // if it has executive
                        if(input.split(" ").length == 4){ 
                            if(input.split(" ")[2].contains("x") && input.split(" ")[3].contains("x")){
                                rest.add(input.split(" ")[2]);
                                rest.add(input.split(" ")[3]);
                                map.put(flight_code, rest);
                            } else {
                                System.err.println("Wrong arguments\n");
                                System.out.println(helpMessage());
                            }
                        // if it does not have executive (it is optional)
                        } else if (input.split(" ").length == 3){ 
                            if(input.split(" ")[2].contains("x")){
                                rest.add(input.split(" ")[2]);
                                map.put(flight_code, rest);
                            } else {
                                System.err.println("Wrong arguments\n");
                                System.out.println(helpMessage());
                            }
                        } else {
                            System.err.println("Something went wrong. Please input the correct number of argumants");
                        }
                        System.out.println("New flight was created");

                    // something went wrong with the info put
                    } catch (Exception e) {
                        System.err.println("Wrong arguments\n");
                        System.out.println(helpMessage());
                    }
                    break;

                // option used to reserve seats
                case "R":
                    try {
                        // if the user does not input the correct number of args
                        if(input.split(" ").length != 4){
                            System.err.println("Wrong arguments\n");
                            System.out.println(helpMessage());
                            break;
                        }
                        // reads the input and gets the Type and Num of seats to put
                        String flight_code = input.split(" ")[1];
                        String fclass = input.split(" ")[2];
                        int number_of_seats = Integer.parseInt(input.split(" ")[3]);
                        StringBuilder sb = new StringBuilder();
                        sb.append(fclass);
                        sb.append(" ");
                        sb.append(number_of_seats);
                        // if the indicated flight does not exist
                        if(map.get(flight_code) == null){
                            System.err.println("Wrong arguments\n");
                            System.out.println(helpMessage());
                            return;
                        }
                        // else it adds it to the main map
                        List<String> temp = map.get(flight_code);
                        temp.add(sb.toString());
                        map.put(flight_code, temp);

                        int count = 0;
                        // it is used to count which number of the reservation it is
                        for(String string : map.get(flight_code)){
                            if(string.split(" ")[0].equals("T") || string.split(" ")[0].equals("E"))
                                count++;
                        }

                        Seats s = new Seats(temp);
                        // gets plane info but does not display --> 0
                        s.getPlane(0);
                        if(s.new_seats.isEmpty()){
                            System.err.println("Cannot add the reservation");
                            return;
                        }
                        // prints as reequested
                        System.out.print(flight_code+":"+count + " = ");
                        for(int i = 0; i < s.new_seats.size(); i++){
                            if(i >= s.new_seats.size()-1)
                                System.out.print(" " + s.new_seats.get(i));
                            else
                                System.out.print(" " + s.new_seats.get(i) + " |");
                        }
                        System.out.println();

                    // something went wrong
                    } catch (Exception e) {
                        System.err.println("Wrong arguments\n");
                        System.out.println(helpMessage());
                    }
                    break;

                // option used to cancel a reservation
                case "C":
                    try {
                        String flight_code = input.split(" ")[1].split(":")[0];
                        for(String s : map.get(flight_code))
                            System.out.println(s);
                        int reservation_code = Integer.parseInt(input.split(" ")[1].split(":")[1]);
                        if(map.get(flight_code).get(2).contains("x")){ // means that this flight has executive seats
                            map.get(flight_code).remove(2 + reservation_code);
                        }
                        else{
                            map.get(flight_code).remove(1 + reservation_code);
                        }
                        System.out.println("Successful cancelation. Reservation number: " + reservation_code + " was removed from flight " + flight_code);

                    } catch (IndexOutOfBoundsException | NumberFormatException e) {
                        System.err.println("Wrong arguments\n");
                        System.out.println(helpMessage());
                    }
                    break;

                // quits the program
                case "Q":
                    terminate = 1;
                    break;

                // some other option was inserted
                default:
                    System.err.println("Invalid option");
            }
            // used to end the program
            if(terminate == 1)
                break;
        }
        in.close();

    }

    // help message displayed
    private static String helpMessage(){
        return "Valid Options:\n"+
               "H -> option menu\n"+
               "I filename -> Reads the file to get the flight information\n"+
               "M flight_code -> Shows the map of reserved seats\n"+
               "F flight_code num_seats_executive num_seats_tourist -> New flight with determined code and seats\n"+
               "R flight_code class number_seats -> New flight reservation\n"+
               "C flight_code:reservation_code -> cancels a reservation\n"+
               "Q -> terminates the program";
    }
}

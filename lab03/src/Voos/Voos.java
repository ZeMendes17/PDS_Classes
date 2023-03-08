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
            terminate = 0;
            System.out.println("Escolha uma opção: (H para ajuda)");
            input = in.nextLine();
            option = input.split(" ")[0]; // first

            switch(option){
                case "H":
                    System.out.println(helpMessage());
                    break;

                case "I":
                    try {
                        file = input.split(" ")[1];
                        FileInfo f_info = new FileInfo(file);
                        List<String> flight = f_info.readFile();
                        String flight_name = flight.get(0);
                        flight.remove(0);
                        map.put(flight_name, flight);
                        break;
                    } catch (IndexOutOfBoundsException e) {
                        System.err.println("Wrong arguments\n");
                        System.out.println(helpMessage());
                    }

                case "M":
                    try {
                        String name = input.split(" ")[1];
                        if(map.get(name) == null)
                            System.err.println("No such flight was found");
                        else{
                            Seats plane = new Seats(map.get(name));
                            plane.getPlane(1);
                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.err.println("Wrong arguments\n");
                        System.out.println(helpMessage());
                    }
                    break;
                
                case "F":
                    try {
                        String flight_code = input.split(" ")[1];
                        List<String> rest = new ArrayList<>();
                        if(input.split(" ").length == 4){ // executive
                            if(input.split(" ")[2].contains("x") && input.split(" ")[3].contains("x")){
                                rest.add(input.split(" ")[2]);
                                rest.add(input.split(" ")[3]);
                                map.put(flight_code, rest);
                            } else {
                                System.err.println("Wrong arguments\n");
                                System.out.println(helpMessage());
                            }
                        } else if (input.split(" ").length == 3){ // no executive
                            if(input.split(" ")[2].contains("x")){
                                rest.add(input.split(" ")[2]);
                                map.put(flight_code, rest);
                            } else {
                                System.err.println("Wrong arguments\n");
                                System.out.println(helpMessage());
                            }
                        }
                    } catch (Exception e) {
                        System.err.println("Wrong arguments\n");
                        System.out.println(helpMessage());
                    }
                    break;

                case "R":
                    try {
                        if(input.split(" ").length != 4){
                            System.err.println("Wrong arguments\n");
                            System.out.println(helpMessage());
                            return;
                        }
                        String flight_code = input.split(" ")[1];
                        String fclass = input.split(" ")[2];
                        int number_of_seats = Integer.parseInt(input.split(" ")[3]);
                        StringBuilder sb = new StringBuilder();
                        sb.append(fclass);
                        sb.append(" ");
                        sb.append(number_of_seats);
                        if(map.get(flight_code) == null){
                            System.err.println("Wrong arguments\n");
                            System.out.println(helpMessage());
                            return;
                        }
                        List<String> temp = map.get(flight_code);
                        temp.add(sb.toString());
                        map.put(flight_code, temp);

                        int count = 0;
                        for(String string : map.get(flight_code)){
                            if(string.split(" ")[0].equals("T") || string.split(" ")[0].equals("E"))
                                count++;
                        }

                        Seats s = new Seats(temp);
                        s.getPlane(0);
                        if(s.new_seats.isEmpty()){
                            System.err.println("Cannot add the reservation");
                            return;
                        }
                        // prints
                        System.out.print(flight_code+":"+count + " = ");
                        for(int i = 0; i < s.new_seats.size(); i++){
                            if(i >= s.new_seats.size()-1)
                                System.out.print(" " + s.new_seats.get(i));
                            else
                                System.out.print(" " + s.new_seats.get(i) + " |");
                        }
                        System.out.println();

                    } catch (Exception e) {
                        System.err.println("Wrong arguments\n");
                        System.out.println(helpMessage());
                    }
                    break;

                case "C":
                    try {
                        if(map.get(input.split(" ")[1]) != null)
                            map.remove(input.split(" ")[1]);
                        else
                            System.out.println("Flight not found");
                    } catch (Exception e) {
                        System.err.println("Wrong arguments\n");
                        System.out.println(helpMessage());
                    }
                    break;

                case "Q":
                    terminate = 1;
                    break;

                default:
                    System.err.println("Invalid option");
            }
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
               "M flight_code -> Shows the map of reserved seats"+
               "F flight_code num_seats_executive num_seats_tourist -> New flight with determined code and seats\n"+
               "R flight_code class number_seats -> New flight reservation\n"+
               "C reservation_code -> cancels the flight\n"+
               "Q -> terminates the program";
    }
}

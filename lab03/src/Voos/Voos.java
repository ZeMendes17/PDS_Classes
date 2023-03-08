package src.Voos;

import java.util.Scanner;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Voos {
    public static void main(String[] args) {
        // implement options
        Scanner in = new Scanner(System.in);
        String input, option, file;
        int terminate;
        int sequential_reservation_number = 0;
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
                    file = input.split(" ")[1];
                    FileInfo f_info = new FileInfo(file);
                    List<String> flight = f_info.readFile();
                    String flight_name = flight.get(0);
                    flight.remove(0);
                    map.put(flight_name, flight);
                    break;

                case "M":
                    String name = input.split(" ")[1];
                    if(map.get(name) == null)
                        System.err.println("No such flight was found");
                    else{
                        Seats plane = new Seats(map.get(name));
                        plane.display();
                        for(String s : plane.seats) // remove
                            System.out.println(s);
                    }
                    break;
                
                case "F":
                
                    break;

                case "R":
                    String flight_code = input.split(" ")[1];
                    String class = input.split(" ")[2];
                    int number_seats = Integer.parseInt(input.split(" ")[3]);
                    if(map.containsKey(flight_code)){
                        List<String> flight_info = map.get(flight_code);
                        int num_executive = Integer.parseInt(flight_info.get(0));
                        int num_tourist = Integer.parseInt(flight_info.get(1));
                        if(class.equals("E")){
                            if(num_executive >= number_seats){
                                num_executive -= number_seats;
                                flight_info.set(0, Integer.toString(num_executive));
                                flight_info.add("E" + number_seats);
                                map.put(flight_code, flight_info);
                                sequential_reservation_number++;
                            }
                            else{
                                System.err.println("Not enough seats");
                            }
                        }
                        else if(class.equals("T")){
                            if(num_tourist >= number_seats){
                                num_tourist -= number_seats;
                                flight_info.set(1, Integer.toString(num_tourist));
                                flight_info.add("T" + number_seats);
                                map.put(flight_code, flight_info);
                                sequential_reservation_number++;
                            }
                            else{
                                System.err.println("Not enough seats");
                            }
                        }
                        else{
                            System.err.println("Invalid class");
                        }
                    }
                    else{
                        System.err.println("Flight does not exist");
                    }
                    break;

                case "C":
                    if(map.get(input.split(" ")[1]) != null)
                        map.remove(input.split(" ")[1]);
                    else
                        System.out.println("Flight not found");
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

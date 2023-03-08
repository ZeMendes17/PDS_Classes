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
                        for(String s : plane.result) // remove
                            System.out.println(s);
                    }
                    break;
                
                case "F":
                
                    break;

                case "R":
                    break;

                case "C":
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

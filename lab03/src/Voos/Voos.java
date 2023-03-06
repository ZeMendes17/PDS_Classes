package src.Voos;

import java.util.Scanner;

public class Voos {
    public static void main(String[] args) {
        // implement options
        Scanner in = new Scanner(System.in);
        String input, option, file;
        int terminate;

        System.out.println(helpMessage());
        while(true){
            terminate = 0;
            System.out.println();
            input = in.nextLine();
            option = input.split("//s+")[0]; // first

            switch(option){
                case "H":
                    System.out.println(helpMessage());
                    break;

                case "I":
                    System.out.print("Filename: ");
                    Scanner sc = new Scanner(System.in);
                    file = sc.nextLine();
                    FileInfo f_info = new FileInfo(file);
                    f_info.readFile();
                    break;

                case "M":
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
               "Q -> terminates the program\n";
    }
}

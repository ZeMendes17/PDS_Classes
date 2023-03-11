package Voos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = null;
        FlightManagementSystem managementSystem = new FlightManagementSystem();
        if (args.length == 0) { // if no file

            sc = new Scanner(System.in);

        } else { // if file
            File file = new File(args[0]);

            try {
                sc = new Scanner(file);
            } catch (FileNotFoundException e) {
                System.err.println("File not found.");
                System.exit(0);
            }
        }


        boolean execute = true;
        char choosedOption;
        String inputedArgsString = "";
        String inputedArgs[];

        while (execute) {
            System.out.println("Choose an option: [ Choose H to see available options] ");

            choosedOption = sc.next().charAt(0);
            choosedOption = Character.toUpperCase(choosedOption);

            switch (choosedOption) {
                case 'I':
                    inputedArgsString = sc.nextLine().strip();
                    if (inputedArgsString.equals("")) {
                        System.out.println("Option was not used properly, follow this pattern: I <filename>");
                        break;
                    }
                    File filename = new File(inputedArgsString);
                    Scanner sc_Ifile = null;
                    try {
                        sc_Ifile = new Scanner(filename);
                    } catch (FileNotFoundException e) {
                        System.err.println("File not found");
                        break;
                    }
                    boolean isFirstLine = true;
                    String fileLine;
                    String[] firstLineInfo;
                    String[] fileInfo;
                    String flightCode = "";
    
                    while (sc_Ifile.hasNextLine()) {
                        fileLine = sc_Ifile.nextLine();
                        if (isFirstLine) {
                            firstLineInfo = parseFirstLine(fileLine);
                            isFirstLine = false;

                            if (firstLineInfo == null || firstLineInfo.length < 2 || firstLineInfo.length > 3) {
                                System.out.println(
                                        "There was an error processing flight information. Please try again. Format: >flight_code num_seats_executive num_seats_tourist");
                                break;
                            }
                            if (firstLineInfo.length == 2) {
                                FlightGenerator flightGenerator = new FlightGenerator(firstLineInfo[0], null, firstLineInfo[1]);
                                Flight newFlight = flightGenerator.generate();
                                flightCode = firstLineInfo[0];
                                managementSystem.addFlight(newFlight);
                            } else {
                                FlightGenerator flightGenerator = new FlightGenerator(firstLineInfo[0],firstLineInfo[1], firstLineInfo[2]);
                                Flight newFlight = flightGenerator.generate();
                                flightCode = firstLineInfo[0];
                                managementSystem.addFlight(newFlight);
                            }
                        } else {
                            fileInfo = fileLine.split(" ");

                            if (fileInfo.length == 2) {
                                String reservationCode;
                                try {
                                    int number = Integer.parseInt(fileInfo[1]);
                                    reservationCode = managementSystem.makeReservation(flightCode, fileInfo[0], number);
                                } catch (Exception e) {
                                    System.out.println("Option was not used properly, follow this pattern: R flight_code class[T/E] number_seats");
                                }
                            } else{
                                System.out.println("Reservation is incorrrect: " + fileInfo);
                            }
                        }
                    }
                    sc_Ifile.close();
                    break;
                case 'M':
                    inputedArgsString = sc.nextLine().strip();
                    if (inputedArgsString.equals("")) {
                        System.out.println("Option was not used properly, follow this pattern: M flight_code");
                        break;
                    }
                    managementSystem.printFlight(inputedArgsString);
                    break;
                case 'F':
                    inputedArgsString = sc.nextLine().strip();
                    if (inputedArgsString.equals("")) {
                        System.out.println("Option was not used properly, follow this pattern: F flight_code num_seats_executive num_seats_tourist");
                        break;
                    }
                    inputedArgs = inputedArgsString.split(" ");

                    if (inputedArgs.length == 3) {
                        FlightGenerator flightGenerator = new FlightGenerator(inputedArgs[0],inputedArgs[1], inputedArgs[2]);
                        Flight newFlight = flightGenerator.generate();
                        managementSystem.addFlight(newFlight);
                        break;
                    } else if (inputedArgs.length == 2) {
                        FlightGenerator flightGenerator = new FlightGenerator(inputedArgs[0], null, inputedArgs[1]);
                        Flight newFlight = flightGenerator.generate();
                        managementSystem.addFlight(newFlight);
                        break;
                    } else {
                        System.out.println("Option was not used properly, follow this pattern: F flight_code num_seats_executive num_seats_tourist");
                        break;
                    }

                case 'R':
                    inputedArgsString = sc.nextLine().strip();
                    inputedArgs = inputedArgsString.split(" ");
                    String reservationCode = "";

                    if (inputedArgs.length == 3) {
                        try {
                            int number = Integer.parseInt(inputedArgs[2]);
                            reservationCode = managementSystem.makeReservation(inputedArgs[0], inputedArgs[1], number);
                        } catch (Exception e) {
                            System.out.println("Option was not used properly, follow this pattern: R flight_code class[T/E] number_seats");
                            break;
                        }

                        if (reservationCode == null){
                            System.out.println("Reservation was not made");
                        }else{
                            System.out.println(reservationCode);
                        }
                        break;
                    } else {
                        System.out.println("Option was not used properly, follow this pattern: R flight_code class[T/E] number_seats");
                        break;
                    }

                case 'C':
                    inputedArgsString = sc.nextLine().strip();
                    inputedArgs = inputedArgsString.split(":");

                    if (inputedArgs.length == 2) {

                        String flighCode = inputedArgs[0].strip();
                        try {
                            int reservationID = Integer.parseInt(inputedArgs[1]);
                            String cancelResult = managementSystem.cancelReservation(flighCode, reservationID);

                            System.out.println(cancelResult);
                            break;
                        } catch (Exception e) {
                            System.out.println("Option was not used properly, follow this pattern: C reservation_code");
                            break;
                        }
                    } else {
                        System.out.println( "Option was not used properly, follow this pattern: C reservation_code" );
                    }
                    break;
                
                case 'Q':
                    System.out.println("Adiós");
                    execute = false;
                    break;
                case 'H':
                    printHelp();
                    break;
                default:
                    System.out.println("Option doesn't exist;");
            }

        }

        sc.close();
    }

    private static void printHelp() {
        System.out.println("I filename :  read file and process fly information");
        System.out.println("M flight_code : print fly reservation map");
        System.out.println(
                "F flight_code num_seats_executive  num_seats_tourist : Add new fly [ executive seats are optional ]");
        System.out.println(
                "R flight_code class number_seats : Add reservation to existing fly [ class should be T or E ]");
        System.out.println("C reservation_code : Cancel reservation");
        System.out.println("Q : Exit");
    }

    private static String[] parseFirstLine(String firstLine) {
        String[] info;

        if (firstLine.charAt(0) != '>') {
            System.err.println("First character should be '>' ");
            return null;
        }
        info = firstLine.split(">");
        info = info[1].split(" ");

        return info;
    }

}

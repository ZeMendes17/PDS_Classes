package src.Voos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
// class to read flight file
public class FileInfo {
    String file;

    // constructor
    public FileInfo(String file){
        this.file = file;
    }

    //getter
    public String getFile(){
        return file;
    }
    // setter
    public void setFile(String file){
        this.file = file;
    }

    // method to read file
    public List<String> readFile(){
        List<String> result = new ArrayList<>();
        File f = new File(file);
        try {
            Scanner sc = new Scanner(f);
            String flight_info = sc.nextLine();
            String flight = flight_info.split(" ")[0].replaceAll(">", "");
            result.add(flight);
            String T, E;
            int tourist = 0; int executive = 0;

            //  if the flight has only tourist class
            if(flight_info.split(" ").length == 2){
                // add flight info to result list and get total number of seats in tourist class
                List<String> impossibleToRegister = new ArrayList<>();
                T = flight_info.split(" ")[1];
                String seats[] = T.split("x");
                int totalT = Integer.parseInt(seats[0]) * Integer.parseInt(seats[1]);
                result.add(T);

                // read file and add to result list if possible to register or add to impossibleToRegister list if not possible
                while(sc.hasNextLine()){
                    String line = sc.nextLine();
                    // if line starts with E, add to impossibleToRegister list
                    if(line.split(" ")[0].equals("E")){
                        impossibleToRegister.add(line);
                    } else {

                        // if line starts with T, check if it is possible to register
                        if(tourist + Integer.parseInt(line.split(" ")[1]) <= totalT){
                            tourist += Integer.parseInt(line.split(" ")[1]);
                            result.add(line);
                        } else {
                            impossibleToRegister.add(line);
                        }
                    }
                }

                // print results
                System.out.println("Código de voo " + flight + ". Lugares disponíveis: " + totalT+
                                   " lugares em classe Turística.");
                System.out.println("Classe executiva não disponível neste voo.");

                // print impossible to register
                if(!impossibleToRegister.isEmpty()){
                    System.out.print("Não é possível obter os lugares para a reserva:");
                    for(String s : impossibleToRegister){
                        System.out.print(s + " ");
                    }
                    System.out.println();
                }
            
            // if the flight has both classes
            } else if(flight_info.split(" ").length == 3) {

                // add flight info to result list and get total number of seats in both classes

                List<String> impossibleToRegister = new ArrayList<>();

                E = flight_info.split(" ")[1];

                String seats[] = E.split("x");
                int totalE = Integer.parseInt(seats[0]) * Integer.parseInt(seats[1]);

                T = flight_info.split(" ")[2];
                seats = T.split("x");
                int totalT = Integer.parseInt(seats[0]) * Integer.parseInt(seats[1]);
                result.add(T);
                result.add(E);
                
                // read file and add to result list if possible to register or add to impossibleToRegister list if not possible
                while(sc.hasNextLine()){
                    String line = sc.nextLine();
                    if(line.split(" ")[0].equals("E")){
                        // if line starts with E, check if it is possible to register in executive class
                        // if it is possible, add to result list
                        if(executive + Integer.parseInt(line.split(" ")[1]) <= totalE){
                            executive += Integer.parseInt(line.split(" ")[1]);
                            result.add(line);
                        } else {
                            // if it is not possible, add to impossibleToRegister list
                            impossibleToRegister.add(line);
                        }
                        // if line starts with T, check if it is possible to register in tourist class
                        // if it is possible, add to result list
                    } else if(line.split(" ")[0].equals("T")) {
                        if(tourist + Integer.parseInt(line.split(" ")[1]) <= totalT){
                            tourist += Integer.parseInt(line.split(" ")[1]);
                            result.add(line);
                        } else {
                            // if it is not possible, add to impossibleToRegister list
                            impossibleToRegister.add(line);
                        }
                    }
                }
                // print results
                System.out.println("Código de voo " + flight + ". Lugares disponíveis: " + totalE+
                                   " lugares em classe Executiva; " + totalT + " lugares em classe Turística.");

                // print impossible to register
                if(!impossibleToRegister.isEmpty()){
                    // if there are impossible to register, print them
                    System.out.print("Não é possível obter os lugares para a reserva:");
                    for(String s : impossibleToRegister){
                        System.out.print(s + " ");
                    }
                    System.out.println();        
                }
            }
            sc.close();
            return result;
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
            return null;
        }
    }
}

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

            if(flight_info.split(" ").length == 2){
                List<String> impossibleToRegister = new ArrayList<>();
                T = flight_info.split(" ")[1];
                String seats[] = T.split("x");
                int totalT = Integer.parseInt(seats[0]) * Integer.parseInt(seats[1]);
                result.add(T);
                while(sc.hasNextLine()){
                    String line = sc.nextLine();
                    result.add(line);
                    if(line.split(" ")[0].equals("E")){
                        impossibleToRegister.add(line);
                    } else {
                        if(tourist + Integer.parseInt(line.split(" ")[1]) <= totalT){
                            tourist += Integer.parseInt(line.split(" ")[1]);
                        } else {
                            impossibleToRegister.add(line);
                        }
                    }
                }

                System.out.println("Código de voo " + flight + ". Lugares disponíveis: " + totalT+
                                   " lugares em classe Turística.");
                System.out.println("Classe executiva não disponível neste voo.");

                if(!impossibleToRegister.isEmpty()){
                    System.out.print("Não é possível obter os lugares para a reserva:");
                    for(String s : impossibleToRegister){
                        System.out.print(s + " ");
                    }
                    System.out.println();
                }

            } else if(flight_info.split(" ").length == 3) {
                List<String> impossibleToRegister = new ArrayList<>();

                E = flight_info.split(" ")[1];

                String seats[] = E.split("x");
                int totalE = Integer.parseInt(seats[0]) * Integer.parseInt(seats[1]);

                T = flight_info.split(" ")[2];
                seats = T.split("x");
                int totalT = Integer.parseInt(seats[0]) * Integer.parseInt(seats[1]);
                result.add(T);
                result.add(E);
                
                while(sc.hasNextLine()){
                    String line = sc.nextLine();
                    result.add(line);
                    if(line.split(" ")[0].equals("E")){
                        if(executive + Integer.parseInt(line.split(" ")[1]) <= totalE){
                            executive += Integer.parseInt(line.split(" ")[1]);
                        } else {
                            impossibleToRegister.add(line);
                        }
                    } else if(line.split(" ")[0].equals("T")) {
                        if(tourist + Integer.parseInt(line.split(" ")[1]) <= totalT){
                            tourist += Integer.parseInt(line.split(" ")[1]);
                        } else {
                            impossibleToRegister.add(line);
                        }
                    }
                }
                System.out.println("Código de voo " + flight + ". Lugares disponíveis: " + totalE+
                                   " lugares em classe Executiva; " + totalT + " lugares em classe Turística.");

                if(!impossibleToRegister.isEmpty()){
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

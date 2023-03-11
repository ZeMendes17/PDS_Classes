import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class ex2 {
    private static ArrayList<Flight> flights;
    public static void main(String[] args) throws IOException{
        Scanner sc;
        flights = new ArrayList<Flight>();
        String op;
        String[] command;

        if (args.length == 1) {
            System.out.println("2");
            File f = new File(args[0]);
            if (f.exists()) {
                sc = new Scanner(f);
            } else {
                sc = new Scanner(System.in);
            }
        } else {
            sc = new Scanner(System.in);
        }

        do{
            System.out.println("\nEscolha uma opçao: (H para ver menu)");
            op = sc.nextLine();
            command = op.split("\\s+");
            menuOptions(command);
        }while (!command[0].equals("Q"));
        sc.close();
    }

    private static void menuOptions(String[] command) throws IOException {
        switch (command[0]) {
            case "H":
                if (command.length == 1)
                    printMenu();
                else{
                    System.out.println("O comando H deve ser passado como: H");
                }
                break;
            case "I":
                if (command.length == 2){
                    File f = new File(command[1]);
                    if(f.exists()){
                        readFromFile(f);
                    }
                    else{
                        System.out.println("Ficheiro nao existe");
                    }
                }
                else{
                    System.out.println("O comando I deve ser passado como: I <filename>");
                }
                break;
            case "M":
                if (command.length == 2 && codeExists(command[1])){
                    printFlight(command[1]);
                }
                else{
                    System.out.println("O comando M deve ser passado como: M <flight_code>");
                }
                break;
            case "F":
                if ((command.length == 3 || command.length == 4) && !codeExists(command[1])){
                    addFlight(command);
                }
                else{
                    System.out.println("O comando F deve ser passado como: F flight_code num_seats_executive num_seats_tourist");
                }
                break;
            case "R":
                if(command.length == 4 && codeExists(command[1])){
                    if(checkNumSeats(command[1], Integer.parseInt(command[3]), command[2])){
                        addBooking(command[1], command[2], Integer.parseInt(command[3]));
                    }
                    else{
                        System.out.println("Nao ha lugares disponiveis");
                    }
                }
                else{
                    System.out.println("O comando R deve ser passado como: R flight_code class number_seats");
                }
                break;
            case "C":
                if (command.length == 2){
                    String[] com = command[1].split(":");
                    if(codeExists(com[0])){
                        cancelBooking(com[0], com[1]);
                    }
                    else{
                        System.out.println("O comando C deve ser passado como: C reservation_code");                        
                    }
                }
                else{
                    System.out.println("O comando C deve ser passado como: C reservation_code");
                }
                break;
            default:
                System.out.println("Opção Invalida!");
                break;
        }
    }

    public static void printMenu() {
        System.out.println("I <filename> - Le os comandos do ficheiro em vez do terminal");
        System.out.println("M <flight_code> - Mostra informações sobre um voo");
        System.out.println("F <flight_code> <num_seats_executive> <num_seats_tourist> - Adiciona um voo");
        System.out.println("R <reservation_code> - Adicionar uma reserva");
        System.out.println("C <reservation_code> - Cancela uma reserva");
        System.out.println("Q - Sai do programa");
    }

    public static boolean codeExists(String code) {
		for (Flight voo : flights) {
			if (voo.getCodigo().equals(code))
				return true;
		}
		return false;
	}

    public static void readFromFile(File file) throws IOException {
        Scanner scanner = new Scanner(file);
        Flight voo = new Flight();
        int count = 0;
        Airplane aviao = null;
        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            String[] args = nextLine.split("\\s+");
            if (count == 0 && !nextLine.startsWith(">")) {
                System.out.println("Cabeçalho do ficheiro invalido");
                break;
            } else if (count != 0 && !nextLine.matches("T \\d+") && !nextLine.matches("E \\d+")) {
                System.out.println("Formato de reserva invalido");
                break;
            }
            if (nextLine.startsWith(">")) {
                String codigo = args[0].substring(1, args[0].length());
                if (codeExists(codigo)) {
                    System.out.println("Código de voo invalido!");
                    break;
                }
                System.out.print("Código de voo " + codigo + ". ");
                voo.setCodigo(codigo);
                if (args.length == 2) {
                    aviao = new Airplane(args[1]);
                    voo.setAviao(aviao);
                    System.out.println("Lugares disponiveis " + voo.getAviao().getTurista_disponiveis() + " lugares em classe Turística.\nClasse executiva nao disponível neste voo.");
                } else {
                    aviao = new Airplane(args[1], args[2]);
                    voo.setAviao(aviao);
                    System.out.println("Lugares disponiveis " + voo.getAviao().getExecutiva_disponiveis() + " lugares em classe Executiva; " + voo.getAviao().getTurista_disponiveis() + " lugares em classe Turistica.");
                }
                flights.add(voo);
            } else {
                String classe = args[0];
                int numLugares = Integer.parseInt(args[1]);
                if (checkNumSeats(voo.getCodigo(), numLugares, classe)) {
                    voo.addBooking(classe, numLugares, voo.getCodigo(), aviao);
                } else {
                    System.out.println("Nao foi possivel obter lugares para a reserva: " + classe + " " + numLugares);
                }
            }
            count = 1;
        }
        scanner.close();
    }

    public static boolean checkNumSeats(String code, int num, String classe) {
        for (Flight voo : flights) {
            if (voo.getCodigo().equals(code)) {
                Airplane aviao = voo.getAviao();
                int disponiveis;
                if (classe.equals("E")) {
                    disponiveis = aviao.getExecutiva_disponiveis();
                } else {
                    disponiveis = aviao.getTurista_disponiveis();
                }
                return disponiveis >= num;
            }
        }
        return false;
    }
    
    
    public static void printFlight(String code) {
        if(!codeExists(code)){
            System.out.println("Código nao existe");
            return;
        }
        for (Flight voo : flights) {
            if (voo.getCodigo().equals(code)) {
                Airplane aviao = voo.getAviao();
                int numExecLines = 0;
                int numTuristLines = aviao.getTurista().length;
                int numExecSeats = 0;
                int numTuristSeats = aviao.getTurista()[0].length;
                if (aviao.getExecutiva().length != 0) {
                    numExecLines = aviao.getExecutiva().length;
                    numExecSeats = aviao.getExecutiva()[0].length;
                }
                System.out.print(" ");
                int letraCount = 0;
                for (int i = 0; i < numExecLines + numTuristLines; i++) {
                    System.out.printf("%3d",i + 1);
                }
                System.out.print("\n");
                for (int i = 0; i < numTuristSeats || i < numExecSeats; i++) {
                    System.out.print(((char) ('A' + letraCount++)));
                    try{
                        for (int e = 0; e < numExecLines; e++) {
                            System.out.printf("%3d",aviao.getExecutiva()[e][i]);
                        }
                    } catch (Exception ex) {
                        for (int e = 0; e < numExecLines; e++) {
                            System.out.print("   ");
                        }
                    }
                    try{
                        for (int e = 0; e < numTuristLines; e++) {
                            System.out.printf("%3d",aviao.getTurista()[e][i]);
                        }
                    } catch (Exception ex) {
                        for (int e = 0; e < numTuristLines; e++) {
                            System.out.print("   ");
                        }
                    }
                    System.out.print("\n");
                }
                break;
            }
        }
    }

    public static void addFlight(String[] com) {
       if(com.length == 4){
        Flight novoVoo = new Flight(com[1], com[2], com[3]);
        flights.add(novoVoo);
       }
       else{
        String executive = "0x0";
        Flight novoVoo = new Flight(com[1], executive, com[2]);
        flights.add(novoVoo);
        }
    }
    
    public static void addBooking(String code, String classe, int num) {
        Reserva reserva = null;
        int i = 0;
        while (i < flights.size() && reserva == null) {
            Flight voo = flights.get(i);
            if (voo.getCodigo().equals(code)) {
                reserva = voo.addBooking(classe, num, code, voo.getAviao());
            }
            i++;
        }
        if (reserva != null) {
            StringBuilder sb = new StringBuilder(reserva.getCodigo() + " = ");
            for (i = 0; i < reserva.getLugares().length - 1; i++) {
                sb.append(reserva.getLugares()[i]).append(" | ");
            }
            sb.append(reserva.getLugares()[i]);
            System.out.println(sb.toString());
        }
    }
    
    public static void cancelBooking(String flightCode, String bookingCode){
		for (Flight voo : flights) {
			if (voo.getCodigo().equals(flightCode)) {
				voo.removeBooking(bookingCode);
			}
		}
	}
    
}

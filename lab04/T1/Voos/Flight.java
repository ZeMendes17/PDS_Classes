package Voos;

public class Flight {
    private String flight_code;
    private int[][] executiveSeats;
    private int[][] turisticSeats;
    private int numberExecutiveRows;
    private int numberExecutiveSeats;
    private int numberTuristicRows;
    private int numberTuristicSeats;
    private int availableExecutive;
    private int availableTuristic;
    private int reservationID = 1;
    
    public Flight(String flight_code, int numberExecutiveRows, int numberExecutiveSeats, int numberTuristicRows, int numberTuristicSeats) {
        
        this.flight_code = flight_code;
        this.numberExecutiveRows = numberExecutiveRows;
        this.numberExecutiveSeats = numberExecutiveSeats;
        this.numberTuristicRows = numberTuristicRows;
        this.numberTuristicSeats= numberTuristicSeats;
        this.availableExecutive = numberExecutiveRows * numberExecutiveSeats;
        this.availableTuristic = numberTuristicRows * numberTuristicSeats;
        
        if (numberExecutiveRows == 0 && numberExecutiveSeats == 0){
            this.executiveSeats = null;
        }else{
            this.executiveSeats = new int[numberExecutiveRows][numberExecutiveSeats];
        }
        this.turisticSeats = new int[numberTuristicRows][numberTuristicSeats];
    }
    public String getFlight_code() {
        return flight_code;
    }
    public int[][] getExecutiveSeats() {
        return executiveSeats;
    }
    public int[][] getTuristicSeats() {
        return turisticSeats;
    }
    public int getNumberExecutiveRows() {
        return numberExecutiveRows;
    }
    public int getNumberExecutiveSeats() {
        return numberExecutiveSeats;
    }
    public int getNumberTuristicRows() {
        return numberTuristicRows;
    }
    public int getNumberTuristicSeats() {
        return numberTuristicSeats;
    }

    public String makeTuristicReservation(int number) {
        int firstLetter = 65;
        int firstRowInserted = 0;
        if (number > availableTuristic){
            System.out.println("Não foi possível obter lugares para a reserva: T " + number+".");
            return null;
        }
        String reservationCode = this.flight_code + ":"+this.reservationID + " = ";
        
        for (int row = 0; row < numberTuristicRows; row++){
            // search for empty row
            boolean isEmptyRow = true;
            for (int seat = 0; seat < numberTuristicSeats; seat++){
                if (this.turisticSeats[row][seat] != 0){
                    isEmptyRow = false;
                    break;
                }
            }

            if (isEmptyRow){
                firstRowInserted = row;
                // int x = number > numberTuristicSeats ? numberTuristicSeats : number;
                for (int seat = 0; seat < numberTuristicSeats ; seat++){
                    this.turisticSeats[row][seat] = reservationID;
                    number--;
                    availableTuristic--;
                    String seatLetter = Character.toString((char)firstLetter + seat);
                    int flightRow = row + 1 + numberExecutiveRows;
                    reservationCode += flightRow + seatLetter + " ";

                    if (number == 0){
                        reservationID++;
                        return reservationCode;
                    }
                    reservationCode += "| ";
                }
            }
        }
        // insert remaining seats in next rows
        for(int row = firstRowInserted; row < numberTuristicRows; row++){
            for (int seat = 0; seat < numberTuristicSeats; seat++){
                if (this.turisticSeats[row][seat] == 0){
                    this.turisticSeats[row][seat] = reservationID;
                    
                    number--;
                    availableTuristic--;
                    
                    String seatLetter = Character.toString((char)firstLetter + seat);
                    int flightRow = row + 1 + numberExecutiveRows;
                    reservationCode += flightRow + seatLetter + " ";

                    if (number == 0){
                        reservationID++;
                        return reservationCode;
                    }
                    reservationCode += "| ";
                }
            }
        }

        // insert remaining seats in sequence from top
        for(int row = 0; row < numberTuristicRows; row++){
            for (int seat = 0; seat < numberTuristicSeats; seat++){
                if (this.turisticSeats[row][seat] == 0){
                    this.turisticSeats[row][seat] = reservationID;
                    number--;
                    availableTuristic--;
                    
                    String seatLetter = Character.toString((char)firstLetter + seat);
                    int flightRow = row + 1 + numberExecutiveRows;
                    reservationCode += flightRow + seatLetter + " ";

                    if (number == 0){
                        reservationID++;
                        return reservationCode;
                    }
                    reservationCode += "| ";
                }
            }
        }
        return null;
    }

    public String makeExecutiveReservation(int number) {
        int firstLetter = 65;
        int firstRowInserted = 0;
        if (number > availableExecutive){
            System.out.println("Não foi possível obter lugares para a reserva: E " + number+".");
            return null;
        }
        String reservationCode = this.flight_code + ":"+this.reservationID + " = ";
        
        for (int row = 0; row < numberExecutiveRows; row++){
            // search for empty row
            boolean isEmptyRow = true;
            for (int seat = 0; seat < numberExecutiveSeats; seat++){
                if (this.executiveSeats[row][seat] != 0){
                    isEmptyRow = false;
                    break;
                }
            }

            if (isEmptyRow){
                firstRowInserted = row;
                for (int seat = 0; seat < numberExecutiveSeats ; seat++){
                    this.executiveSeats[row][seat] = reservationID;
                    number--;
                    availableExecutive--;
                    String seatLetter = Character.toString((char)firstLetter + seat);
                    int flightRow = row + 1;
                    reservationCode += flightRow + seatLetter + " ";

                    if (number == 0){
                        reservationID++;
                        return reservationCode;
                    }
                    reservationCode += "| ";
                }
            }
        }
        // insert remaining seats in next rows
        for(int row = firstRowInserted; row < numberExecutiveRows; row++){
            for (int seat = 0; seat < numberExecutiveSeats; seat++){
                if (this.executiveSeats[row][seat] == 0){
                    this.executiveSeats[row][seat] = reservationID;
                    
                    number--;
                    availableExecutive--;
                    
                    String seatLetter = Character.toString((char)firstLetter + seat);
                    int flightRow = row + 1;
                    reservationCode += flightRow + seatLetter + " ";

                    if (number == 0){
                        reservationID++;
                        return reservationCode;
                    }
                    reservationCode += "| ";
                }
            }
        }

        // insert remaining seats in sequence from top
        for(int row = 0; row < numberExecutiveRows; row++){
            for (int seat = 0; seat < numberExecutiveSeats; seat++){
                if (this.executiveSeats[row][seat] == 0){
                    this.executiveSeats[row][seat] = reservationID;
                    number--;
                    availableExecutive--;
                    
                    String seatLetter = Character.toString((char)firstLetter + seat);
                    int flightRow = row + 1 ;
                    reservationCode += flightRow + seatLetter + " ";

                    if (number == 0){
                        reservationID++;
                        return reservationCode;
                    }
                    reservationCode += "| ";
                }
            }
        }
        return null;
    }
    public String cancelReservation(int reservationID) {
        boolean wasCancel = false;
        
        for(int row = 0; row < this.numberExecutiveRows; row++){
            for (int seat = 0; seat < this.numberExecutiveSeats; seat++){
                if (this.executiveSeats[row][seat] == reservationID){
                    this.executiveSeats[row][seat] = 0;
                    wasCancel = true;
                }
            }
        }

        for(int row = 0; row < this.numberTuristicRows; row++){
            for (int seat = 0; seat < this.numberTuristicSeats; seat++){
                if (this.turisticSeats[row][seat] == reservationID){
                    this.turisticSeats[row][seat] = 0;
                    wasCancel = true;
                }
            }
        }

        if (wasCancel){
            return "Cancelation confirmed";
        }
        return "Reservation doesn't exist";
    }
    public void print() {
        int totalNumberRows = numberExecutiveRows + numberTuristicRows;
        int totalNumberSeats = numberExecutiveSeats > numberTuristicSeats ? numberExecutiveSeats : numberTuristicSeats;

        // print numbers
        System.out.printf("   ");
        for (int i = 0; i < totalNumberRows; i++){
            int number = i + 1;
            System.out.printf("%3s ", number);
        }
        System.out.print("\n");
        for (int seat = 0 ; seat < totalNumberSeats; seat++ ){
            String seatLetter = Character.toString((char)65 + seat);
            System.out.print(seatLetter);

            // check if there is executive rows foir this seat letter 
            if (this.numberExecutiveSeats != 0 ){
                if (seat < numberExecutiveSeats){
                    // print executive rows for seat k
                    for (int row = 0; row < numberExecutiveRows ;row++) {
                        System.out.printf("%3s ",this.executiveSeats[row][seat]);
                    }
                }else{
                    // theres no place for this seat letter print empty
                    for (int row =0; row < numberExecutiveRows ;row++) {
                        System.out.printf("%3s ","   ");
                    }

                }
            }
            if (seat < numberTuristicSeats){
                for (int row = 0; row < numberTuristicRows ;row++) {
                    System.out.printf("%3s ",this.turisticSeats[row][seat]);
                }
            } else {
                // theres no place for this seat letter print empty
                for (int row =0; row < numberTuristicRows ;row++) {
                    System.out.printf("%3s ","   ");
                }
            }
            System.out.print("\n");
        }
        
    }
}

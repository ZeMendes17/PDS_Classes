import java.util.Arrays;

public class Airplane {
    private int[][] turista;
    private int[][] executiva;
    private int turista_disponiveis;
    private int executiva_disponiveis;

    public Airplane(String turistaSeats) {
        String[] dims = turistaSeats.split("x");
        int[][] seats = new int[Integer.parseInt(dims[0])][Integer.parseInt(dims[1])];
        for (int[] row : seats) {
            Arrays.fill(row, 0);
        }
        this.turista_disponiveis = Integer.parseInt(dims[0]) * Integer.parseInt(dims[1]);
        this.turista = seats;
        this.executiva = new int[0][0];
        this.executiva_disponiveis = 0;
    }

    public Airplane(String executivaSeats, String turistaSeats) {
        String[] dims = executivaSeats.split("x");
        int[][] seats = new int[Integer.parseInt(dims[0])][Integer.parseInt(dims[1])];
        for (int[] row : seats) {
            Arrays.fill(row, 0);
        }
        this.executiva_disponiveis = Integer.parseInt(dims[0]) * Integer.parseInt(dims[1]);
        this.executiva = seats;
        dims = turistaSeats.split("x");
        seats = new int[Integer.parseInt(dims[0])][Integer.parseInt(dims[1])];
        for (int[] row : seats) {
            Arrays.fill(row, 0);
        }
        this.turista_disponiveis = Integer.parseInt(dims[0]) * Integer.parseInt(dims[1]);
        this.turista = seats;
    }

    public void removeBooking(Reserva reservation) {
        for (String seat : reservation.getLugares()) {
            int row = 0;
            int col = 0;
            for (int i = 0; i < seat.length(); i++) {
                if (Character.isDigit(seat.charAt(i))) {
                    row += Character.getNumericValue(seat.charAt(i));
                } else {
                    col += (Character.getNumericValue(seat.charAt(i)) - Character.getNumericValue('A'));
                }
            }
            if (reservation.getClasse() == 'B') {
                executiva[row - 1][col] = 0;
            } else {
                turista[row - executiva.length - 1][col] = 0;
            }
        }
    }

    public int[][] getTurista() {
        return this.turista;
    }

    public void setturista(int[][] turista) {
        this.turista = turista;
    }

    public int[][] getExecutiva() {
        return this.executiva;
    }

    public void setExecutiva(int[][] executiva) {
        this.executiva = executiva;
    }

    public int getTurista_disponiveis() {
        return this.turista_disponiveis;
    }

    public void setTurista_disponiveis(int turista_disponiveis) {
        this.turista_disponiveis = turista_disponiveis;
    }

    public int getExecutiva_disponiveis() {
        return this.executiva_disponiveis;
    }

    public void setexecutiva_disponiveis(int executiva_disponiveis) {
        this.executiva_disponiveis = executiva_disponiveis;
    }

}

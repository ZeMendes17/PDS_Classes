import java.util.ArrayList;

public class Flight {

   private Airplane aviao;
   private String codigo;
   private ArrayList<Reserva> reservas;
   private int numReserva = 1;

   public Flight() {
       this.reservas = new ArrayList<>();
   }

   public Flight(String codigo, String seatsExecutive, String seatsTourist) {
       if (seatsExecutive.equals("0x0")) {
           this.aviao = new Airplane(seatsTourist);
       } else {
           this.aviao = new Airplane(seatsExecutive, seatsTourist);
       }
       this.codigo = codigo;
       this.reservas = new ArrayList<>();
   }

   public Reserva addBooking(String classe, int numLugares, String codigoVoo, Airplane aviao) {
      Reserva reserva = new Reserva(codigoVoo + ":" + String.valueOf(numReserva++), numLugares, classe.charAt(0));
      reservas.add(reserva);
      int[][] lugares;
      if (classe.equals("E")) {
          lugares = aviao.getExecutiva();
          aviao.setexecutiva_disponiveis(aviao.getExecutiva_disponiveis() - numLugares);
      } else {
          lugares = aviao.getTurista();
          aviao.setTurista_disponiveis(aviao.getTurista_disponiveis() - numLugares);
      }
      for (int i = 0; i < lugares.length; i++) {
          if (checkLine(lugares[i])) {
              for (int e = 0; e < lugares[i].length && numLugares > 0; e++) {
                  lugares[i][e] = numReserva - 1;
                  numLugares--;
                  if (classe.equals("E"))
                      reserva.adicionarLugar(String.valueOf(i + 1) + String.valueOf((char) ('A' + e)));
                  else
                      reserva.adicionarLugar(String.valueOf(i + 1 + this.aviao.getExecutiva().length) + String.valueOf((char) ('A' + e)));
              }
          }
      }
      for (int i = 0; i < lugares.length; i++) {
          for (int e = 0; e < lugares[i].length && numLugares > 0; e++) {
              if (lugares[i][e] == 0) {
                  lugares[i][e] = numReserva - 1;
                  numLugares--;
                  if (classe.equals("E"))
                      reserva.adicionarLugar(String.valueOf(i + 1) + String.valueOf((char) ('A' + e)));
                  else
                      reserva.adicionarLugar(String.valueOf(i + 1 + this.aviao.getExecutiva().length) + String.valueOf((char) ('A' + e)));
              }
          }
      }
      return reserva;
  }

    public boolean checkLine(int[] line) {
        for (int i : line) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
  
  public void removeBooking(String bookingCode) {
      for (Reserva r : reservas) {
          if (r.getCodigo().equals(bookingCode)) {
              reservas.remove(r);
              aviao.removeBooking(r);
              break;
          }
      }
  }
  

   public Airplane getAviao() {
      return this.aviao;
   }

   public void setAviao(Airplane aviao) {
      this.aviao = aviao;
   }

   public String getCodigo() {
      return this.codigo;
   }

   public void setCodigo(String codigo) {
      this.codigo = codigo;
   }

   public ArrayList<Reserva> getReservas() {
      return this.reservas;
   }

   public void setReservas(ArrayList<Reserva> reservas) {
      this.reservas = reservas;
   }

   public int getNumReserva() {
      return this.numReserva;
   }

   public void setNumReserva(int numReserva) {
      this.numReserva = numReserva;
   }
   
}
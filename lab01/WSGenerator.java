public class WSGenerator {
    // generates Word Search using a file that contains the words
    // that is obtained in the command line using -i
    // should contain a size, -s
    // and may have a destination file given by -o

    public static void main(String[] args) {
        RandomGenerator a = new RandomGenerator();

        System.out.println(a.generateDirection());
        System.out.println(a.generatePosition(12) + "," + a.generatePosition(12));

        // gerar ate dar para colocar
        // ver se nao esta ja preenchido
    }
}

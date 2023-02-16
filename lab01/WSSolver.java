
import java.util.Scanner;
import java.io.File;

public class WSSolver extends Verification{
    public static void main(String[] args) throws Exception {
        // String[] words =  {"Up", "Down", "Left", "Right", "UpLeft", "UpRight", "DownLeft", "DownRight"};
        char[][] puzzle = new char[40][40];
        int i;


        // vai ler o args[0] para ler o ficheiro
        File file = new File(args[0]);
        
        Scanner sc = new Scanner(file);

        int puzzleLineLength = 12; // mais tarde determinar dinamicamente
        int line = 0;
        while(sc.hasNextLine() && line < puzzleLineLength) {
            String tempLine = sc.nextLine();
            for(i = 0; i < puzzleLineLength; i++){
                puzzle[line][i] = tempLine.charAt(i);
            }
            line++;
        }
        sc.close();

        for(i = 0; i < puzzle.length; i++){
            for(int j = 0; j < puzzle.length; i++){
                System.out.println(puzzle[i][j] + " ");
            }
            System.out.print("\n");
        }

        Verification verify = new Verification();

        boolean a = verify.validateWordSearch(file); // so para saber como usar a seguir

    }

        // try {
        //     System.out.println("Palavra " + words[20]);
        // } catch (ArrayIndexOutOfBoundsException e) {
        //     System.out.println("Fora do array");
        // }

}

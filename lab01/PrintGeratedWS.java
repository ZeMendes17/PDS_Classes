import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;

public class PrintGeratedWS {
    
    public void print(char[][] wordSearch, File f){
        RandomGenerator rand = new RandomGenerator();

        for(char[] c : wordSearch){ // prints the WS
            for(char cc : c){
                if(cc == '\0')
                    cc = rand.generateRandomChar();
                System.out.print(cc + " ");
            }
            System.out.println();
        }

        try {
            Scanner sc = new Scanner(f);
            while(sc.hasNextLine())
                System.out.println(sc.nextLine());

            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return;
        }
    }

    public void printToFile(char[][] wordSearch, File f, String dest){
        RandomGenerator rand = new RandomGenerator();

        try {
            PrintWriter writer = new PrintWriter(dest);

            for(char[] c : wordSearch){ // prints the WS
                for(char cc : c){
                    if(cc == '\0')
                        cc = rand.generateRandomChar();
                    writer.print(cc);
                }
                writer.println();
            }
            try {
                Scanner sc = new Scanner(f);
                while(sc.hasNextLine())
                    writer.println(sc.nextLine());
    
                sc.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
                writer.close();
                return;
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Unexpected error");
        }
    }
}

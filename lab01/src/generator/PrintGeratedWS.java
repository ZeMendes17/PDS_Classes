package src.generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;

/// this class is used to print the gerated Word Search to the terminal or to a destination file
public class PrintGeratedWS {
    
    // prints it to the terminal
    public void print(char[][] wordSearch, File f){
        RandomGenerator rand = new RandomGenerator();

        // prints the Word Search
        for(char[] c : wordSearch){
            for(char cc : c){
                if(cc == '\0')
                    cc = rand.generateRandomChar();
                System.out.print(cc + " ");
            }
            System.out.println();
        }

        // prints the words to be found in the WS
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

    // prints it to a destination file
    public void printToFile(char[][] wordSearch, File f, String dest){
        RandomGenerator rand = new RandomGenerator();

        try {
            PrintWriter writer = new PrintWriter(dest);

            // prints the Word Search to the file
            for(char[] c : wordSearch){
                for(char cc : c){
                    if(cc == '\0')
                        cc = rand.generateRandomChar();
                    writer.print(cc);
                }
                writer.println();
            }

            try {
                Scanner sc = new Scanner(f);

                // prints the words to be found in the WS from a destination file
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

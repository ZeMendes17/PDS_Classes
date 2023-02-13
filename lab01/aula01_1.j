// JavaScript source code
package lab01;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files


public class Validation {
    public static void main(String[] args) {
        try {
            int cubeValidation2  = 0;
            int cubeValidation  = 0;
            int pri_linha_comp = 0;
            File myObj = new File("sopa01.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (cubeValidation2 == 0) {
                    pri_linha_comp = data.length();
                }

                if (cubeValidation2 > 0 && cubeValidation2 < pri_linha_comp) {
                    if (cubeValidation != data.length()) {
                        System.out.println("Linhas com número de colunas diferentes!");
                        break;
                    }

                }
                cubeValidation = data.length();
                cubeValidation2 += 1; 

                System.out.println(data);
            }
            if (cubeValidation2 != pri_linha_comp) {
                System.out.println("O puzzle não é um quadrado! (Número de linhas nao coincide com numero de colunas)");
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
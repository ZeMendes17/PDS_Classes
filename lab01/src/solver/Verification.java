package src.solver;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Verification implements VerificationInterface {

    private static boolean isStringUpperCase(String s){
        
        //convert String to char array
        char[] charArray = s.toCharArray();
        
        for(char c : charArray){
            
            //if any character is not in upper case, return false
            if(!Character.isUpperCase(c))
                return false;
        }
        
        return true;
    }

    @Override
    public boolean validateWordSearch(File f) {

        try {
            Scanner sc = new Scanner(f);
            String tempLine = sc.nextLine();
            if(tempLine == null || !isStringUpperCase(tempLine)){
                sc.close();
                return false;
            }

            int ws_lenght = tempLine.length();
            if(ws_lenght >= 40){
                sc.close();
                return false;
            }

            for(int i = 1; i < ws_lenght; i++){
                tempLine = sc.nextLine();
                if( tempLine.isEmpty() || tempLine.length() != ws_lenght || !isStringUpperCase(tempLine)){
                    sc.close();
                    return false;
                }
            }
            sc.close();
            return true;

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return false;
        }

        
    }

    @Override
    public boolean validateWords(File f) {
        try {
            Scanner sc = new Scanner(f);
            String tempLine = sc.nextLine();
            int ws_lenght = tempLine.length();
            for(int i = 1; i < ws_lenght; i++)
                tempLine = sc.nextLine();
            
            StringBuilder str = new StringBuilder();
            while(sc.hasNextLine()){
                tempLine = sc.nextLine();
                if(tempLine.isEmpty()){ // caso uma linha esteja vazia
                    sc.close();
                    return false;
                }
                str.append(tempLine);
            }
            sc.close();

            String s = str.toString();

            s = s.replace(" ", "");
            s = s.replace(";", "");
            s = s.replace(",", "");

            if(!s.matches("[a-zA-Z]+")) // verificar se todas as palavras sao alfanumericas
                return false;
            return true;

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return false;
        }
        
    }
    
}

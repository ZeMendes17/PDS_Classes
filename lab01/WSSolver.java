import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class WSSolver implements VerificationInterface, InfoInterface {
    public static void main(String[] args) throws Exception {
        String[] words =  {"Up", "Down", "Left", "Right", "UpLeft", "UpRight", "DownLeft", "DownRight"};
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

    }

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
            for(int i = 1; i < ws_lenght; i++){
                tempLine = sc.nextLine();
                if(tempLine.length() != ws_lenght || !isStringUpperCase(tempLine)){
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
            while(sc.hasNextLine())
                str.append(sc.nextLine());
            sc.close();

            String s = str.toString();

            s = s.replace(" ", "");
            s = s.replace(";", "");
            
            if(!s.matches("[a-zA-Z]+"))
                return false;
            return true;

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return false;
        }
        
    }

    @Override
    public void getWordSearch(File f) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void getWords(File f) {
        // TODO Auto-generated method stub
        
    }

            
        // try {
        //     System.out.println("Palavra " + words[20]);
        // } catch (ArrayIndexOutOfBoundsException e) {
        //     System.out.println("Fora do array");
        // }

}

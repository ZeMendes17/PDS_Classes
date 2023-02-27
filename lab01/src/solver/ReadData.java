package src.solver;
import java.util.Scanner;
import java.util.List;
import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class ReadData implements InfoInterface {
    
    // Reads the word search from the file and returns it as a 2D array of characters 
    @Override
    public char[][] readWordSearch(File f) {
        //todo Auto-generated method stub
        try {
            Scanner sc = new Scanner(f);
            String tempLine = sc.nextLine();
            int ws_lenght = tempLine.length();
            char[][] wordSearch = new char[ws_lenght][ws_lenght];

            // Reads the first line of the word search and stores it in the array 
            wordSearch[0] = tempLine.toCharArray();
            for(int line = 1; line < ws_lenght; line++){
                tempLine = sc.nextLine();
                wordSearch[line] = tempLine.toCharArray();
            }

            sc.close();
            return wordSearch;

        }  catch (FileNotFoundException e) {
            System.out.println("File not found");
            return null;
        }
    }

    // Reads the words from the file and returns them as a list of strings
    @Override
    public List<String> readWords(File f, int hasWS) {
        if(hasWS == 1){
            try {
                Scanner sc = new Scanner(f);
            List<String> words = new ArrayList<>();
            String s;
                
                String tempLine = sc.nextLine();
                int ws_lenght = tempLine.length();
 
                for(int i = 1; i < ws_lenght; i++)
                    tempLine = sc.nextLine();
                
                StringBuilder str = new StringBuilder();
                while(sc.hasNextLine()){
                    if(!str.toString().matches("")) // to separate words in dif lines
                        str.append(";");
                    str.append(sc.nextLine());
                }
                sc.close();

                // string with all words
                s = str.toString();

                // replaces spaces and commas with semicolons
                s = s.replace(" ", ";");
                s = s.replace(",", ";");

                // splits the string into an array of words
                String[] wordsTemp = s.split(";");

                for(String temp : wordsTemp){
                    if(temp.length() < 3) // ignores words with less than 3 letters
                        continue;
                    // adds the word to the list of words in uppercase letters (only uppercase letters in the word search)
                    words.add(temp.toUpperCase());
                }

                return words;
            
            }  catch (FileNotFoundException e) {
                System.out.println("File not found");
                return null;
            }

        }else{
            try {
                Scanner sc = new Scanner(f);
                List<String> words = new ArrayList<>();
                String s;
                StringBuilder str = new StringBuilder();
                while(sc.hasNextLine()){
                    if(!str.toString().matches("")) // to separate words in dif lines
                        str.append(";");
                    str.append(sc.nextLine());
                }
                sc.close();

                s = str.toString();
                s = s.replace(" ", ";");
                s = s.replace(",", ";");
                String[] wordsTemp = s.split(";");

                for(String temp : wordsTemp){
                    if(temp.length() < 3) // ignores words with less than 3 letters
                        continue;
                    words.add(temp.toUpperCase());
                }

                return words;
            
            }  catch (FileNotFoundException e) {
                System.out.println("File not found");
                return null;
            }
        }
    }
}

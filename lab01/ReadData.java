import java.util.Scanner;
import java.util.List;
import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class ReadData implements InfoInterface {
    
    @Override
    public char[][] readWordSearch(File f) {
        //todo Auto-generated method stub
        try {
            Scanner sc = new Scanner(f);
            String tempLine = sc.nextLine();
            int ws_lenght = tempLine.length();
            char[][] wordSearch = new char[ws_lenght][ws_lenght];

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

    @Override
    public List<String> readWords(File f) {
        //todo Auto-generated method stub
        try {
            Scanner sc = new Scanner(f);
            String tempLine = sc.nextLine();
            int ws_lenght = tempLine.length();
            List<String> words = new ArrayList<>(); 
            String s;

            for(int i = 1; i < ws_lenght; i++)
                tempLine = sc.nextLine();
            
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

            for(String temp : wordsTemp)
                words.add(temp.toUpperCase());

            return words;
        
        }  catch (FileNotFoundException e) {
            System.out.println("File not found");
            return null;
        }
    }
}

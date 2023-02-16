import java.util.Scanner;
import java.util.List;
import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class ReadData implements InfoInterface {
    
    @Override
    public List<String> getWordSearch(File f) {
        //todo Auto-generated method stub
        try {
            Scanner sc = new Scanner(f);
            String tempLine = sc.nextLine();
            int ws_lenght = tempLine.length();
            List<String> WordSearch = new ArrayList<>(); 


            for(int i = 1; i < ws_lenght; i++){
                WordSearch.add(tempLine);
                tempLine = sc.nextLine();
            }

            sc.close();
            return WordSearch;
        
        }  catch (FileNotFoundException e) {
            System.out.println("File not found");
            return null;
        }
    }

    @Override
    public List<String> getWords(File f) {
        //todo Auto-generated method stub
        try {
            Scanner sc = new Scanner(f);
            String tempLine = sc.nextLine();
            int ws_lenght = tempLine.length();
            List<String> Words = new ArrayList<>(); 

            for(int i = 1; i < ws_lenght; i++)
                tempLine = sc.nextLine();
            
            StringBuilder str = new StringBuilder();
            while(sc.hasNextLine())
                str.append(sc.nextLine());
            sc.close();

            String s = str.toString();
            

            int c = 0;
            for (int i = 0; i<s.length(); i++)
            {
                int j = s.indexOf(" ");
                int m = s.indexOf(";");
                if (s.charAt(i) == s.charAt(j) || s.charAt(i) == s.charAt(m)) {
                    Words.add(s.substring(c,i-1));
                    c = i+1;
                }
            }
            return Words;
        
        }  catch (FileNotFoundException e) {
            System.out.println("File not found");
            return null;
        }
    }
}

package T1.src.generator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


//  This is the main project class
public class WSGenerator {

    //  Verify if the given file path and maximum soup size is valid
    public static boolean verify(String path, Integer size) throws Exception {
        
        if(!Files.exists(Paths.get(path))) {
            throw new Exception("File does not exist");
        }

        if(size > 40) {
            throw new Exception("Invalid size! Must be less than 40");
        }

        return true;
        
    }
    
    //  The main function
    public static void main(String args[]){

        String path_in = null;
        Integer size = -1;
        String path_out = null;
        int numberOfTries = 0;


        //  Poor's man getops
        for(int i=0;i<args.length;i++) {
            if(args[i].equals("-i")) {
                path_in = args[i+1];
            }

            if(args[i].equals("-s")) {
                size = Integer.parseInt(args[i+1]);
            }

            if(args[i].equals("-o")) {
                path_out = args[i+1];
            }
        }


        try {
            //  Validate the file and get its contents in the Scanner
            verify(path_in, size);
            Scanner sc = null;
            sc = new Scanner(new BufferedReader(new FileReader(path_in)));

            //  Create an array and fill it with the words to Search
            ArrayList<String> SearchWordsInFile = new ArrayList<String>();
            SearchWordsInFile = lookForSearchWords(sc);

            //  Make sure even the largest word fits in the soup size given
            if( SearchWordsInFile.get(0).length() > size){
                throw new Exception("Size to small!");
            }
 
            //  Sort the words by length
            Collections.sort(SearchWordsInFile, new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                    return s1.length() > s2.length() ? -1 : s2.length() < s1.length() ? 1 : 0;
                }
            });

            //  Try to fit every word in the soup, if a souo can't fit a word, restart and try again
            //  We (arbitrarily) chose a maximum of 50 tries before cutting the program
            while (true) {
                try {
                    // Initiate the Soup
                    Soup sopinha = new Soup(size);  
    
                    //  Add each Search Word to the Soup
                    for (String SearchWord : SearchWordsInFile) {
                        if(sopinha.addToSoup(SearchWord) == false) {
                            numberOfTries++;
                            throw new Exception("Too many words!");
                        }
                    }
    
                    //  Fill the remaining spots in the soup with random characters
                    sopinha.fillSoup();

                    //  If a path out wasn't given, print the results to the terminal
                    if (path_out == null) {
                        System.out.println(sopinha.toPrint());
                    }
                    //  If a path out was given, print to a file
                    else {
                        PrintWriter output = new PrintWriter(path_out);
                        StringBuffer out = new StringBuffer();

                        //  Add the soup
                        out.append(sopinha.toString());

                        //  Add the Search Words
                        int z = 1;
                        for(String word : SearchWordsInFile) {
                            out.append(word + ";");
                            if (z % 3 == 0) {
                                z = 0;
                                out.append("\n");
                            }                            
                            z++;
                        }

                        output.println(out);
                        output.flush();
                        output.close();
                    }

                    break;
                }
                catch (Exception e) {
                    //  Try only 50 times before throwing the Exception up
                    if (numberOfTries == 50) { 
                        throw e;
                    }                    
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace(); // print the exception
            System.out.println("There was an error in the main program! Exiting...");
            System.exit(1);
        }

    }

    private static ArrayList<String> lookForSearchWords(Scanner sc) throws Exception {

        ArrayList<String> SearchWordsAdded = new ArrayList<String>();
        String currentline;

        //  Read every line from the given file
        while(sc.hasNextLine()) {
            currentline = sc.nextLine();

            //  Throw error if the file contains empty lines
            if (currentline.isEmpty()) {
                throw new Exception("The input file contains empty lines!");
            }

            boolean wordAlreadyExists;

            // Run through each word (seperated by spaces, ';' or newlines)
            for(String newWord : currentline.split("[ ,;\t\n]")) { 
                wordAlreadyExists = false;   
                String upperCasenewWord = newWord.toUpperCase();

                //  Check if the word is too small (less than 3 characters long)
                if(newWord.length() < 3) {
                    throw new Exception("One of the Search Words is too small! They must have more than 3 characters.");
                }          

                //  Check if the word is already a sub-string of another inserted Search Word
                // or if a previouslly inserted Search Word is a substring of this new Search Word

                for(String SearchWord : SearchWordsAdded) {  
                    SearchWord = SearchWord.toUpperCase();                          
                    // There is already a Search Word with a substring that is the same as this new word
                    if (SearchWord.contains(upperCasenewWord)) {
                        wordAlreadyExists = true;
                    }
                    // There is already a Search Word that is a substring of this new word
                    else if (upperCasenewWord.contains(SearchWord)) {
                        // Remove the old Search Word
                        SearchWordsAdded.remove(SearchWord);                                
                    }
                }

                //  Insert only if the new Search Word doesn't exist
                if (!wordAlreadyExists) {
                    SearchWordsAdded.add(newWord);
                }
            }
        }

        return SearchWordsAdded;
    }

}

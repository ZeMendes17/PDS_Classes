package T1.src.solver;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;


public class Grid {
    //  Important class global variables
    private Integer size;
    private Character soup[][];
    //  int[6] => [wordInSoup?(0 or 1), x where word started, y where word started, word length, x orientation, y orientation]
    private LinkedHashMap<String,int[]> solutions = new LinkedHashMap<String,int[]>();
    private boolean[][] map;
   

    // Simple Getters (unused but still important)
    public Set<String> getSolutions() {
        return solutions.keySet();
    }

    public int[] getSolutionByKey(String key) {
        return solutions.get(key);
    }

    public Character[][] getSoup() {
        return soup;
    }

    public Integer getSize() {
        return size;
    }


    //  Constructor
    Grid(Scanner sc) {
        //  Initiate the Soup array and Boolean array
        this.soup = new Character[40][40];
        this.map = new boolean[40][40];
    
        String currentline;      //  Current line
        int soupLineIndex = 0;   //  Line counter
        int sizeOfLastLine = -1;
        int sizeOfCurrentLine = -1;

        try {   
            //  Read every line from the given file
            while(sc.hasNextLine()) {
                currentline = sc.nextLine();

                //  Throw error if the file contains empty lines
                if (currentline.isEmpty()) {
                    throw new Exception("The input file contains empty lines!");
                }

                //  Check if the first line belongs to the Soup or the Search Words
                // (or none!) and add them to the respective data sets
                if (lineIsFromSoup(currentline)) {
                    //  Get the size of the current line
                    sizeOfCurrentLine = currentline.length();

                    //  Throw error if the line is bigger than the maximum length
                    if (sizeOfCurrentLine >= 40) {
                        throw new Exception("The size of the initial Soup is too big! Maximum size is 40x40.");
                    }

                    //  Throw error if the line isn't the same size as the last (matrix isn't square)
                    if (sizeOfLastLine != -1 && sizeOfLastLine != sizeOfCurrentLine) {
                        throw new Exception("The initial Soup isn't square!");
                    }

                    //  Size of the matrix (should be constant)
                    this.size = currentline.length();

                    //  Add the current line to the Soup
                    addToGrid(currentline, soupLineIndex);

                    //  Advance the Soup line index
                    soupLineIndex++;
                    sizeOfLastLine = sizeOfCurrentLine;
                }

                else {
                    //  Check if the line is from the Search Words 
                    // (we already checked that it isn't from the Soup)
                    if(!lineIsFromSearchWords(currentline)) {
                        throw new Exception("One of the lines isn't from the Soup or the Search Words!");
                    }

                    boolean wordAlreadyExists;

                    // Run through each word (seperated by spaces, ';' or newlines)
                    for(String s:currentline.split("[ ,;\t]")) { 
                        wordAlreadyExists = false;   

                        //  Check if the word is too small (less than 3 characters long)
                        if(s.length() < 3) {
                            throw new Exception("One of the Search Words is too small! They must have more than 3 characters.");
                        }          
                        
                        //  Check if the word is already a sub-string of another inserted Search Word
                        // or if a previouslly inserted Search Word is a substring of this new Search Word
                        Set<String> keys = solutions.keySet();
                        for(String key : keys) {                            
                            // There is already a Search Word with a substring that is the same as this new word
                            if (key.contains(s)) {
                                wordAlreadyExists = true;
                            }
                            // There is already a Search Word that is a substring of this new word
                            else if (s.contains(key)) {
                                // Remove the old Search Word
                                solutions.remove(key);                                
                            }
                        }

                        //  Insert only if the new Search Word doesn't exist
                        if (!wordAlreadyExists) {
                            int[] toPut = {0, -1 ,-1, -1, 0, 0};
                            solutions.put(s, toPut);
                        }
                    }
                }     
            }

            //  Save the size of the Soup
            this.size = sizeOfCurrentLine;
        }

        //  Handle thrown exceptions
        catch(Exception e) {
            e.printStackTrace(); // print the exception
            System.out.println("There was an error in the program! Exiting...");
            System.exit(1);
        }
    }

    // Functions


    //  Check if the line is capitalized 
    // (a line can only be part of the soup if it is fully capitalized)
    private boolean lineIsFromSoup(String line) {
        return (line.equals(line.toUpperCase()));
    }


    //  Check if the line matches the required rejex and is NOT fully capitalized 
    // (a line can only be part of the Search Words if it is NOT fully capitalized and alphabetic)
    private boolean lineIsFromSearchWords(String line) {        
        return (!line.equals(line.toUpperCase()) && line.matches("[a-zA-Z\\s,;]*$"));
    }


    //  Add a line (from the input File) to the initial Soup
    private void addToGrid(String line, int x) {
        char[] arr = line.toCharArray();

        for(int y = 0;y<this.size;y++) {
            soup[x][y] = (Character) arr[y];
        }
    }

    public void addToSolutions(String word, int[] solResults) {
        solutions.put(word, solResults);
    }


    //  Get the character array that starts in the inicial coordinate 
    // and expands for the length wordLength in the Direction d
    public int[][] getWord(int[] initialPos, Direction d, int wordLength) {
        int out[][] = new int[wordLength][2];

        //  For every character in the given directory 
        for(int i = 0; i < wordLength; i++) {

            //  Check if the character is out of bounds (inside the Soup matrix)
            if (initialPos[0] + d.x * i > size || initialPos[0] + d.x * i < 0 
             || initialPos[1] + d.y * i > size || initialPos[1] + d.y * i < 0) {
                return null;
            }

            //  Add the new character to the output
            out[i] = new int[]{ initialPos[0] + d.x * i, initialPos[1] + d.y * i };
        }

        return out;
    }


    //  Return the Characters in the given Coordinates
    public String coordsToWord(int[][] coords) {
        if(coords == null) {
            return "Null coords";
        }

        StringBuilder sb = new StringBuilder();

        //  For every coordinate, append the corresponding character
        for(int[] coord: coords) {            
            sb.append(this.soup[coord[0]][coord[1]]);
        }

        return sb.toString();
    }


    //  Set the values of given coordinates in the boolean Map
    public void setMapValue(int[][] coords,boolean value) {
        for(int[] coord : coords) {
            map[coord[0]][coord[1]] = value;
        }
    }


    //  Transform the Soup Search Results to a printable String
    @Override
    public String toString() {
        StringBuffer out = new StringBuffer();

        //  Add title
        out.append("\n     ╭──────────────╮\n     │   Solution:  │\n     ╰──────────────╯\n");
        
        //  Add table header
        out.append(String.format("\n     ╭" + String.join("", Collections.nCopies(size + 3, "─")) + "┬─────┬───────┬──────────╮\n"));
        out.append(String.format("     │ %" + (size + 1) + "s │ %3s │ %2s,%2s │ %-8s │\n", "Palavra", "len", "x", "y", "Direção"));
        out.append(String.format("     ├" + String.join("", Collections.nCopies(size + 3, "─")) + "┼─────┼───────┼──────────┤\n"));

        //  For every solution
        Set<String> keys = solutions.keySet();
        for(String key : keys) {
            int[] vals = solutions.get(key);
            
            String direction = Direction.getDirection(vals[4], vals[5]);

            //  Append the Search Word, Word Length, Initial position in the Soup and Search Direction
            out.append(String.format("     │ %" + (size + 1) + "s │ %3d │ %2d,%2d │ %-8s │\n", key, vals[3], vals[1], vals[2], direction));
        }

        //  Add table close
        out.append(String.format("     ╰" + String.join("", Collections.nCopies(size + 3, "─")) + "┴─────┴───────┴──────────╯\n"));


        //  Add Soup box
        out.append(String.format("\n     ╭" + String.join("", Collections.nCopies(size*2 + 1, "─")) + "╮\n"));

        //  For every position in the Soup
        for(int x = 0; x < size; x++) {
            out.append("     │ ");
            for(int y = 0; y < size; y++) {
                //  If the position's corresponding character was in 
                // atleast one Search Word, print the character
                if(map[x][y]) {
                    out.append(soup[x][y].toString() + " ");
                } 
                //  Else print just a dash
                else {
                    out.append("- ");
                }                
            }
            out.append("│\n");
        }
        //  Close the Soup Box
        out.append(String.format("     ╰" + String.join("", Collections.nCopies(size*2 + 1, "─")) + "╯\n"));

        return out.toString();
    }
}
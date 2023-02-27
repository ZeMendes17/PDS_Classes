package T1.src.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import T1.src.solver.Direction;

public class Soup {
    //  Important class global variables
    private Integer numSearchWords;
    private Integer soupSize;
    private Character soup[][];
    ArrayList<String> SearchWords;
    ArrayList<SoupIndex> possibleCoordinates;
   

    // Simple Getters
    public Integer getSoupSize() {
        return soupSize;
    }

    public Integer getNumSearchWords() {
        return numSearchWords;
    }

    public Character[][] getSoup() {
        return soup;
    }

    public ArrayList<String> getSearchWords() {
        return SearchWords;
    }
    

    //  Constructor
    Soup(int soupSize) {
        //  Initiate the Soup array, search Word array and Coordinates array
        this.soup = new Character[soupSize][soupSize];
        this.SearchWords = new ArrayList<String>();
        this.possibleCoordinates = new ArrayList<SoupIndex>();
        this.numSearchWords = 0;
        this.soupSize = soupSize;

        startArrays();
    }

    
    // Functions

    //  Fills every empty index of the Soup with a random Character
    public void fillSoup() {
        for (int x = 0; x < this.soupSize; x++) {
            for (int y = 0; y < this.soupSize; y++) {
                if (soup[x][y] == '\0') {
                    Random r = new Random();
                    soup[x][y] = (char)(r.nextInt(25) + 'A');
                }
            }            
        }
    }


    // Empty soup and add all the coordinates to the respective array
    public void startArrays(){
        for (int x = 0; x < soupSize; x++) {
            for (int y = 0; y < soupSize; y++) {
                possibleCoordinates.add(new SoupIndex(x, y));
                soup[x][y] = '\0';
            }
        }
    }


    //  Calculate if a word fits in the space that starts in the given 
    // coordinates with the given direction and length
    private boolean wordFits(String word, int posX, int posY, Direction d, int wordLength) {
        //  For every character in the given word 
        for(int i = 0; i < wordLength; i++) {
            //  Check if the current position is out of bounds (outside the Soup matrix)
            if (posX + d.x * i >= this.soupSize || posX + d.x * i < 0 
            || posY + d.y * i >= this.soupSize || posY + d.y * i < 0) {
                return false;
            }

            //  Check if the current position is ocuppied by a character
            // that is NOT the same as the one we are trying to fit here
            if (soup[posX + d.x * i][posY + d.y * i] != '\0' && word.charAt(i) != soup[posX + d.x * i][posX + d.x * i]) {
                return false;
            }
        }
        return true;
    }
    

    //  Add a word to the Soup starting in a **Random** index and with a **Random** orientation
    public boolean addToSoup(String word) {
        //  Tranform the word into a char array and get its length
        word = word.toUpperCase();
        char[] charArr = word.toCharArray();
        int wordLength = word.length();

        //  Shuffle the list of coordinates of the Soup
        Collections.shuffle(this.possibleCoordinates);

        //  Get and shuffle a list with all the possible Directions
        List<Direction> directions = Direction.getDirectionsList(); 
        Collections.shuffle(directions);      
        
        //  For every coordinate in the coordinates array
        for (int coords = 0; coords < Math.pow(this.soupSize, 2) ; coords++) {
            
            //  Get their X and Y
            SoupIndex currIndex = possibleCoordinates.get(coords);
            int currX = currIndex.getX();
            int currY = currIndex.getY();
            int i = 0;

            //  If the current coordinate's character (in the soup) is't filled or is
            // filled with the same character as the first character of the given word
            if (this.soup[currX][currY] == '\0'  || charArr[0] == this.soup[currX][currY] ) {
                //  Iterate trough all the directions (which are ordered randomly, remember?)
                for(Direction d : directions) {
                    //  If the word fits in the current space
                    if (wordFits(word, currX, currY, d, wordLength)) {

                        //  Put the word's characters in their corresponding space
                        for(i = 0; i < wordLength; i++) {
                            
                            soup[currX + d.x * i][currY + d.y * i] = word.charAt(i); // You can't modify the soup directly first get the disired coords only then modify them, otherwise you would be overwriting previous modifications
                        }
                        this.SearchWords.add(word);
                        //  Leave
                        return true;
                    }
                }
            }
        }
        //  This method tries (**randomly**) every combination of index * direction.
        //  If we reach this line it means the word coulnd't fit anywhere on the current soup,
        // and therefore, simply doesn't work (handled by whoever calls this function)
        return false;
    }


    //  Transform the final Soup result into a printable String
    public String toPrint() {
        StringBuffer out = new StringBuffer();

        //  Add title
        out.append("\n     ╭──────────────╮\n     │   Solution:  │\n     ╰──────────────╯\n");

        //  Start the Soup box
        out.append(String.format("\n     ╭" + String.join("", Collections.nCopies(this.soupSize*2 + 1, "─")) + "╮\n"));

        //  For every position in the Soup
        for(int x = 0; x < soupSize; x++) {
            out.append("     │ ");
            for(int y = 0; y < soupSize; y++) {
                //  If the position's corresponding character was filled, print the
                // character (irrelevant if the soup was fully filled with fillSoup())
                if (this.soup[x][y] != '\0') {
                    out.append(this.soup[x][y].toString() + " ");  
                }           
                else {
                    out.append("- ");
                }
            }
            out.append("│\n");
        }
        //  Close the Soup Box
        out.append(String.format("     ╰" + String.join("", Collections.nCopies(this.soupSize*2 + 1, "─")) + "╯\n"));

        return out.toString();
    }


    //  Transform the final Soup result into a printable String
    @Override
    public String toString() {
        StringBuffer out = new StringBuffer();

        //  For every position in the Soup
        for(int x = 0; x < soupSize; x++) {
            for(int y = 0; y < soupSize; y++) {
                //  If the position's corresponding character was filled, print the
                // character (irrelevant if the soup was fully filled with fillSoup())
                if (this.soup[x][y] != '\0') {
                    out.append(this.soup[x][y].toString());  
                }           
                else {
                    out.append("-");
                }
            }
            out.append("\n");
        }
        
        return out.toString();
    }

}
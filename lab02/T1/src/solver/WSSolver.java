package lab01.src.solver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Set;
public class WSSolver {

    public static void main(String args[]){

        try {
            if (args.length != 1) {
                throw new Exception("No initial puzzle file was given!");
            }

            //  Initiate the scanner on the input file
            Scanner sc = new Scanner(new BufferedReader(new FileReader(args[0])));

            //  Initiate the Soup with the file
            Grid g = new Grid(sc);
            String output = SolveSoup(g);

            System.out.println(output + "\n");
        }
        catch(Exception e) {
            e.printStackTrace(); // print the exception
            System.out.println("There was an error in the program! Exiting...");
            System.exit(1);
        }

        
    }

    //  Find a Search Word in the Soup
    private static int[] singleSolution(String s, Grid grid) {
        String key = s;
        s = s.toUpperCase();

        int size = grid.getSize();
        int[] toPut = {0, -1, -1, -1, 0, 0};

        Character[][] soup = grid.getSoup();

        //  For every index of the soup
        for(int x = 0; x < size; x++) {
            for(int y = 0; y < size; y++) {
                
                //  If the current index starts with the same letter as the Search String
                if(soup[x][y].equals(s.charAt(0))) {

                    //  Try every direction
                    for(Direction d : Direction.values()) {

                        //  Get the character array that starts in the current position and expands in a 
                        // certain direction until the array is the same size as the search word
                        int[][] coords = grid.getWord(new int[]{x,y}, d, s.length());

                        // Compare this array with the search word
                        if(grid.coordsToWord(coords).equals(s)) {

                            //  If the search word is found, fill the boolean map with 'true'
                            // in the indexes of the found word
                            grid.setMapValue(coords,true);

                            //  Save the current position, length and direction in the solutions array
                            toPut[0] = 1;
                            toPut[1] = x;
                            toPut[2] = y;
                            toPut[3] = s.length();
                            toPut[4] = d.y;
                            toPut[5] = -d.x;
                        } 
                    }
                }
            }
        }

        return toPut;
    }

    //  Run through the Search Words, find them in the Soup and garante every single one is found
    public static String SolveSoup(Grid grid) {

        Set<String> solutionKeys = grid.getSolutions();

        try {
            //  For every Search Word, try to solve it
            for(String solWord : solutionKeys) {
                grid.addToSolutions(solWord, singleSolution(solWord, grid));
            }
            
            //  If a Search Word wasn't marked as found (value[0] != 1),
            // throw an error, since all Seach Words must be found in the Soup
            for(String key : solutionKeys) {
                if (grid.getSolutionByKey(key)[0]==0) {
                    System.out.println(String.format("%s not found", key));
                    throw new Exception("One of the Search Words wasn't in the Soup!");
                }
            }
        }

        //  Handle the thrown exceptions
        catch (Exception e) {
            e.printStackTrace(); // print the exception
            System.out.println("There was an error in the program! Exiting...");
            System.exit(1);
        }
        
        return grid.toString();
    }
}

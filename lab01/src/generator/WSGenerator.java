package src.generator;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import src.solver.ReadData;

public class WSGenerator {
    // generates Word Search using a file that contains the words
    // that is obtained in the command line using -i
    // should contain a size, -s
    // and may have a destination file given by -o

    public static void main(String[] args) {
        RandomGenerator rand = new RandomGenerator();

        // this is a message to be printed out if something goes wrong
        String errorMessage = "No arguments passed\n"+
            "Must have a file with the words, passed using -i\n"+
            "Must have the size for the Word Search (it is square), passed using -s\n"+
            "Optional: A destination file, passed using -o";

            // if it has no args or to many, it ends
        if(args.length == 0 || args.length > 6){
            System.err.println(errorMessage);
            return;
        }

        // this vars will say if the flags are there and in which position they`re in
        int i_flag = -1;
        int s_flag = -1;
        int o_flag = -1;
        int count = 0;
        
        // checks if which flags were inputed by the user
        for(String s : args){
            if(s.equals("-i"))
                i_flag = count;
            if(s.equals("-s"))
                s_flag = count;
            if(s.equals("-o"))
                o_flag = count;

            count++;
        }

        // if the -i and -s parameters were not inputed then it gives an error
        // this flags are mandatory (the -o is optional)
        if(i_flag == -1 || s_flag == -1){
            System.err.println(errorMessage);
            return;
        }

        // variables from the input -i, -s and -o
        String sourceFileString = "";
        String destinationFileString = "";
        int wsSize = -1;

        // puts the input values into the variables so they can be used later on
        try {
            if(!args[i_flag+1].contains("-") || !args[s_flag+1].contains("-")){
                sourceFileString = args[i_flag+1];
                wsSize = Integer.parseInt(args[s_flag+1]);
            } else{
                System.out.println(errorMessage);
                System.out.println("Invalid arguments");
            }

            if(o_flag == -1){
                if(args.length > 4){
                    System.out.println(errorMessage);
                    System.out.println("Incorrect number of arguments");
                    return;
                }
            }
            else if(o_flag != -1 && !args[o_flag+1].contains("-")){
                destinationFileString = args[o_flag+1];
            } else{
                System.out.println(errorMessage);
            }

        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println(errorMessage);
            // System.out.println("You have too many arguments, please correct them!");
            return;
        }

        // gets the words form the file and orders them
        File sourceFile = new File(sourceFileString);
        ReadData data = new ReadData();
        Order order = new Order();
        List<String> unorderedWords = data.readWords(sourceFile, 0);
        List<String> words = order.orderWords(unorderedWords);

        // the WS to be filled
        char[][] wordSearch = new char[wsSize][wsSize];

        // flags for the directions, x and y coordenates from the WS
        // i to be used in loop
        int x, y, i;
        int right_flag = 0;
        int left_flag = 0;
        int up_flag = 0;
        int down_flag = 0;
        int found_flag = 0; // indicates if the word as been found
        int rand_direction, position_count_x, position_count_y; // new coordenates and the next positions

        // for each word to be put in the WS, chooses a random position and direction
        // and finally checks if it can be there
        for(String word : words){
            count = 0;
            while(true){
                // if it cannot be fitted in the WS after 100 tries then it is not possible
                if(count <= 100){
                    System.out.println("It is impossible with the given data");
                    return;
                }
                int wordSize = word.length();
                List<Integer> possibleDirections = new ArrayList<>();
                // coords of the position of the first letter
                x = rand.generateRand(wsSize-1);
                y = rand.generateRand(wsSize-1);

                // if it can go to the right
                if(x + wordSize <= wsSize){
                    possibleDirections.add(2);
                    right_flag = 1;
                }
                // if it can go to the left
                if(x - wordSize+1 >= 0){
                    possibleDirections.add(6);
                    left_flag = 1;
                }
                // if it can go up
                if(y - wordSize+1 >= 0){
                    possibleDirections.add(0);
                    up_flag = 1;
                }
                // if it can go down
                if(y + wordSize <= wsSize){
                    possibleDirections.add(4);
                    down_flag = 1;
                }

                if(right_flag == 1 && up_flag == 1) // if it can go up and right then it can go UpRight
                    possibleDirections.add(1);
                if(right_flag == 1 && down_flag == 1) // if it can right and down then it can go DownRight
                    possibleDirections.add(3);
                if(left_flag == 1 && up_flag == 1) // if it can go left and up then it can go UpLeft 
                    possibleDirections.add(7);
                if(left_flag == 1 && down_flag == 1) // if it can go left and down then it can go DownLeft
                    possibleDirections.add(5);

                // if it cant go in any direction then it has to try again
                if(possibleDirections.isEmpty()){
                    count++;
                    continue;
                } else{
                    while(true){
                        // se ja nao tem mais possiveis direções para ir sai do while
                        if(possibleDirections.isEmpty()){
                            right_flag = 0;
                            left_flag = 0;
                            up_flag = 0;
                            down_flag = 0;
                            break;
                        }
                        // gets a random direction from the list of directions
                        rand_direction = rand.getRandomNumbFromList(possibleDirections);

                        position_count_x = x;
                        position_count_y = y;

                        // if the char from the word that we want to insert is already ocupied and it is not equal to this one
                        // then it cant be inserted
                        for(i = 0; i < wordSize; i++){
                            if(wordSearch[position_count_x][position_count_y] != '\0' && wordSearch[position_count_x][position_count_y] != word.charAt(i)){
                                right_flag = 0;
                                left_flag = 0;
                                up_flag = 0;
                                down_flag = 0;
                                possibleDirections.remove(possibleDirections.indexOf(rand_direction));
                                break;
                            }

                            // dependending on the direction, it changes the coordenates for the next position
                            if(rand_direction == 7 || rand_direction == 0 || rand_direction == 1)
                                position_count_y--;
                            if(rand_direction == 1 || rand_direction == 2 || rand_direction == 3)
                                position_count_x++;
                            if(rand_direction == 3 || rand_direction == 4 || rand_direction == 5)
                                position_count_y++;
                            if(rand_direction == 5 || rand_direction == 6 || rand_direction == 7)
                                position_count_x--;
                        }
                        // if the word can be inserted then we have to do it
                        if(i >= wordSize){
                            position_count_x = x;
                            position_count_y = y;
                            for(i = 0; i < wordSize; i++){
                                wordSearch[position_count_x][position_count_y] = word.toUpperCase().charAt(i);

                                if(rand_direction == 7 || rand_direction == 0 || rand_direction == 1)
                                    position_count_y--;
                                if(rand_direction == 1 || rand_direction == 2 || rand_direction == 3)
                                    position_count_x++;
                                if(rand_direction == 3 || rand_direction == 4 || rand_direction == 5)
                                    position_count_y++;
                                if(rand_direction == 5 || rand_direction == 6 || rand_direction == 7)
                                    position_count_x--;
                            }
                            // resets the flags for the next word
                            found_flag = 1;
                            right_flag = 0;
                            left_flag = 0;
                            up_flag = 0;
                            down_flag = 0;
                            break;
                        }
                    }
                    if(found_flag == 1){ // if the word has been found then we break the loop to
                        found_flag = 0;  // go to the next one
                        break;
                    }
                }
            }
        }
        // prints the WS to the terminal
        PrintGeratedWS pWs = new PrintGeratedWS();
        pWs.print(wordSearch, sourceFile);

        // writes the WS to file
        if(!destinationFileString.equals("")){
            pWs.printToFile(wordSearch, sourceFile, destinationFileString);
        }

    }
}

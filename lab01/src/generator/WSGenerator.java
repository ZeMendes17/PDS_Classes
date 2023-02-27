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

        String errorMessage = "No arguments passed\n"+
            "Must have a file with the words, passed using -i\n"+
            "Must have the size for the Word Search (it is square), passed using -s\n"+
            "Optional: A destination file, passed using -o";

        if(args.length == 0 || args.length > 6){
            System.out.println(errorMessage);
            return;
        }

        // this vars will say if the flags are there and in which position they`re in
        int i_flag = -1;
        int s_flag = -1;
        int o_flag = -1;
        int count = 0;
        
        for(String s : args){
            if(s.equals("-i"))
                i_flag = count;
            if(s.equals("-s"))
                s_flag = count;
            if(s.equals("-o"))
                o_flag = count;

            count++;
        }

        if(i_flag == -1 || s_flag == -1){
            System.out.println(errorMessage);
            return;
        }

        String sourceFileString = "";
        String destinationFileString = "";
        int wsSize = -1;

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

        File sourceFile = new File(sourceFileString);
        ReadData data = new ReadData();
        Order order = new Order();
        List<String> unorderedWords = data.readWords(sourceFile, 0);
        List<String> words = order.orderWords(unorderedWords);

        char[][] wordSearch = new char[wsSize][wsSize];

        int x, y, i;
        int right_flag = 0;
        int left_flag = 0;
        int up_flag = 0;
        int down_flag = 0;
        int found_flag = 0;
        int rand_direction, position_count_x, position_count_y;
        for(String word : words){
            count = 0;
            while(true){
                if(count == 1000){
                    System.out.println("It is impossible with the given data");
                    return;
                }
                int wordSize = word.length();
                List<Integer> possibleDirections = new ArrayList<>();
                // coords of the position of the first letter
                x = rand.generateRand(wsSize-1);
                y = rand.generateRand(wsSize-1);

                if(x + wordSize <= wsSize){
                    possibleDirections.add(2);
                    right_flag = 1;
                }
                if(x - wordSize+1 >= 0){
                    possibleDirections.add(6);
                    left_flag = 1;
                }
                if(y - wordSize+1 >= 0){
                    possibleDirections.add(0);
                    up_flag = 1;
                }
                if(y + wordSize <= wsSize){
                    possibleDirections.add(4);
                    down_flag = 1;
                }

                if(right_flag == 1 && up_flag == 1)
                    possibleDirections.add(1);
                if(right_flag == 1 && down_flag == 1)
                    possibleDirections.add(3);
                if(left_flag == 1 && up_flag == 1)
                    possibleDirections.add(7);
                if(left_flag == 1 && down_flag == 1)
                    possibleDirections.add(5);

                if(possibleDirections.isEmpty()){
                    count++;
                    continue;
                } else{
                    while(true){
                        if(possibleDirections.isEmpty()){
                            right_flag = 0;
                            left_flag = 0;
                            up_flag = 0;
                            down_flag = 0;
                            break;
                        }
                        rand_direction = rand.getRandomNumbFromList(possibleDirections);
                        // tem de ver se o local onde pertende colocar as palavras nao esta ocupado

                        position_count_x = x;
                        position_count_y = y;
                        for(i = 0; i < wordSize; i++){
                            if(wordSearch[position_count_x][position_count_y] != '\0' && wordSearch[position_count_x][position_count_y] != word.charAt(i)){
                                right_flag = 0;
                                left_flag = 0;
                                up_flag = 0;
                                down_flag = 0;
                                possibleDirections.remove(possibleDirections.indexOf(rand_direction));
                                break;
                            }

                            if(rand_direction == 7 || rand_direction == 0 || rand_direction == 1)
                                position_count_y--;
                            if(rand_direction == 1 || rand_direction == 2 || rand_direction == 3)
                                position_count_x++;
                            if(rand_direction == 3 || rand_direction == 4 || rand_direction == 5)
                                position_count_y++;
                            if(rand_direction == 5 || rand_direction == 6 || rand_direction == 7)
                                position_count_x--;
                        }
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
                            found_flag = 1;
                            right_flag = 0;
                            left_flag = 0;
                            up_flag = 0;
                            down_flag = 0;
                            break;
                        }
                    }
                    if(found_flag == 1){
                        found_flag = 0;
                        break;
                    }
                }
            }
        }
        // print
        PrintGeratedWS pWs = new PrintGeratedWS();
        pWs.print(wordSearch, sourceFile);

        // write to file
        if(!destinationFileString.equals("")){
            pWs.printToFile(wordSearch, sourceFile, destinationFileString);
        }

    }
}

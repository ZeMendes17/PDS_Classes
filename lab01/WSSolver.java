import java.io.File;
import java.util.List;

public class WSSolver{
    public static void main(String[] args) throws Exception {

        Verification verify = new Verification();
        ReadData data = new ReadData();
        File file;
        
        // read file
        try {
            file = new File(args[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Não foi introduzido um ficheiro");
            return;
        }

        // validates both WS and the words
        boolean validateWS = verify.validateWordSearch(file);
        boolean validateWords = verify.validateWords(file);
        if(!validateWS || !validateWords)
            return;
        
        // gets the WS and the words
        List<String> words = data.readWords(file, 1);
        char[][] wordSearch = data.readWordSearch(file);

        // for(char[] c : wordSearch){ // prints the base WS
        //     for(char cc : c)
        //         System.out.print(cc + " ");
        //     System.out.println();
        // }

        // solves the WS
        Solution solution = new Solution(wordSearch, words);
        List<Word> result = solution.solve(wordSearch, words);

        // prints out the solved WS
        PrintWS printResult = new PrintWS(result, wordSearch);
        printResult.print();

    }
}

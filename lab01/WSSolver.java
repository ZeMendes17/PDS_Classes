import java.io.File;
import java.util.List;

public class WSSolver{
    public static void main(String[] args) throws Exception {
        // String[] words =  {"Up", "Down", "Left", "Right", "UpLeft", "UpRight", "DownLeft", "DownRight"};
        // int i;
        Verification verify = new Verification();
        ReadData data = new ReadData();
        File file;
        
        try {
            file = new File(args[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Não foi introduzido um ficheiro");
            return;
        }

        boolean validateWS = verify.validateWordSearch(file);
        boolean validateWords = verify.validateWords(file);
        if(!validateWS || !validateWords)
            return;
        
        List<String> words = data.readWords(file);
        for(String s : words) // remover depois, apenas para teste
            System.out.println(s);
        System.out.println("\n");

        char[][] wordSearch = data.readWordSearch(file);
        for(char[] c : wordSearch){ // remover depois, apenas para teste
            for(char cc : c)
                System.out.print(cc + " ");
            System.out.println();
        }




    }

        // try {
        //     System.out.println("Palavra " + words[20]);
        // } catch (ArrayIndexOutOfBoundsException e) {
        //     System.out.println("Fora do array");
        // }

}

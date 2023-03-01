package src.generator;
import java.util.ArrayList;
import java.util.List;

public class Order {
    // this class is for ordering 

    // returns a list in which it goes from the biggest to the smallest
    public List<String> orderWords(List<String> words){
        List<String> result = new ArrayList<>();
        String biggest = "";

        // goes through all the words to determine the one with the highest length
        // adds it to the list to return and removes it from the original
        while(!words.isEmpty()){
            for(String s : words)
                if(s.length() > biggest.length())
                    biggest = s;

            words.remove(biggest);
            result.add(biggest);
            biggest = "";
        }

        return result;
    }
}

import java.util.ArrayList;
import java.util.List;

public class Order {
    // this class is for ordering 

    public List<String> orderWords(List<String> words){
        List<String> result = new ArrayList<>();
        String biggest = "";

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

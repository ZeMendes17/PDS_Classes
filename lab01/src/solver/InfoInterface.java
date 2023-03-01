package src.solver;
import java.io.File;
import java.util.List;

// this interface is used to get the WS and the words
public interface InfoInterface {
    // gets the WS and stores it in a char multidimensional array
    public char[][] readWordSearch(File f);
    // gets the words abd stores them in a list
    public List<String> readWords(File f, int hasWS);
}

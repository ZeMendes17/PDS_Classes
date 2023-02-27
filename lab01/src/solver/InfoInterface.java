package src.solver;
import java.io.File;
import java.util.List;

public interface InfoInterface {
    public char[][] readWordSearch(File f);
    public List<String> readWords(File f, int hasWS);
}

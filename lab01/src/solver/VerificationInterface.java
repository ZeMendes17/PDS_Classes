package src.solver;
import java.io.File;

// This interface is used to validate the input files
public interface VerificationInterface {
    // Validates the word search 
    public boolean validateWordSearch(File f);
    // Validates the words
    public boolean validateWords(File f);
}

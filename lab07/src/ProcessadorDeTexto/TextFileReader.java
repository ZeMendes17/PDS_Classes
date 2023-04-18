package src.ProcessadorDeTexto;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextFileReader implements ReaderInterface {
    private File file;
    private BufferedReader bufferedReader;
    private String currentParagraph;

    // constructor
    public TextFileReader(String fileName) {
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            currentParagraph = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // interface methods
    @Override
    public boolean hasNext() {
        return currentParagraph != null;
    }

    @Override
    public String next() {
        String paragraph = currentParagraph;
        try {
            currentParagraph = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return paragraph;
    }

    //getter
    public File getFile(){ return file; }

    //setter
    public void setFile(File f){ this.file = f; }

    @Override
    public String toString(){
        return "Reading file: " + file;
    }
    
}

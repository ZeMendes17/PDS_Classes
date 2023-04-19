package src.ProcessadorDeTexto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextFileReader implements ReaderInterface {
    private File file;
    private int currentParagraph;

    // constructor
    public TextFileReader(String fileName) {
        try {
            this.file = new File(fileName);
            this.currentParagraph = 0;
        } catch (Exception e) {
            System.err.println("File not found");
            System.exit(1);
        }
    }

    // interface methods
    @Override
    public boolean hasNext() {

        try {
            Scanner sc = new Scanner(file);
            for (int i = 0; i < this.currentParagraph; i++) {
                // reads to the paragraph where we were
                sc.nextLine();
            }

            if (sc.hasNextLine()) {
                sc.close();
                return true;
            }

            sc.close();
            return false;
        } catch (FileNotFoundException e) {
            System.err.println("Not able to read File");
            return false;
        }
    }

    @Override
    public String next() {

        try {
            Scanner sc = new Scanner(file);

            for (int i = 0; i < currentParagraph; i++) {
                // reads to where we were
                sc.nextLine();
            }

            if (sc.hasNextLine()) {
                String res = sc.nextLine();
                this.currentParagraph++;
                sc.close();
                return res;
            }

            sc.close();
            return null;
        } catch (Exception e) {
            System.err.println("Not able to read File");
            return null;
        }
    }

    //getters
    public File getFile(){ return file; }
    public int getCurrentParagraph(){ return currentParagraph; }

    //setters
    public void setFile(File f){ this.file = f; }
    public void setCurrenrParagraph(int paragraph){ this.currentParagraph = paragraph; }

    @Override
    public String toString(){
        return "Reading file: " + file;
    }
    
}

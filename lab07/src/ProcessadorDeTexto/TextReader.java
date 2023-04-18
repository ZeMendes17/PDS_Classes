package src.ProcessadorDeTexto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextReader implements ReaderInterface {

    File file;
    Scanner sc;

    //constructor
    public TextReader(File f){
        this.file = f;
        try {
            sc = new Scanner(f);
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
            System.exit(1);
        }
    }

    //getter
    public File getFile(){ return file; }

    //setter
    public void setFile(File f){ this.file = f; }

    @Override
    public String toString(){
        return "Reading file: " + file;
    }


    // interface methods
    @Override
    public boolean hasNext() {
        return sc.hasNext();
    }

    @Override
    public String next() {
        String ret = sc.next();
        if(!ret.isEmpty())
            return ret;
        System.out.println("File does not have any more lines");
        return null;
    }
    
}

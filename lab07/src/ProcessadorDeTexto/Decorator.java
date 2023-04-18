package src.ProcessadorDeTexto;

public class Decorator implements ReaderInterface {
    protected ReaderInterface r;

    // constructor
    public Decorator(ReaderInterface r){
        this.r = r;
    }
    
    //interface methods
    @Override
    public boolean hasNext() {
        return r.hasNext();
    }

    @Override
    public String next() {
        return r.next();
    }

}
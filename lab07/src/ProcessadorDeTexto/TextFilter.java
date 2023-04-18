package src.ProcessadorDeTexto;

abstract class TextFilter implements ReaderInterface {
    protected ReaderInterface r;

    // constructor
    public TextFilter(ReaderInterface r){
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
package src.PagaLeva;

// class that represents a termic bottle
public class TermicBottle implements Container {
    public Portion p;

    // constructor
    protected TermicBottle(Portion p){
        this.p = p;
    }

    // factory method
    
    @Override
    public Portion getPortion() {
        return p;
    }

    @Override
    public String toString(){
        return "TermicBottle with portion = " + p.toString();
    }
}

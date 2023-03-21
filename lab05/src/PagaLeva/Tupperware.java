package src.PagaLeva;

// class that represents a tupperware
public class Tupperware implements Container {
    public Portion p;

    // constructor
    protected Tupperware(Portion p){
        this.p = p;
    }

    // factory method
    
    @Override
    public Portion getPortion() {
        return p;
    }

    @Override
    public String toString(){
        return "Tupperware with portion = " + p.toString();
    }
}

package src.PagaLeva;

// class that represents a plastic bag
public class PlasticBag implements Container {
    public Portion p;

    // constructor
    protected PlasticBag(Portion p){
        this.p = p;
    }

    // factory method
    
    @Override
    public Portion getPortion() {
        return p;
    }

    @Override
    public String toString(){
        return "PlasticBag with portion = " + p.toString();
    }
}

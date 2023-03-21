package src.PagaLeva;

// class that represents a plastic bottle
public class PlasticBottle implements Container {
    public Portion p;

    // constructor
    protected PlasticBottle(Portion p){
        this.p = p;
    }

    // factory method
    
    @Override
    public Portion getPortion() {
        return p;
    }

    @Override
    public String toString(){
        return "PlasticBottle with portion = " + p.toString();
    }
}

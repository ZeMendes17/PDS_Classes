package src.PagaLeva;

public class PlasticBottle implements Container {
    public Portion p;

    protected PlasticBottle(Portion p){
        this.p = p;
    }

    @Override
    public Portion getPortion() {
        return p;
    }

    @Override
    public String toString(){
        return "PlasticBottle with portion = " + p.toString();
    }
}

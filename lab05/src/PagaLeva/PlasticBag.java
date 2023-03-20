package src.PagaLeva;

public class PlasticBag implements Container {
    public Portion p;

    protected PlasticBag(Portion p){
        this.p = p;
    }

    @Override
    public Portion getPortion() {
        return p;
    }

    @Override
    public String toString(){
        return "PlasticBag with portion = " + p.toString();
    }
}

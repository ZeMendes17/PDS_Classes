package src.PagaLeva;

public class Tupperware implements Container {
    public Portion p;

    protected Tupperware(Portion p){
        this.p = p;
    }

    @Override
    public Portion getPortion() {
        return p;
    }

    @Override
    public String toString(){
        return "Tupperware with portion = " + p.toString();
    }
}

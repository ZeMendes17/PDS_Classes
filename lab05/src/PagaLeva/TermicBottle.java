package src.PagaLeva;

public class TermicBottle implements Container {
    public Portion p;

    protected TermicBottle(Portion p){
        this.p = p;
    }

    @Override
    public Portion getPortion() {
        return p;
    }

    @Override
    public String toString(){
        return "TermicBottle with portion = " + p.toString();
    }
}

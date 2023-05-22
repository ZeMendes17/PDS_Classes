package lab11.src.ex1;

import java.util.List;

public class Revista {
    
    private Strategy strat;

    public Revista(Strategy  strat) {
        this.strat = strat;
    }

    public List<Phone> sort(List<Phone> phones) {
        return strat.sort(phones);
    }   

    public void setStrategy(Strategy strat) {
        this.strat = strat;
    }
}

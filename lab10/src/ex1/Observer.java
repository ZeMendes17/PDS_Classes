package ex1;

import java.util.ArrayList;
import java.util.List;

public abstract class Observer {
    // the product in question
    protected List<Produto> products;
    protected String name;

    public Observer(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }
    
    // method use to update observers state
    public abstract void update(String statusMesage);  

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

package ex1;

import java.util.ArrayList;
import java.util.List;

public class Produto {
    private int productCode;
    private static int numberProducts = 0;
    private String description;
    private double price;
    private double highestBid;
    private ProdutoStatus status;
    private List<Observer> observers;
    private Observer highestBidder;

    public Produto(String description, double price) {
        this.description = description;
        this.price = price;
        this.highestBid = price;
        this.productCode = ++numberProducts;
        this.status = ProdutoStatus.STOCK;
        this.observers = new ArrayList<>();
        this.highestBidder = null;
    }

    public void attach(Observer o) {
        observers.add(o);
    }

    public ProdutoStatus getState() {
        return status;
    }

    public void setState(ProdutoStatus ps) {
        this.status = ps;
        // notifyObservers("State of the product has changed");
    }

    public void notifyObservers(String statusMesage) {
        for (Observer obs : observers)
            obs.update(statusMesage);
    }

    public boolean bidding(double bid, Observer obs) {
        if(status == ProdutoStatus.LEILAO) {
            if(!observers.contains(obs))
                attach(obs);

            if(bid > highestBid) {
                this.highestBid = bid;
                this.highestBidder = obs;
                notifyObservers("A new highest bid has been placed under '" +  getDescription() + "'. Value of: " + bid + " euros.");
                return true;
            }
            obs.update("Your bid is lower than the one placed. If you want to be a candidate in '" +  getDescription() + "' go higher!");
            return false;
        }
        obs.update("Can't place bid on this product right now");
        return false;
    }


    // setters
    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setStatus(ProdutoStatus status) {
        this.status = status;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }

    // getters
    public int getProductCode() {
        return productCode;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public ProdutoStatus getStatus() {
        return status;
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public double getHighestBid() {
        return highestBid;
    }

    public Observer getHighestBidder() {
        return highestBidder;
    }
}
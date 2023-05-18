package ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class Gestor extends Observer {

    private List<Produto> stock;
    private List<Produto> auction;
    private List<Produto> sold;
    private Timer timer;

    public Gestor(String name) {
        super(name);
        this.auction = new ArrayList<>();
        this.stock = new ArrayList<>();
        this.sold = new ArrayList<>();
    }

    public void startAuction(int time, Produto product) {
        this.timer = new Timer();

        if(product.getState() == ProdutoStatus.STOCK){
            product.setState(ProdutoStatus.LEILAO);

            if(stock.contains(product))
                stock.remove(product);
            if(!auction.contains(product))
                auction.add(product);

            product.attach(this);
            timer.schedule(new TimeOutTask(this, timer, product), time);
        } else {
            System.out.println("Product '" +  product.getDescription() + "' is not for auction.");
        }
    }

    public void endAuction(Produto product) {
        if(product.getHighestBidder() == null) {
            product.notifyObservers("Product '" + product.getDescription() + "' has not been sold.");
            product.setState(ProdutoStatus.STOCK);

            if(auction.contains(product))
                auction.remove(product);
            if(!stock.contains(product))
                stock.add(product);
        } else {
            product.notifyObservers("Product '" +  product.getDescription() + "' sold to " + product.getHighestBidder().getName() + ". Value of: " + product.getHighestBid());
            product.setState(ProdutoStatus.VENDAS);

            if(auction.contains(product))
                auction.remove(product);
            if(!sold.contains(product))
                sold.add(product);
        }
    }

    @Override
    public void update(String statusMesage) {
        System.out.println("[MANAGER: " + getName() + "] -> " + statusMesage);
    }
}
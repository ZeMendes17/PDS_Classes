package ex1;

public class Cliente extends Observer{

    public Cliente(String name) {
        super(name);
    }

    public boolean bid(Produto product, double bid) {
        if(!(product.getState() == ProdutoStatus.LEILAO)) {
            update("Product can't be bid on.");
            return false;
        }
        product.bidding(bid, this);
        return true;
    }
    
    @Override
    public void update(String statusMesage) {
        System.out.println("[" + getName() + "] -> " + statusMesage);
    }
}
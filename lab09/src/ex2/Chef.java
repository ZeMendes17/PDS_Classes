package ex2;

public abstract class Chef {
    private Chef successor = null;

    public void cook(String order){
        if(successor != null){
            successor.cook(order);
        } else {
            System.out.println("We're sorry but that request can't be satisfied by our service!");
        }
    }

    protected boolean canHandleCook(String order, String food) {
        return order == null || order.toLowerCase().contains(food.toLowerCase());
    }

    public Chef setSuccessor(Chef successor) {
        this.successor = successor;
        return this;
    }
}
package ex2;

public class PastaChef extends Chef {

    @Override
    public void cook(String order) {
        if(canHandleCook(order, "pasta")) {
            System.out.println("PastaChef: Starting to cook "+ order + ". Out in 14 minutes!");
        } else {
            System.out.println("PastaChef: I can't cook that.");
            super.cook(order);
        }
    }
}
package ex2;

public class SushiChef extends Chef {

    @Override
    public void cook(String order) {
        if(canHandleCook(order, "sushi")) {
            System.out.println("SushiChef: Starting to cook "+ order + ". Out in 14 minutes!");
        } else {
            System.out.println("SushiChef: I can't cook that.");
            super.cook(order);
        }
    }
}
package ex2;

public class PizzaChef extends Chef {

    @Override
    public void cook(String order) {
        if(canHandleCook(order, "pizza")) {
            System.out.println("PizzaChef: Starting to cook "+ order + ". Out in 7 minutes!");
        } else {
            System.out.println("PizzaChef: I can't cook that.");
            super.cook(order);
        }
    }
}
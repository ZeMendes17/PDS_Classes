package ex2;

public class BurgerChef extends Chef {

    @Override
    public void cook(String order) {
        if(canHandleCook(order, "burger")) {
            System.out.println("BurgerChef: Starting to cook "+ order + ". Out in 19 minutes!");
        } else {
            System.out.println("BurgerChef: I can't cook that.");
            super.cook(order);
        }
    }
}
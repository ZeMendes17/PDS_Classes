package ex2;

public class DessertChef extends Chef {

    @Override
    public void cook(String order) {
        if(canHandleCook(order, "dessert")) {
            System.out.println("DessertChef: Starting to cook "+ order + ". Out in 17 minutes!");
        } else {
            System.out.println("DessertChef: I can't cook that.");
            super.cook(order);
        }
    }
}
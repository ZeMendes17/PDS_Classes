package ex2;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<String> orders = new ArrayList<>();
        String food;

        orders.add("Can I please get a veggie burger?");
        orders.add("Can I please get a Pasta Carbonara?");
        orders.add("Can I please get a PLAIN pizza, no toppings!?");
        orders.add("Can I please get a sushi nigiri and sashimi?");
        orders.add("Can I please get a salad with tuna?");
        orders.add("Can I please get a strawberry ice cream and waffles dessert?");

        Chef chef = new SushiChef().setSuccessor(
            new PastaChef().setSuccessor(
                new BurgerChef().setSuccessor(
                    new PizzaChef().setSuccessor(
                        new DessertChef()
                    )
                )
            )
        );

        for(String order : orders) {
            System.out.println(order);
            food = order.replace("Can I please get a ", "").replace("?", "");
            chef.cook(food);
            System.out.println();
        }
    }
}

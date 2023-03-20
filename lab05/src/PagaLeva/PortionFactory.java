package src.PagaLeva;

public class PortionFactory {
    public static Portion create(String meal, Temperature temperature) {
        if (meal.equalsIgnoreCase("Meat") && temperature.equals(Temperature.WARM)) { 
            return new Pork();
        }
        
        if (meal.equalsIgnoreCase("Meat") && temperature.equals(Temperature.COLD)) { 
            return new Tuna();
        }        

        if (meal.equalsIgnoreCase("Beverage") && temperature.equals(Temperature.WARM)){
            return new Milk();
        }
        if (meal.equalsIgnoreCase("Beverage") && temperature.equals(Temperature.COLD)){
            return new FruitJuice();
        }

        else 
            throw new IllegalArgumentException(meal+" não existente!");
    }
}

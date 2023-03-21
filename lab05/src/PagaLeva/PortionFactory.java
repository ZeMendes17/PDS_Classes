package src.PagaLeva;

// factory class
public class PortionFactory {

    // factory method to create portions
    public static Portion create(String meal, Temperature temperature) {

        // wich portion to create? 
        // if meal is "Meat" and temperature is "WARM" create a Pork
        if (meal.equalsIgnoreCase("Meat") && temperature.equals(Temperature.WARM)) { 
            return new Pork();
        }
        
        // same logic for the other portions
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

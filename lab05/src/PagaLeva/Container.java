package src.PagaLeva;

import java.util.Random;

// interface that represents a container
public interface Container {

    public Portion getPortion();

    // factory method
    public static Container create(Portion portion) {

        // choose a container based on the portion

        // if the portion is solid and cold, choose a plastic bag or a tupperware with 50% probability
        if (portion.getState() == State.Solid && portion.getTemperature() == Temperature.COLD)  {
            int rand = new Random().nextInt(2);
            if(rand == 0)
                return new PlasticBag(portion);
            else
                return new Tupperware(portion);
        }
        
        // same as above for the other cases
        
        if (portion.getState() == State.Solid && portion.getTemperature() == Temperature.WARM)  {
            return new Tupperware(portion);
        }

        if (portion.getState() == State.Liquid && portion.getTemperature() == Temperature.WARM)  {
            return new TermicBottle(portion);
        }

        if (portion.getState() == State.Liquid && portion.getTemperature() == Temperature.COLD)  {
            int rand = new Random().nextInt(2);
            if(rand == 0)
                return new PlasticBottle(portion);
            else
                return new TermicBottle(portion);
        }

        else 
            throw new IllegalArgumentException(portion+" não existente!");
    }
}

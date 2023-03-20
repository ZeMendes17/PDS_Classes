package src.PagaLeva;

import java.util.Random;

public interface Container {

    public Portion getPortion();

    public static Container create(Portion portion) {
        if (portion.getState() == State.Solid && portion.getTemperature() == Temperature.COLD)  {
            int rand = new Random().nextInt(2);
            if(rand == 0)
                return new PlasticBag(portion);
            else
                return new Tupperware(portion);
        }
        
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

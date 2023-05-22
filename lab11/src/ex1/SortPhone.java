package lab11.src.ex1;

import java.util.Comparator;

public class SortPhone implements Comparator<Phone> {

    @Override
    public int compare(Phone phone1, Phone phone2) {
        int modelComp = phone1.getModel().compareTo(phone2.getModel());

        if(modelComp != 0)
            return modelComp;

        int processorComp = phone1.getProcessor().compareTo(phone2.getProcessor());

        if(processorComp != 0)
            return processorComp;

        double priceComp = Double.compare(phone1.getPrice(), phone2.getPrice());

        if(priceComp != 0)
            return (int) priceComp;

        int storageComp = phone1.getStorage().compareTo(phone2.getStorage());

        if(storageComp != 0)
            return storageComp;

        int cameraComp = phone1.getCamera().compareTo(phone2.getCamera());

        return cameraComp;
    }
    
}

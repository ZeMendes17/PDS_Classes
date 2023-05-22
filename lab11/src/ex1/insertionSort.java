package lab11.src.ex1;

import java.util.List;
import java.util.Collections;

public class insertionSort implements Strategy {

    @Override
    public List<Phone> sort(List<Phone> phone) {
        System.out.println("Sorting with insertion sort:");
        // sort
        Collections.sort(phone, new SortPhone());
        return phone;
    }
}
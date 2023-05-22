package lab11.src.ex1;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Phone> phones = new ArrayList<>();
        phones.add(new Phone("Samsung Galaxy S21 Ultra", "Qualcomm Snapdragon 888", 1.199, "256GB", "Quad-camera setup with a 108MP main camera, 12MP ultra-wide camera, and two 10MP telephoto cameras"));
        phones.add(new Phone("Samsung Galaxy S21 Ultra", "Samsung Exynos 2200", 1.199, "256GB", "Quad-camera setup with a 108MP main camera, 12MP ultra-wide camera, and two 10MP telephoto cameras"));
        phones.add(new Phone("iPhone 13 Pro Max", "Apple A15 Bionic", 1.099, "128GB", "Triple-camera system with a 12MP main camera, 12MP ultra-wide camera"));
        phones.add(new Phone("iPhone 13 Pro Max", "Apple A15 Bionic", 1.199, "256GB", "Triple-camera system with a 12MP main camera, 12MP ultra-wide camera"));
        phones.add(new Phone("Google Pixel 6 Pro", "Google Tensor", 899, "128GB", "Dual-camera setup with a 50MP main camera and a 12MP ultra-wide camera"));

        Revista r = new Revista(new bubbleSort());
        r.sort(phones);
        for(Phone p: phones) 
            System.out.println(p);

        r.setStrategy(new mergeSort());
        r.sort(phones);
        for(Phone p: phones) 
            System.out.println(p);

        r.setStrategy(new insertionSort());
        r.sort(phones);
        for(Phone p: phones) 
            System.out.println(p);
    }
}

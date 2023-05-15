package ex1;

import java.util.ListIterator;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        VectorGeneric<String> vector = new VectorGeneric<>();
        vector.addElem("António");
        vector.addElem("Maria");
        vector.addElem("João");
        vector.addElem("Miguel");

        System.out.println("Vector elements:");
        for (String element : vector) {
            System.out.println(element);
        }

        Iterator<String> iterator1 = vector.iterator();
        ListIterator<String> iterator2 = vector.listIterator(2);

        System.out.println("\nIterator 1:");
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        System.out.println("\nIterator 2:");
        while (iterator2.hasPrevious()) {
            System.out.println(iterator2.previous());
        }

        System.out.println("\nVector size before removing: " + vector.totalElem());
        if (iterator1.hasNext())
            iterator1.next();
        if (iterator2.hasPrevious())
            iterator2.previous();
        if(iterator2.hasNext())
            iterator2.next();
        iterator2.previousIndex();
        iterator2.nextIndex();
        System.out.println("Vector size after removing: " + vector.totalElem());

        System.out.println("\nVector elements after removal:");
        for (String element : vector) {
            System.out.println(element);
        }
    }
}

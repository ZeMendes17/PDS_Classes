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
        iterator1.remove(); // Removing element "Antonio"
        iterator2.next(); // Moving iterator2 to the next element "Maria"
        iterator2.remove(); // Removing element "Maria"
        System.out.println("Vector size after removing: " + vector.totalElem());

        System.out.println("\nVector elements after removal:");
        for (String element : vector) {
            System.out.println(element);
        }
    }
}

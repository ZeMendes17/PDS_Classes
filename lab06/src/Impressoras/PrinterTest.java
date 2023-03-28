package Impressoras;

import java.util.ArrayList;
import java.util.List;

public class PrinterTest {
    
    private static void pause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AdvancedPrinter printer1 = new AdvancedPrinter();
        AdvancedPrinter printer2 = new AdvancedPrinter();
        BasicPrinter printer3 = new BasicPrinter();
        BasicPrinter printer4 = new BasicPrinter();
        AdapterBasicPrinter queue1 = new AdapterBasicPrinter();
        AdapterBasicPrinter queue2 = new AdapterBasicPrinter();
        queue1.refill();
        queue2.refill();

        List<Document> docs1 = new ArrayList<>();
        docs1.add(new Document("This is a great text..."));
        docs1.add(new Document("Natural language gen..."));
        docs1.add(new Document("You which to know ho..."));

        List<String[]> docs2 = new ArrayList<>();
        docs2.add(new String[]{"This is a great text..."});
    }
}

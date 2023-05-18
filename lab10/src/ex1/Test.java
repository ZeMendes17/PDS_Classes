package ex1;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        // 5 products
        Produto product1 = new Produto("Monster Energy Drink", 1.69);
        Produto product2 = new Produto("4k Television", 199.99);
        Produto product3 = new Produto("Hand moisturizer", 9.99);
        Produto product4 = new Produto("Hoddie", 59.99);
        Produto product5 = new Produto("G-Shock", 299.99);

        // 3 clients
        Cliente client1 = new Cliente("Albertino");
        Cliente client2 = new Cliente("Joaquina");
        Cliente client3 = new Cliente("Joe");

        // 1 manager
        Gestor manager = new Gestor("José");


        // lets sell the products
        List<Produto> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);

        System.out.println("---------------------------------------------------- AUCTION IS ABOUT TO START ----------------------------------------------------");

 
        System.out.println("---------------------------------------------------- PRODUCT: " + product1.getDescription() + " ----------------------------------------------------");

        manager.startAuction(5000, product1);
        client1.bid(product1, 2000);
        client2.bid(product1, 32);
        client3.bid(product1, 2000.01);

        System.out.println("---------------------------------------------------- PRODUCT: " + product2.getDescription() + " ----------------------------------------------------");

        manager.startAuction(5000, product2);
        client1.bid(product2, 400);
        client2.bid(product2, 1000);
        client3.bid(product2, 99.99);

        System.out.println("---------------------------------------------------- PRODUCT: " + product3.getDescription() + " ----------------------------------------------------");

        manager.startAuction(5000, product3);
        client1.bid(product3, 10);
        client2.bid(product3, 11);
        client3.bid(product3, 12);

        System.out.println("---------------------------------------------------- PRODUCT: " + product4.getDescription() + " ----------------------------------------------------");

        manager.startAuction(5000, product4);
        client1.bid(product4, 70);
        client2.bid(product4, 73);
        client3.bid(product4, 100);

        System.out.println("---------------------------------------------------- PRODUCT: " + product5.getDescription() + " ----------------------------------------------------");

        manager.startAuction(5000, product5);
        client1.bid(product5, 300);
        client2.bid(product5, 0.99);
        client3.bid(product5, 9999999.99);

        System.out.println("---------------------------------------------------- CHECKING RESULTS ----------------------------------------------------");

    }
}

package lab11.src.ex3;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean show = true;

        // create library and 3 books
        Library library = new Library();
        Book book1 = new Book("The Secret Garden", "9780142437055", 1911, "Frances Hodgson Burnett");
        Book book2 = new Book("The Alchemist", "9780061122415", 1988, "Paulo Coelho");
        Book book3 = new Book("To Kill a Mockingbird", "9780061120084", 1960, "Harper Lee");

        // add books to the library
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // loop to do operations
        while(true) {
            if(show) {
                System.out.println("*** Biblioteca ***");
                library.displayLibrary();
                System.out.println(">> <livro>, <operação: (1)regista; (2)requisita; (3)devolve; (4)reserva; (5)cancela");
            }
            else {
                System.out.println();
            }

            System.out.print(">>");
            String input = sc.nextLine();
            String[] parts = input.split(",");

            Book book = library.getBook(Integer.parseInt(parts[0]) - 1);
            int operation = Integer.parseInt(parts[1]);

            switch(operation) {
                case 1:
                    show = book.register();
                    break;
                case 2:
                    show = book.order();
                    break;
                case 3:
                    show = book.giveBack();
                    break;
                case 4:
                    show = book.reserve();
                    break;
                case 5:
                    show = book.cancelReserve();
                    break;
                default:
                    System.err.println("Operação Inexistente");
                    sc.close();
                    System.exit(0);
            }
        }
    }
}

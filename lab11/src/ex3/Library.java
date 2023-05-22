package lab11.src.ex3;

import java.util.ArrayList;
import java.util.List;

public class Library {
    
    private List<Book> books = new ArrayList<>();

    public void addBook(Book b) {
        books.add(b);
    }

    public Book getBook(int index) {
        return books.get(index);
    }

    public void displayLibrary() {
        for(int i = 0; i < books.size(); i++)
            System.out.println((i+1) + "\t" + getBook(i));
        
    }
}

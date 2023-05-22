package lab11.src.ex3;

public class Book {
    private String title;
    private String ISBN;
    private int year;
    private String firstAuthor;

    // state
    private State state;


    // constructor
    public Book(String title, String ISBN, int year, String firstAuthor) {
        this.title = title;
        this.ISBN = ISBN;
        this.year = year;
        this.firstAuthor = firstAuthor;
        state = new Inventory();
    }

    // getters
    public String getTitle() {
        return title;
    }
    public String getISBN() {
        return ISBN;
    }
    public int getYear() {
        return year;
    }
    public String getAuthor() {
        return firstAuthor;
    }
    public State getState() {
        return state;
    }

    // setters
    public void setTitle(String title) {
        this.title = title;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setAuthor(String author) {
        this.firstAuthor = author;
    }
    public void setState(State state) {
        this.state = state;
    }

    // State operations
    public boolean register() {
        return state.register(this);
    }

    public boolean order() {
        return state.order(this);
    }

    public boolean reserve() {
        return state.reserve(this);
    }

    public boolean cancelReserve() {
        return state.cancelReserve(this);
    }
    public boolean giveBack() {
        return state.giveBack(this);
    }

    // toString method
    @Override
    public String toString() {
        return String.format("%-25s %-25s [%s]", title, firstAuthor, state);
    }
}

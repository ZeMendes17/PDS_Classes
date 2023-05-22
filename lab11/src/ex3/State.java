package lab11.src.ex3;

public interface State {
    public boolean register(Book b);
    public boolean order(Book b);
    public boolean reserve(Book b);
    public boolean cancelReserve(Book b);
    public boolean giveBack(Book b);
}

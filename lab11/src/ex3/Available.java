package lab11.src.ex3;

public class Available implements State {

    @Override
    public boolean register(Book b) {
        System.err.println("Operação não disponível");
        return false;
    }

    @Override
    public boolean order(Book b) {
        b.setState(new Borrowed());
        return true;
    }

    @Override
    public boolean reserve(Book b) {
        b.setState(new Reserved());
        return true;
    }

    @Override
    public boolean cancelReserve(Book b) {
        System.err.println("Operação não disponível");
        return false;
    }

    @Override
    public boolean giveBack(Book b) {
        System.err.println("Operação não disponível");
        return false;
    }
    
    @Override
    public String toString() {
        return "Disponível";
    }
}

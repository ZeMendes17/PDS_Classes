package lab11.src.ex3;

public class Borrowed implements State {

    @Override
    public boolean register(Book b) {
        System.err.println("Operação não disponível");
        return false;
    }

    @Override
    public boolean order(Book b) {
        System.err.println("Operação não disponível");
        return false;
    }

    @Override
    public boolean reserve(Book b) {
        System.err.println("Operação não disponível");
        return false;
    }

    @Override
    public boolean cancelReserve(Book b) {
        System.err.println("Operação não disponível");
        return false;
    }

    @Override
    public boolean giveBack(Book b) {
        b.setState(new Available());
        return true;
    }
    
    @Override
    public String toString() {
        return "Emprestado";
    }
}

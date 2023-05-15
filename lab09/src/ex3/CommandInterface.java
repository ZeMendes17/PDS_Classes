package ex3;

public interface CommandInterface<E> {
    void execute(E elem);
    void undo();
}

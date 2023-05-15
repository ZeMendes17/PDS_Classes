package ex3;

import java.util.Collection;

public class AddCommand<E> implements CommandInterface<E> {
    Collection<E> storage;
    private E element;

    public AddCommand(Collection<E> storage) {
        this.storage = storage;
    }

    public void execute(E elem) {
        storage.add(elem);
        this.element = elem;
    }

    public void undo() {
        storage.remove(element);
    }
}
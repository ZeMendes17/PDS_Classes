package ex3;

import java.util.Collection;

public class RemoveCommand<E> implements CommandInterface<E> {
    Collection<E> storage;
    private E element;

    public RemoveCommand(Collection<E> storage) {
        this.storage = storage;
    }

    public void execute(E elem) {
        storage.remove(elem);
        this.element = elem;
    }

    public void undo() {
        storage.add(element);
    }
}
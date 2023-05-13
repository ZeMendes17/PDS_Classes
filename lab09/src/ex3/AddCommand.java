package ex3;

import java.util.Collection;

public class AddCommand<E> implements CommandInterface {
    private final Collection<E> collection;
    private final E element;

    public AddCommand(Collection<E> collection, E element) {
        this.collection = collection;
        this.element = element;
    }

    public void execute() {
        collection.add(element);
    }

    public void undo() {
        collection.remove(element);
    }
}
package ex3;

import java.util.Collection;

public class RemoveCommand<E> implements CommandInterface {
    private final Collection<E> collection;
    private final E element;

    public RemoveCommand(Collection<E> collection, E element) {
        this.collection = collection;
        this.element = element;
    }

    public void execute() {
        collection.remove(element);
    }

    public void undo() {
        collection.add(element);
    }
}
package ex3;

import java.util.Collection;

public class Storage<E> {
    private Collection<E> collection;

    public void AddToCollection(E elem) {
        collection.add(elem);
    }

    public void RemoveFromCollection(E elem) {
        collection.remove(elem);
    }
}

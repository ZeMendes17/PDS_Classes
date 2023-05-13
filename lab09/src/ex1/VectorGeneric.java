import java.util.Iterator;
import java.util.NoSuchElementException;

public class VectorGeneric<T> {
	private T[] vec;		
	private int nElem;	      
	private final static int ALLOC = 50;   
	private int dimVec = ALLOC;     

	@SuppressWarnings("unchecked")
	public VectorGeneric() {
		vec = (T[]) new Object[dimVec];
		nElem = 0;
	}
	
	public boolean addElem(T elem) {
		if (elem == null)
			return false;
		ensureSpace();
		vec[nElem++] = elem;
		return true;
	}

	private void ensureSpace() {
		if (nElem>=dimVec) {
			dimVec += ALLOC;
			@SuppressWarnings("unchecked")
			T[] newArray = (T[]) new Object[dimVec];
			System.arraycopy(vec, 0, newArray, 0, nElem );
			vec = newArray;
		}
	}

	public boolean removeElem(T elem) {
		for (int i = 0; i < nElem; i++) {
			if (vec[i].equals(elem)) {
				if (nElem-i-1 > 0) // not last element
					System.arraycopy(vec, i+1, vec, i, nElem-i-1 );
				vec[--nElem] = null; // libertar último objecto para o GC
				return true;
			}
		}
		return false;
	}

	public int totalElem() {
		return nElem;
	}
	
	public T getElem(int i) {
		return (T) vec[i];
	}








	private class VectorIterator<K> implements Iterator<K> {

        private int index;

        VectorIterator() {
			index = 0;
		}

        public boolean hasNext() {
			return (index < nElem);
		}
    
        public K next() {
            if (hasNext()){
                return(K)VectorGeneric.this.vec[index++];
			}
            throw new NoSuchElementException("only " + nElem + " elements");
        }

        public void remove(){   // default since Java 8
            throw new UnsupportedOperationException("Operacao nao suportada!");
        }
    
    }
}

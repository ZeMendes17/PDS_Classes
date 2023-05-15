package ex1;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ListIterator;

public class VectorGeneric<T> implements Iterable<T>{
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

	@Override
    public Iterator<T> iterator() {
        return new VectorIterator();
    }


	public ListIterator<T> listIterator() {
        return new VectorListIterator();
    }

	public ListIterator<T> listIterator(int index) {
        if (index < 0 || index >= nElem)
            throw new IndexOutOfBoundsException("Index: " + index);
        return new VectorListIterator(index);
    }


	private class VectorIterator implements Iterator<T> {

        protected int index1;

        VectorIterator() {
			index1 = 0;
		}

		@Override
        public boolean hasNext() {
			return (index1 < nElem);
		}
      
		@Override
        public T next() {
            if (hasNext()){
                return(T)VectorGeneric.this.vec[index1++];
			}
            throw new NoSuchElementException("only " + nElem + " elements");
        }

        public void remove(){   // default since Java 8
            throw new UnsupportedOperationException("Operacao nao suportada!");
        }
    
    }

	private class VectorListIterator implements ListIterator<T> {

        protected int index1;
        
        public VectorListIterator() {
            index1 = 0;
        }

        public VectorListIterator(int index) {
            if (index < 0 || index > nElem)
                throw new IndexOutOfBoundsException("Index: " + index);
        	index1 = index;
        }

        @Override
        public boolean hasPrevious() {
            return index1 > 0;
        }

        @Override
        public T previous() {
            if (!hasPrevious())
                throw new NoSuchElementException();
                return(T)VectorGeneric.this.vec[index1--];
        }

        @Override
        public int nextIndex() {
            return index1;
        }

        @Override
        public int previousIndex() {
            return index1 - 1;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Operacao nao suportada! (remove)");
        }

        @Override
        public void set(T e) {
            throw new UnsupportedOperationException("Operacao nao suportada! (remove)");
        }

        @Override
        public void add(T e) {
            throw new UnsupportedOperationException("Operacao nao suportada! (add))");
        }

        @Override
        public boolean hasNext() {
            return (index1 < nElem);
        }

        @Override
        public T next() {
            if (hasNext()){
                return(T)VectorGeneric.this.vec[index1++];
			}
            throw new NoSuchElementException("only " + nElem + " elements");
        }
	}
}

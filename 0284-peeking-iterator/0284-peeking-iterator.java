// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
import java.util.*;
class PeekingIterator implements Iterator<Integer> {
    
    Iterator<Integer> iter;
    Integer peek;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    iter = iterator;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(peek == null) {
            if(!iter.hasNext()) throw new NoSuchElementException();
            peek = iter.next();
        }
        return peek;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(peek == null) {
            if(!iter.hasNext()) throw new NoSuchElementException();
            return iter.next();
        }
        Integer result = peek;
        peek = null;
        return result;
	}
	
	@Override
	public boolean hasNext() {
	    return peek != null || iter.hasNext();
	}
}
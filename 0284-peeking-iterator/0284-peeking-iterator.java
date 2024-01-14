// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
import java.util.*;
class PeekingIterator implements Iterator<Integer> {
    
    Iterator<Integer> iter;
    Integer peek = null;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    if(iterator.hasNext()) 
            peek = iterator.next();
        iter = iterator;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return peek;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(peek == null) throw new NoSuchElementException();
        Integer result = peek;
        peek = null;
        if(iter.hasNext()) peek = iter.next();
        return result;
	}
	
	@Override
	public boolean hasNext() {
	    return peek != null;
	}
}
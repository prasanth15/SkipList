package cs6301.g60;

import java.util.Iterator;
import java.util.Random;

public class SkipList<T extends Comparable<? super T>> {
	
	static int size;	//size of skipList
	SkipListEntry<T> head;	//header Node
	SkipListEntry<T> tail;
	static int maxLevel;	//maxLevel
	SkipListEntry<T>[] prev;
	
	
	class SkipListEntry<T> {
		T element;			//entry element
		SkipListEntry<T>[] next;	//array of next pointers
		SkipListEntry(T data, int level) {
			element = data;
			next = new SkipListEntry[level+1];
		}
	}
    // Constructor
    public SkipList(int level) {
    	maxLevel = level;
    	head = new SkipListEntry(null, level);
    	tail = new SkipListEntry(null, level);
    	for(int i = 0; i <= level; i++) {
    		head.next[i] = tail;
    	}
    	size = 0;
    	
    }

    // Add x to list. If x already exists, replace it. Returns true if new node is added to list
    public boolean add(T x) {
    	SkipListEntry<T>[] previous = find(x);
    	if(previous[0].next[0].element == x) {
    		previous[0].next[0].element = x;
    		return false;
    	}
    	int level = chooseLevel(maxLevel);
    	SkipListEntry<T> newEntry = new SkipListEntry(x, level);
    	for(int i = 0; i <= level; i++) {
    		SkipListEntry<T> temp = previous[i].next[i];  
    		previous[i].next[i] = newEntry;
    		newEntry.next[i] = temp;
    	}  
    		size++;
		return true;
    	
    }

    // Find smallest element that is greater or equal to x
    public T ceiling(T x) {
    	SkipListEntry[] previous = find(x);
    	if(!isEmpty()) {
    		return (T) previous[0].next[0].element;
    	}
    	return null;
    }

    // Does list contain x?
    public boolean contains(T x) {
    	if(!isEmpty()) {
    		SkipListEntry<T>[] previous = find(x);
    		if(previous[0].next[0].element == x) {
        		return true;
        	}
    	}
    	return false;
    }

    // Return first element of list
    public T first() {
    	if(!isEmpty()) {
    		return head.next[0].element;
    	}
    	return null;
    }

    // Find largest element that is less than or equal to x
    public T floor(T x) {
    	SkipListEntry[] previous = find(x);
    	if(!isEmpty()) {
    		for(int i = 0; i <= maxLevel; i++){
    			if(x.compareTo((T) previous[i].element) >= 0) {
    				return (T) previous[i].element;
    			}
    		}
    	}
    	return null;
    }
    

    // Find an element in the skiplist
    public SkipListEntry<T>[] find(T x) {
    	SkipListEntry<T> p = head;
    	prev = new SkipListEntry[maxLevel+1];
    	for(int i = maxLevel; i >= 0; i--) {
    		//Initial condition
    		if(p.next[i] == tail) {
    			prev[i] = p;
    			continue;
    		}
    		while((p.next[i] != tail) && (p.next[i].element).compareTo(x) < 0) {
    			p = p.next[i];
    		}
    		//fill previous with all the nodes with grid starting from head
    		prev[i] = p;
    	}
    	return prev;
    }

    // Is the list empty?
    public boolean isEmpty() {
    	if(size == 0) {
    		return true;
    	}
    	return false;
    }

    // Return last element of list
    public T last() {
    	if(isEmpty()) {
    		return null;
    	}else{
    		SkipListEntry<T> p = head;
    		for(int i = maxLevel; i >= 0; i--) {
    			SkipListEntry<T> entry = p.next[i];
    			if(entry == tail) {
    				continue;
    			}else{
    				p = entry;
    			}
    		}
    		while(p.next[0] != tail) {
    			p = p.next[0];
    		}
    		return p.element;
    	}
    }

    // Remove x from list.  Removed element is returned. Return null if x not in list
    public T remove(T x) {
    	SkipListEntry[] previous = find(x);
    	SkipListEntry<T> n = previous[0].next[0];
    	if(n.element != x) {
    		return null;
    	}else{
    		for(int i = 0; i <= maxLevel; i++) {
    			if(previous[i].next[i] == n) {
    				previous[i].next[i] = n.next[i];
    			}else{
    				break;
    			}
    		}
    		size--;
    		return n.element;
    	}
    	
    }

    // Return the number of elements in the list
    public int size() {
    	if(size == 0) 	
    		return 0;
    	return size;
    }
    
    // Choose level for a SkipListEntry
    public int chooseLevel(int level) {
    	int i = 0;
    	while(i < level) {
    		boolean b = new Random().nextBoolean();
    		if(b == true) {
    			i++;
    		}else{
    			break;
    		}
    	}
    	return i;
    }
    
    //Print SkipList
    public void printList() {
    	SkipListEntry entry = head;
    	for(int i = 0; i < size; i++) {
    		System.out.print(entry.next[0].element + "\t");
    		entry = entry.next[0];
    	}
    	
    }
    
    // Return element at index n of list.  First element is at index 0.
    public T get(int n) {
	return null;
    }
    
    // Reorganize the elements of the list into a perfect skip list
    public void rebuild() {
	
    }
    
    // Iterate through the elements of list in sorted order
    public Iterator<T> iterator() {
	return null;
    }

}

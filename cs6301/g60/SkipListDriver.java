package cs6301.g60;

import java.util.Random;

public class SkipListDriver {
	
	public static void main(String[] args) {
		SkipList sl = new SkipList(4);
		
		System.out.println("IsEmpty? "+sl.isEmpty());
		//Adding element into skipList
		sl.add(7);
		sl.add(9);
		sl.add(11);
		
		sl.printList();
		
		
		//Checking if the list is Empty
		System.out.println("\nIsEmpty? "+sl.isEmpty());
		
		//Find smallest element that is greater or equal to x
		System.out.println("Ceiling value: "+sl.ceiling(9));
		
		sl.add(16);
		System.out.println("First Element is: "+sl.first());
		sl.printList();
		System.out.println();
		sl.add(12);
		sl.printList();
		System.out.println("\nCeiling value: "+sl.ceiling(13));
		System.out.println("Floor value: "+sl.floor(10));
		
		//Find last element
		System.out.println("Last element in array: "+sl.last());
		
		sl.add(10);
		System.out.println();
		sl.printList();
		System.out.println();
		System.out.println(sl.ceiling(10));
		System.out.println(sl.floor(11));
		sl.add(25);
		sl.printList();
		System.out.println();
		System.out.println(sl.last());
		System.out.println();
		System.out.println(sl.first());
		sl.add(6);
		sl.printList();
		System.out.println(sl.contains(8));
		System.out.println("Remove operation");
		System.out.println(sl.remove(6));
		sl.printList();
	}

}

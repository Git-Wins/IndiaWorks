package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.testng.annotations.Test;

public class LinkedListWrks {

	@Test
	public void linkdLstWrks() {

		List<String> aa = new ArrayList<String>();
		System.out.println("LinkedList 'aa': " +aa);

		//adding elements
		aa.add("Aa");
		aa.add("Bb");
		aa.add("Cc");
		System.out.println("LinkedList 'aa': " +aa);

		//removing by 'Object'
		aa.remove("Aa");
		System.out.println("LinkedList 'aa': " +aa);

		//removing by 'index'
		aa.remove(1);
		System.out.println("LinkedList 'aa': " +aa);

		//clearing the list
		aa.clear();
		System.out.println("LinkedList 'aa': " +aa);

		//adding elements by index
		aa.add(0, "Aa");
		aa.add("Bb");
		aa.add("Cc");
		System.out.println("LinkedList 'aa': " +aa);
		
		//getting list elements
		System.out.println(aa.get(0));
		//System.out.println(aa.get(5)); ............Would return IndexOutOfBoundsException..............
		
		//replacing list elements
		aa.set(1, "Dd");
		//aa.set("Aa", "Ee"); ................not updated.....................
		System.out.println("LinkedList 'aa': " +aa);
		
		//returns the size of the list
		System.out.println("Linkedlist 'aa' size: " +aa.size());
		
		//checking for the occurrence of a particular String
		System.out.println("list contains 'Aa'? " +aa.contains("Aa"));
		System.out.println("list contains 'AA'? " +aa.contains("AA"));
		System.out.println("list contains 'SFDSFSdfdsgs'? " +aa.contains("SFDSFSdfdsgs"));
		
		//Using Iterator
		Iterator itr = aa.iterator();
		while(itr.hasNext()) {
			System.out.println("Iterator: " +itr.next());
		}
		
		//Using ListIterator
		ListIterator itr1 = aa.listIterator();
		//below listIterator doesn't work..it works only after a forward call is made. Y ?????????
		while(itr1.hasPrevious()) {
			System.out.println("ListIterator1 previous: " +itr1.previous());
		}
		while(itr1.hasNext()) {
			System.out.println("ListIterator next: " +itr1.next());
		}
		while(itr1.hasPrevious()) {
			System.out.println("ListIterator2 previous: " +itr1.previous());
		}
	}
}

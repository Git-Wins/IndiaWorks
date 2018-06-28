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

		//Creating a LinkedList
		List<String> linkedList = new LinkedList<String>();
		linkedList.add("Aa");
		linkedList.add("Bb");
		linkedList.add("Cc");
		
		List<String> c = new LinkedList<String>();
		c.add("11");
		c.add("22");
		c.add("33");
		
		//using the AddAll method
		linkedList.addAll(1, c);
		System.out.println("Added all contents from the other collection: " +linkedList);
		
		
		//Using ListIterator
		ListIterator itr1 = linkedList.listIterator();

		//backward direction
		while(itr1.hasPrevious()) {
			System.out.println("ListIterator: " +itr1.previous());
		}

		//forward direction
		while(itr1.hasNext()) {
			System.out.println("ListIterator: " +itr1.next());
		}

		//backward direction
		while(itr1.hasPrevious()) {
			System.out.println("ListIterator: " +itr1.previous());
		}

	}
}

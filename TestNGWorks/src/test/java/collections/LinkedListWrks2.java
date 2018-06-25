package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.testng.annotations.Test;

public class LinkedListWrks2 {

	@Test
	public void linkdLstWrks2() {

		//Creating a LinkedList
		List<String> linkedList = new LinkedList<String>();
		linkedList.add("Aa");
		linkedList.add("Bb");
		linkedList.add("Cc");

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

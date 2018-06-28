package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListWorks {

	public static void main(String[] args) {
		List<String> lString = new ArrayList<String>();
		List<Integer> lInt = new ArrayList<Integer>();
		List<Double> lDouble = new ArrayList<Double>();
		List<Boolean> lBoolean = new ArrayList<Boolean>();

		//adding to String list
		for(int i=0;i<5;i++) {
			lString.add("Hi"+i);	
		}
		lString.add("Hi4");
		System.out.println("String list: " +lString +" and it's size: "+lString.size());

		//addAll
		List<String> listToAdd = new ArrayList<String>();
		listToAdd.add("Oo");listToAdd.add("Pp");listToAdd.add("Ff");
		lString.addAll(1, listToAdd);
		System.out.println("String list-after addAll: " +lString);

		//replace using the 'set' method
		lString.set(1, "Replaced");
		System.out.println("String list-after using 'set' method: " +lString);

		//retainAll method
		lString.retainAll(listToAdd);
		System.out.println("String list-after retainAll: " +lString);

		//contains
		System.out.println("String list-contains 'Hi3'?? " +lString.contains("Hi3"));

		//removing
		//lString.remove("Hi4");
		lString.remove(lString.size()-1);
		System.out.println("String list-after removing: " +lString);

		//using the 'toArray' method
		Object[] jj = lString.toArray();
		for(Object jk : jj) {
			System.out.println("Array's inclusive: "+jk);
		}
		
		//getting an element
		System.out.println("element at index '0': " +lString.get(0));

		//finding the index of the specified element
		System.out.println("index of the String \"Pp\": " +lString.indexOf("Pp"));
		
		
		//adding to Integer list
		for(int i=0;i<5;i++) {
			lInt.add(i);
		}
		System.out.println("Integer list: " +lInt);

		//adding to Double list
		for(double i=0;i<5;i++) {
			lDouble.add(i);
		}
		System.out.println("Double list: " +lDouble);

		//adding to Boolean list
		lBoolean.add(true);
		lBoolean.add(false);
		//lBoolean.add(TRUE); .... NOT ALLOWED.....
		//lBoolean.add(True); .... NOT ALLOWED.....
		System.out.println("Boolean list: "+lBoolean);

		//clearing the String list
		lString.clear();
		System.out.println("String list-after clearing: " +lString);
		System.out.println("List String is empty? " +lString.isEmpty());

		System.out.println("String list-contains 'Hi3'?? " +lString.contains("Hi3"));




	}

}

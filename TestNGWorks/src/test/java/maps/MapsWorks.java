package maps;


import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.testng.annotations.Test;

public class MapsWorks {

	@Test
	public void mapsTest() {
		
		Map<String, Integer> mm = new TreeMap<String,Integer>();
		
		mm.put("Wins", 11);
		mm.put("Man", 22);
		mm.put("Vij", 33);
		
		System.out.println(mm);
		
		/////////////////////////////////////////////////////
		
		List<Integer> ll = new LinkedList<Integer>();
		ll.add(100);
		ll.add(200);
		ll.add(300);
		
		Map<String, List<Integer>> ml = new TreeMap<String,List<Integer>>();
		ml.put("id", ll);
		
		System.out.println(ml);
		
		////////////////////////////////////////////////////
		
		Map<String, Map<String, Integer>> mmm = new TreeMap<String, Map<String, Integer>>();
		mmm.put("String1", mm);
		
		System.out.println(mmm);
		
		
	}
}

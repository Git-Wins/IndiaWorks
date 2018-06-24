package fileIO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Try {

	public static void main(String[] args) {
		
		List<String> gg = new ArrayList<String>();
		
		
		Set<String> hh = new HashSet<String>();
		
		char[] yy = {'t', 'r', 'e', 'e'};
		System.out.println(yy);
		
		String yy1 = Arrays.toString(yy);
		System.out.println(":: " +yy);
		System.out.println(yy);
		System.out.println(yy1);
		
		byte aa = 3;
		int bb = 3;
		
		Integer cc = bb;
		
		//Automatic type-conversion happening below
		int ff = 3;
		
		//You to purposely cast into (int) before wrapping it into its Integer-Wrapper variable 'dd'
		Integer dd = (int)aa;
		
		//
		Byte ee = (byte)bb;
	}

}

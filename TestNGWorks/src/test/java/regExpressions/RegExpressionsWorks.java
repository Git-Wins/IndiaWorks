package regExpressions;

import java.util.Arrays;

public class RegExpressionsWorks {

	public static void main(String[] args) {

		String name = "Winston";
		String ff = "tre";

		//to check if the String has characters that contains {XX} no. of characters, say here XX=7
		System.out.println(name.matches("[a-zA-Z0-9]{7}"));
		/*the following is not allowed....
		System.out.println(name.matches("[a-zA-Z]{name.length()}"));*/
		//to check if the String starts with 'w' or 'W' and is followed by 'inston' 
		System.out.println(name.matches("[wW9]inston"));
		//to check if the String contains 'ns' and has anything before and after the substring 'ns'
		System.out.println(name.matches("(.*)ns(.*)"));
		//to check if the String contains 'ns' and has just a single char in front and also just a single char follwing it
		System.out.println(name.matches("(.)ns(.)"));
		//to check if the String contains 'r' and has just a single char in front and also just a single char follwing it
		System.out.println(ff.matches("(.)r(.)"));
		//to split the String when 's' appears on it 
		System.out.println(Arrays.toString(name.split("s")));
		//to replace only the first occurrence of 'n' in the String with 'N'
		System.out.println(name.replaceFirst("n", "N"));
		//to replace all occurrences of 'n' in the String with 'N'
		System.out.println(name.replaceAll("n", "N"));
		//to replace all occurrences of 'n.t' in the String with 'XXX'
		System.out.println("Eeeee: " +name.replaceAll("n.t", "XXX"));
		//to replace all occurrences of 'n.*o' in the String with 'XXX'
		System.out.println("Eeeee: " +name.replaceAll("n.*o", "XXX"));
		//returns true if the string does not have a number at the beginning
		System.out.println(name.matches("[\\D](.*)"));
		//returns true if the string has a number at the beginning
		System.out.println(name.matches("[\\d](.*)"));
		//returns true if the string does not have a char at the beginning
		System.out.println(name.matches("[\\W](.*)"));
		//returns true if the string does have a char at the beginning
		System.out.println(name.matches("[\\w](.*)"));
	}

}

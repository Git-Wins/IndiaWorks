package regExpressions;

public class RegExpressionsTRY {

	public static void main(String[] args) {
		
		String sample_text = "This is my small example "
	            + "string which I'm going to " + "use for pattern matching.";
		
		System.out.println(sample_text);
		System.out.println(sample_text.matches("\\W.*"));
		String[] ff = sample_text.split("//s");
		System.out.println("Array's length: " +ff.length);
		for(String hh : ff) {
			System.out.print(hh);
		}
	}

}

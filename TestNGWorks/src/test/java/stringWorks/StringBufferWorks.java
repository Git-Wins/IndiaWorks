package stringWorks;

import org.testng.annotations.Test;

public class StringBufferWorks {

	@Test
	public void stringTest() {
		StringBuffer sb = new StringBuffer("Hello");
		sb.append('r');
		sb.insert(1, 'X');
		System.out.println(sb);
		sb.deleteCharAt(2);
		System.out.println(sb);
		sb.delete(1, 3);
		System.out.println(sb);
		System.out.println(sb.substring(0, 2));
		System.out.println(sb.reverse());
		System.out.println(sb);
		
	}
}

package stringWorks;

import org.testng.annotations.Test;

public class StringWorks {

	@Test
	public void stringTest() {
		String aa = "Peace";
		StringBuffer bb = new StringBuffer(aa);
		StringBuilder cc = new StringBuilder(aa);
		
		StringBuffer dd = new StringBuffer(cc);
		StringBuilder ee = new StringBuilder(dd);
		
		String ff = new String(dd);
		String gg = new String(ee);
		
		System.out.println("String 'aa': " +aa);
		System.out.println("StringBuffer 'bb': " +bb);
		System.out.println("StringBuilder 'cc': " +cc);
		System.out.println("StringBuffer 'dd': " +dd);
		System.out.println("StringBuilder 'ee': " +ee);
		System.out.println("String 'ff': " +ff);
		System.out.println("String 'gg': " +gg);
	}
}

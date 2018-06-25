package regExpressions;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class RegExpTest {

	@Test
	public void f() {
		String s = "humbapumpa Joe Jim";
		assertTrue(s.matches(".*([jJ]im).*"));
	}
}

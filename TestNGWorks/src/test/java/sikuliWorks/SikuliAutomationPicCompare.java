package sikuliWorks;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;


public class SikuliAutomationPicCompare {

	Screen screen;
	Pattern pattern;
	Region expectedRegion;

	@Test
	public void toTest() throws FindFailed {
		screen = new Screen(0);
		pattern = new Pattern("/imgs/JeffPart.JPG");
		expectedRegion = screen.exists(pattern);
		if(null != expectedRegion) {
			expectedRegion.rightClick(pattern);
		} else {
			System.out.println("Error......................");
		}
	}

}

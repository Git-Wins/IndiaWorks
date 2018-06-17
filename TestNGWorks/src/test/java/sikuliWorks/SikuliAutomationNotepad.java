package sikuliWorks;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SikuliAutomationNotepad {

	Robot rbt;
	Screen s;

	@BeforeMethod
	public void setup() throws AWTException {
		rbt = new Robot();
		s = new Screen();
	}

	@Test
	public void test() throws FindFailed {
		rbt.keyPress(KeyEvent.VK_WINDOWS);
		rbt.keyPress(KeyEvent.VK_D);
		rbt.keyRelease(KeyEvent.VK_WINDOWS);
		rbt.keyRelease(KeyEvent.VK_D);

		s.doubleClick("imgs\\Notepad.JPG");
		//s.click("imgs\\NotepadMaxBtn.JPG");
		s.click("imgs/FileMenu.JPG");
		s.click("imgs/PrintOptn.JPG");
	}

	@AfterMethod
	public void teardown() throws FindFailed {
		s.click("imgs\\CancelBtn.JPG");
		s.wait("imgs\\MinimizeBtn.JPG", 5);
		s.click("imgs\\MinimizeBtn.JPG");
	}


}


package fileIO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWorks {

	public static void main(String[] args) throws IOException {
		FileWriter fwr = new FileWriter("C:\\QA-Automation\\toWriteAgain.txt");
		FileReader fr = new FileReader("C:\\QA-Automation\\toWrite.txt");
		int i = 0;
		while((i=fr.read())!=-1) {
			fwr.write((char)i);
		}
		fr.close();
		fwr.close();
		System.out.println("It's done !!!");
	}

}

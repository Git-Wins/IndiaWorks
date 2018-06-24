package fileIO;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterWorks {

	public static void main(String[] args) throws IOException {
		FileWriter fwr = new FileWriter("C:\\QA-Automation\\toWrite.txt");
		fwr.write("HEy am able to write something on this fileee");
		fwr.close();
		System.out.println("It's done !!!");
	}

}

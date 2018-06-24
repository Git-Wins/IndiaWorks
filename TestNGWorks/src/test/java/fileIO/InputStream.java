package fileIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InputStream {

	public static void main(String[] args) throws IOException {
		FileInputStream fin = new FileInputStream("C:\\QA-Automation\\sample.txt");
		
		int i = 0;
		
		while((i = fin.read()) != -1){
			System.out.print((char)i);
		}
		
				
		fin.close();

	}

}

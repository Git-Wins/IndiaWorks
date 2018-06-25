package casting;

import org.testng.annotations.Test;

public class CastingDataTypes {

	@Test
	public void toCast() {
		
		//byte to int 
		byte b = 11;
		int i = (int)b;
		int j = b;
		
		//int to byte
		byte cc = (byte)i;
		int kk = -128;
		byte gg = (byte)kk;
		
		//double to byte
		double dd = 258.142;
		byte nn = (byte)dd;
		
		System.out.println("byte 'b': " +b);
		System.out.println("int 'i': " +i);
		System.out.println("int 'j': " +j);
		System.out.println("byte 'cc': " +cc);
		System.out.println("byte 'gg': " +gg);
		System.out.println("byte 'nn': " +nn);
	}
}

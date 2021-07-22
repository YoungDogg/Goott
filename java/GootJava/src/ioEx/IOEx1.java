package ioEx;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class IOEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte[] inSrc = {0, 1, 2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		
		ByteArrayInputStream arrayInputStream = null;
		ByteArrayOutputStream arrayOutputStream = null;
		
		arrayInputStream = new ByteArrayInputStream(inSrc);
		arrayOutputStream = new ByteArrayOutputStream(outSrc.length);
		
		int data = 0;
		
		while((data = arrayInputStream.read()) != -1) {
			arrayOutputStream.write(data);
		}
		
		outSrc = arrayOutputStream.toByteArray();
		
		System.out.println(Arrays.toString(outSrc));
	}

}

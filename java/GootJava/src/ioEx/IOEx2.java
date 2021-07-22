package ioEx;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOEx2 {
///Users/master/Documents/GitHub/Goott/java/HelloJava.java
	public static void main(String[] args) {
		if (args.length > 0) {
			FileReader fileReader = null;
			FileWriter fileWriter = null;
			// TODO Auto-generated method stub
			try {
//				fileReader = new FileReader("/Users/master/Documents/GitHub/Goott/java/HelloJava.java");
				fileReader = new FileReader(args[0]);
				
				fileWriter = new FileWriter(args[1]);				
	
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("reading file failed");
				e.printStackTrace();
				System.exit(0); 
			} catch (IOException e) {
				// TODO: handle exception
				System.out.println("파일 쓰기 실패");
			}

			int data = 0;

			try {
				while ((data = fileReader.read()) != -1) {
					System.out.print((char) data);
					fileWriter.write(data);
				}
				fileReader.close();
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("파일처리 실");
				e.printStackTrace();
			}
		}else {
			System.out.println("get the file to read");
		}
	}

}

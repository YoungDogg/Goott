package singletonEx;

import java.util.Calendar;

import singleton.NotSingleTon;
import singleton.Singleton;

public class SingleTonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i< 10; i++) {
			NotSingleTon notSingleTon = new NotSingleTon();
			System.out.println(notSingleTon.hashCode());
		}
		
		System.out.println("=========================");
		
		for(int i = 0; i< 10; i++) {
			Singleton singleton  = Singleton.getInstance();
//			Singleton singleton  = new Singleton();
			System.out.println(singleton.hashCode());
		}
	
		Calendar c = Calendar.getInstance();
		System.out.println(c.getTime());
	}
}

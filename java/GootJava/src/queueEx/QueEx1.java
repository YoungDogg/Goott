package queueEx;

import java.util.LinkedList;
import java.util.Queue;

public class QueEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<String> queue = new LinkedList<String>();
		
		queue.add("hi");
		queue.add("hi2");
		queue.add("hi3");
		
		System.out.println(queue.toString());
		
//		queue.poll();
		queue.poll();
		queue.poll();
		
		System.out.println(queue.toString());
	}

}

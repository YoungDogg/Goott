package stackEx;

import java.util.Stack;

public class StackEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> stack = new Stack<String>();
		
		stack.push("hi");
		stack.push("hi2");
		stack.push("hi3");
		
		System.out.println(stack.toString());
		
		stack.pop();
	}

}

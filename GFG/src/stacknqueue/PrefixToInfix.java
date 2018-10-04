package stacknqueue;

import java.util.Scanner;

public class PrefixToInfix {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String prefixExpression = in.nextLine();
		System.out.println(evaluatePrefixToInfix(prefixExpression));
		in.close();
	}
	
	private static String evaluatePrefixToInfix(String prefix) {
		MyStack2 s = new MyStack2();
		for(int i = prefix.length() - 1; i >= 0; i--) {
			char ch = prefix.charAt(i);
			if(isOperand(ch)) {
				s.push(ch + "");
			}
			else {
				String str = "(" + s.pop() + ch + s.pop() + ")";
				s.push(str);
			}
		}
		return s.pop();
	}
	private static boolean isOperand(char ch) {
		if(((ch >= 'A')&&(ch <= 'Z')) || ((ch >= 'a')&&(ch <= 'z'))) {
			return true;
		}
		return false;
	}
}

class MyStack2 {
	String[] arr;
	int size;
	public MyStack2() {
		arr = new String[100];
		size = -1;
	}
	public void push(String data) {
		arr[++size] = data;
	}
	public String pop() {
		return arr[size--];
	}
	public String top() {
		return arr[size];
	}
	public boolean isEmpty() {
		return size == -1;
	}
	public int size() {
		return size + 1;
	}
}
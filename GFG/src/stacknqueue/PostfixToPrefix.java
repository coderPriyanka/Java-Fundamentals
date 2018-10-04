package stacknqueue;

import java.util.Scanner;

public class PostfixToPrefix {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String postfixExpression = in.nextLine();
		System.out.println(evaluatePostfixToPrefix(postfixExpression));
		in.close();
	}
	private static String evaluatePostfixToPrefix(String postfix) {
		MyStack2 s = new MyStack2();
		for(int i = 0; i < postfix.length(); i++) {
			char ch = postfix.charAt(i);
			if(isOperand(ch)) {
				s.push(ch + "");
			}
			else {
				String op2 = s.pop();
				String op1 = s.pop();
				String str = ch + op1 + op2;
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

package stacknqueue;

import java.util.Scanner;

public class InfixToPrefix {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String infixExpression = in.nextLine();
		System.out.println(evaluateInfixToPrefix(infixExpression));
		in.close();
	}

	private static String evaluateInfixToPrefix(String infix) {
		MyStack s = new MyStack();
		StringBuffer prefix = new StringBuffer();
		for(int i = infix.length() - 1; i >= 0; i--) {
			char ch = infix.charAt(i);
			ch = (ch == '(') ? ')' : (ch == ')') ? '(' : ch;
			if(isOperand(ch)) {
				prefix.append(ch);
			}
			else if(ch == ')') {
				while(s.top() != '(') {
					prefix.append(s.pop());
				}
				s.pop();
			}
			else if(s.isEmpty() || (ch == '(') || (precedence(ch) > precedence(s.top()))) {
				s.push(ch);
			}
			else {
				int pred = precedence(ch);
				while(!s.isEmpty() && pred <= precedence(s.top())) {
					prefix.append(s.pop());
				}
				s.push(ch);
			}
		}
		while(!s.isEmpty()) {
			prefix.append(s.pop());
		}
		return prefix.reverse().toString();
	}
	
	private static int precedence(char ch) {
		switch(ch) {
		case '+':
			return 1;
		case '-':
			return 1;
		case '*':
			return 2;
		case '/':
			return 2;
		case '^':
			return 3;
		default:
			return 0;
		}
	}
	private static boolean isOperand(char ch) {
		if(((ch >= 'A')&&(ch <= 'Z')) || ((ch >= 'a')&&(ch <= 'z'))) {
			return true;
		}
		return false;
	}

}

package stacknqueue;
import java.util.*;

public class InfixToPostfix {


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String infixExpression = in.nextLine();
		System.out.println(evaluateInfixToPostfix(infixExpression));
		in.close();
	}
	
	private static String evaluateInfixToPostfix(String infix) {
		StringBuffer postfix = new StringBuffer();
		MyStack s = new MyStack();
		for(int i = 0; i < infix.length(); i++) {
			char ch = infix.charAt(i);
			if(isOperand(ch)) {
				postfix.append(ch);
			}
			else if(ch == ')') {
				while(s.top() != '(') {
					postfix.append(s.pop());
				}
				s.pop();
			}
			else if(s.isEmpty() || (ch == '(') || (precedence(ch) > precedence(s.top()))) {
				s.push(ch);
			}
			else {
				int pred = precedence(ch);
				while(!s.isEmpty() && pred <= precedence(s.top())) {
					postfix.append(s.pop());
				}
				s.push(ch);
			}
		}
		while(!s.isEmpty()) {
			postfix.append(s.pop());
		}
		return postfix.toString();
	}
	
	private static boolean isOperand(char ch) {
		if(((ch >= 'a')&&(ch <= 'z')) || ((ch >= 'A')&&(ch <= 'Z'))) {
			return true;
		}
		return false;
	}
	
	public static int precedence(char ch) {
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
}

class MyStack {
	char[] arr;
	int size;
	public MyStack() {
		arr = new char[100];
		size = -1;
	}
	public void push(char data) {
		arr[++size] = data;
	}
	public char pop() {
		return arr[size--];
	}
	public char top() {
		return arr[size];
	}
	public boolean isEmpty() {
		return size == -1;
	}
	public int size() {
		return size + 1;
	}
}

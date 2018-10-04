package stacknqueue;
import java.util.*;
public class BalancedParenthesis {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String expression = in.nextLine();
		System.out.println(isBalanced(expression));
	}
	
	private static String isBalanced(String exp) {
		Stack<Character> s = new Stack<>();
		for(int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);
			if((ch == '[') || (ch == '{') || (ch == '(') || (ch == '<')) {
				s.push(ch);
			}
			else {
				if(s.isEmpty() || !isMatch(s.peek(), ch)) {
					return "Not Balanced";
				}
				s.pop();
			}
		}
		return s.isEmpty() ? "Balanced" : "Not Balanced";
	}
	
	private static boolean isMatch(char ch1, char ch2) {
		if((ch1 == '[' && ch2 == ']') || (ch1 == '{' && ch2 == '}') || 
			(ch1 == '(' && ch2 == ')') || (ch1 == '<' && ch2 == '>')) {
			return true;
		}
		return false;
	}

}

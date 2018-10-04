package stacknqueue;

import java.util.Scanner;
import java.util.Stack;

public class MinimumElementOfStack {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
		for(int t = 1; t <= test; t++) {
			Stack<Integer> s = new Stack<>();
			Stack<Integer> ss = new Stack<>();
			int query = in.nextInt();
			for(int q = 1; q <= query; q++) {
				int type = in.nextInt();
				if(type == 1) {
					int element = in.nextInt();
					s.push(element);
					if(ss.isEmpty()) {
						ss.push(element);
					}
					else {
						if(element < ss.peek()) {
							ss.push(element);
						}
						else {
							ss.push(ss.peek());
						}
					}
				}
				else if(type == 2) {
					System.out.println(s.pop());
					ss.pop();
				}
				else {
					System.out.println(ss.peek());
				}
			}
		}
		in.close();
	}

}

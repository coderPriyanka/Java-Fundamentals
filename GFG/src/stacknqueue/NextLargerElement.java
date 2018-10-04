package stacknqueue;

import java.util.Scanner;
import java.util.Stack;

public class NextLargerElement {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
		for(int t = 1; t <= test; t++) {
			int n = in.nextInt();
			int[] arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
			}
			
			int[] result = new int[n];
			result[n - 1] = -1;
			Stack<Integer> s = new Stack<>();
			s.push(arr[n - 1]);
			for(int i = n - 2; i >= 0; i--) {
				if(arr[i] < s.peek()) {
					result[i] = s.peek();
					s.push(arr[i]);
				}
				else {
					while((!s.isEmpty())&&(arr[i] >= s.peek())) {
						s.pop();
					}
					if(s.isEmpty()) {
						result[i] = -1;
					}
					else {
						result[i] = s.peek();
					}
					s.push(arr[i]);
				}
			}
			for(int i = 0; i < n; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
		}
		in.close();
	}
}

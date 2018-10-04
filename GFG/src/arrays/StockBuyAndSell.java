package arrays;

import java.util.Scanner;
import java.util.Stack;

public class StockBuyAndSell {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
		for(int t = 1; t <= test; t++) {
			int n = in.nextInt();
			int[] stockPrice = new int[n];
			for(int i = 0; i < n; i++) {
				stockPrice[i] = in.nextInt();
			}
			Stack<Integer> stack = new Stack<>();
			stack.push(stockPrice[0]);
			int buy = 0, sell = 0, i = 1, flag = 0;
			for(i = 1; i < n; i++) {
				if(stockPrice[i] < stack.peek()) {
					stack.clear();
					sell = i - 1;
					if(buy != sell) {
						flag = 1;
						System.out.print("(" + buy + " " + sell + ")" + " ");
					}
					buy = sell = i;
				}
				stack.push(stockPrice[i]);
			}
			sell = i - 1;
			if(buy != sell) {
				flag = 1;
				System.out.print("(" + buy + " " + sell + ")" + " ");
			}
			if(flag == 0) {
				System.out.println("No Profit");
			}
			System.out.println();
		}
		in.close();
	}

}

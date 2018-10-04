package arrays;

import java.util.Scanner;

public class MaxAvgSubarrayOfSizeK {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] input = new int[n];
		for(int i = 0; i < n; i++) {
			input[i] = in.nextInt();
		}
		double sum = 0;
		for(int i = 0; i < k; i++) {
			sum+= input[i];
		}
		double maxSum = sum;
		int start = 0, end = k - 1;
		for(int i = k, j = 0; i < n; i++, j++) {
			sum = sum + input[i] - input[j];
			if(sum > maxSum) {
				start = j + 1;
				end = i;
				maxSum = sum;
			}
		}
		System.out.println("Maximum average subarray of size k = " + (maxSum / k));
		System.out.println("Start index : " + start + ", End index : " + end);
		in.close();
	}

}

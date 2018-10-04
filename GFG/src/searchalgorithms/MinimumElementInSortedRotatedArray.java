package searchalgorithms;

import java.util.Scanner;

public class MinimumElementInSortedRotatedArray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		System.out.println("Minimum element = " + findMin(arr, n, 0, n - 1));
		in.close();
	}

	private static int findMin(int[] arr, int n, int l, int h) {
		int mid = l + (h - l) / 2;
		if((mid == 0) || (mid == n - 1)) {
			return (mid == 0) ? arr[n - 1] : arr[0];
		}
		if((arr[mid] < arr[mid + 1]) && (arr[mid - 1] > arr[mid])) {
			return arr[mid];
		}
		if(arr[l] <= arr[mid]) {
			return findMin(arr, n, mid + 1, h);
		}
		return findMin(arr, n, 0, mid - 1);
	}
}

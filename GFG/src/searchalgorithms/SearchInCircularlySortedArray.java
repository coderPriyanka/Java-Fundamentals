package searchalgorithms;

import java.util.Scanner;

public class SearchInCircularlySortedArray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		int searchKey = in.nextInt();
		System.out.println(search(arr, 0, n - 1, searchKey));
		in.close();
	}
	
	private static int search(int[] arr, int l, int h, int key) {
		if(l > h) {
			return -1;
		}
		int mid = l + (h - l) / 2;
		if(key == arr[mid]) {
			return mid;
		}
		if(arr[l] <= arr[mid]) {
			if(arr[l] <= key && key >= arr[mid]) {
				return search(arr, l, mid - 1, key);
			}
			return search(arr, mid + 1, h, key);
		}
		if(arr[mid] <= key && key <= arr[h]) {
			return search(arr, mid + 1, h, key);
		}
		return search(arr, l, mid - 1, key);
	}
}

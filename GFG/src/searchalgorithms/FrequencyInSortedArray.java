package searchalgorithms;

import java.util.Scanner;

public class FrequencyInSortedArray {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		int key = in.nextInt();
		int res = findFrequency(arr, n, key);
		if(res == -1) {
			System.out.println("Element not present");
		}
		else {
			System.out.println(res);
		}
		
		in.close();
	}
	
	private static int findFrequency(int[] a, int n, int key) {
		int first = findFirstIndex(a, 0, n - 1, key);
		if(first == -1) {
			return first;
		}
		System.out.println("First index = " + first);
		int last = findLastIndex(a, first, n - 1, key, n);
		System.out.println("Last index = " + last);
		return last - first + 1;
	}

	private static int findLastIndex(int[] a, int l, int h, int key, int n) {
		if(l > h) {
			return -1;
		}
		int mid = l + (h - l) / 2;
		if((mid == n - 1) || (a[mid] == key && a[mid + 1] > key)) {
			return mid;
		}
		if(a[mid] > key) {
			return findLastIndex(a, l, mid - 1, key, n);
		}
		return findLastIndex(a, mid + 1, h, key, n);
	}

	private static int findFirstIndex(int[] a, int l, int h, int key) {
		//System.out.println("low = " + l + ", high = " + h);
		if(l > h) {
			return -1;
		}
		int mid = l + (h - l) / 2;
		if(mid == 0 || (a[mid] == key && a[mid - 1] < key)) {
			return mid;
		}
		if(a[mid] < key) {
			return findFirstIndex(a, mid + 1, h, key);
		}
		return findFirstIndex(a, l, mid - 1, key);
	}
	
}

package searchalgorithms;
import java.util.*;
public class MaxElementInHill {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		System.out.println(findMaximum(arr, 0, n - 1, n));
		in.close();
	}
	private static int findMaximum(int[] a, int l, int h, int n) {
		int mid = l + (h - l) / 2;
		if((mid == 0) || (mid == n - 1)) {
			return a[mid];
		}
		if(a[mid - 1] < a[mid] && a[mid] > a[mid + 1]) {
			return a[mid];
		}
		if(a[mid - 1] < a[mid] && a[mid] < a[mid + 1]) {
			return findMaximum(a, mid + 1, h, n);
		}
		return findMaximum(a, 0, mid - 1, n);
	}
}

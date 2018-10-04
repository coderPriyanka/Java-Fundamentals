package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class PythagoreanTriplet {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
		for(int t = 1; t <= test; t++) {
			int n = in.nextInt();
			int[] arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
				arr[i] = arr[i] * arr[i];
			}
			Arrays.sort(arr);
			System.out.println(findTriplet(arr));
		}
		in.close();
	}
	public static boolean findTriplet(int[] arr) {
		int n = arr.length;
		for(int i = n - 1; i >= 2; i--) {
			int left = 0, right = i - 1;
			while(left < right) {
				int value = arr[left] + arr[right];
				if(value == arr[i]) {
					return true;
				}
				if(value < arr[i]) {
					left++;
				}
				else {
					right--;
				}
			}
		}
		return false;
	}
}

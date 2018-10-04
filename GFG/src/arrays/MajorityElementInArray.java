package arrays;

import java.util.Scanner;

public class MajorityElementInArray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] input = new int[n];
		for(int i = 0; i < n; i++) {
			input[i] = in.nextInt();
		}
		Integer result = findMajority(input);
		System.out.println(result == null ? "Majority elemnt does not exist" : result);
		in.close();
	}
	
	private static Integer findMajority(int[] arr) {
		int count = 0;
		Integer candidate = null;
		for(int i = 0; i < arr.length; i++) {
			if(count == 0) {
				candidate = arr[i];
				count = 1;
				continue;
			}
			if(arr[i] == candidate) {
				count++;
			}
			else {
				count--;
			}
		}
		if(count == 0) {
			return null;
		}
		count = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == candidate) {
				count++;
			}
		}
		return (count > (arr.length / 2)) ? candidate : null;
	}

}

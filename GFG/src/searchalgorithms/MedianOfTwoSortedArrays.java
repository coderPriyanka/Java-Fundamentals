package searchalgorithms;

import java.util.Scanner;

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr1 = new int[n];
 		for(int i = 0; i < n; i++) {
			arr1[i] = in.nextInt();
		}
 		int[] arr2 = new int[n];
 		for(int i = 0; i < n; i++) {
			arr2[i] = in.nextInt();
		}
 		System.out.println("Median of two sorted arrays is : " + findMedian(arr1, arr2));
 		in.close();
	}
	
	private static double findMedian(int[] a, int[] b) {
		int s1 = 0;
		int e1 = a.length - 1;
		int s2 = 0;
		int e2 = b.length - 1;
		return findMedian(a, b, s1, e1, s2, e2);
	}
	
	//TODO
	private static double findMedian(int[] a, int[] b, int s1, int e1, int s2, int e2) {
		if((e1 - s1) == 1 && (e2 - s2) == 1) {
			return (Math.max(a[s1], b[s2]) + Math.min(a[e1], b[e2])) / 2;
		}
		System.out.println(s1 + ", " + e1 + " and " + s2 + ", " + e2);
		int midIndex1 = s1 + (e1 - s1) / 2;
		int midIndex2 = s2 + (e2 - s2) / 2;
		System.out.println(midIndex1 + ", " + midIndex2);
		int mid1 = a[midIndex1];
		int mid2 = b[midIndex2];
		if(mid1 == mid2) {
			return mid1;
		}
		if(mid1 < mid2) {
			s1 = midIndex1;
			e2 = midIndex2;
		}
		else {
			s2 = midIndex2;
			e1 = midIndex1;
		}
		return findMedian(a, b, s1, e1, s2, e2);
	}
}

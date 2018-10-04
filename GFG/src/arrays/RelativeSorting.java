package arrays;

import java.util.*;

public class RelativeSorting {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
		for(int t = 1; t <= test; t++) {
			int m = in.nextInt();
			int n = in.nextInt();
			int[] arr1 = new int[m];
			int[] arr2 = new int[n];
			for(int i = 0; i < m; i++) {
				arr1[i] = in.nextInt();
			}
			for(int i = 0; i < n; i++) {
				arr2[i] = in.nextInt();
			}
			Map<Integer, Integer> map = new HashMap<>();
			for(int i = 0; i < m; i++) {
				int value = 1;
				if(map.containsKey(arr1[i])) {
					value = map.get(arr1[i]) + 1;
				}
				map.put(arr1[i], value);
			}
			int[] result = new int[m];
			int pos = 0;
			for(int i = 0; i < n; i++) {
				if(map.containsKey(arr2[i])) {
					int value = map.get(arr2[i]);
					while(value-- > 0) {
						result[pos++] = arr2[i];
					}
					map.remove(arr2[i]);
				}
			}
			Set<Integer> set = map.keySet();
			int[] temp = new int[m - pos];
			int i = 0;
			Iterator<Integer> iterator = set.iterator();
			while(iterator.hasNext()) {
				int key = iterator.next();
				int value = map.get(key);
				while(value-- > 0) {
					temp[i++] = key;
				}
			}
			Arrays.sort(temp);
			i = 0;
			while(pos < m) {
				result[pos++] = temp[i++];
			}
			for(i = 0; i < m; i++) 
				System.out.print(result[i] + " ");
			System.out.println();
		}
		in.close();
	}

}

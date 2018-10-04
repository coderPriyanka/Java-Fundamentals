package arrays;
import java.util.*;

public class TrappingRainWaterProblem {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
		for(int t = 1; t <= test; t++) {
			int n = in.nextInt();
			int[] towers = new int[n];
			for(int i = 0; i < n; i++) {
				towers[i] = in.nextInt();
			}
			int[] leftMaxTower = new int[n];
			int[] rightMaxTower = new int[n];
			int i = 0, j = n - 1;
			leftMaxTower[i++] = 0;
			rightMaxTower[j--] = 0;
			while(i < n) {
				leftMaxTower[i] = Math.max(towers[i - 1], leftMaxTower[i - 1]);
				rightMaxTower[j] = Math.max(towers[j + 1], rightMaxTower[j + 1]);
				i++;
				j--;
			}
			int totalRainWater = 0;
			for(i = 0; i < n; i++) {
				totalRainWater+= Math.max((Math.min(leftMaxTower[i], rightMaxTower[i]) - towers[i]), 0);
			}
			System.out.println(totalRainWater);
		}
		in.close();
	}

}

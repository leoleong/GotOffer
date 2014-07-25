package offer;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.Scanner;

public class _40_NumbersAppearOnce {

	// Scanner : TLE
	/*public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int T = sc.nextInt();
			int[] nums = new int[T];
			for (int i = 0; i < T; i++) {
				nums[i] = sc.nextInt();
			}
			numbersAppearOnce(nums);
		}
	}*/
	
	public static void main(String[] args) throws IOException {

		StreamTokenizer st = new StreamTokenizer(System.in);
		while (st.nextToken() != StreamTokenizer.TT_EOF) {
			int T = (int) st.nval;
			int[] nums = new int[T];
			for (int i = 0; i < T; i++) {
				st.nextToken();
				nums[i] = (int) st.nval;
			}
			numbersAppearOnce(nums);
		}
	}

	private static void numbersAppearOnce(int[] nums) {

		int value = 0;
		int group1 = 0;
		int group2 = 0;
		int pos = 0;
		for (int num : nums) {
			value ^= num;
		}
		for (int i = 0; i < 32; i++) {
			if ((value & (1 << i)) != 0) {
				pos = i;
				break;
			}
		}
		for (int num : nums) {
			if ((num & (1 << pos)) != 0) {
				group1 ^= num;
			} else {
				group2 ^= num;
			}
		}

		if (group1 < group2) {
			System.out.println(group1 + " " + group2);
		} else {
			System.out.println(group2 + " " + group1);
		}
	}
}

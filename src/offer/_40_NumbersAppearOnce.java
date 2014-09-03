package offer;

import java.io.IOException;
import java.io.StreamTokenizer;

public class _40_NumbersAppearOnce {

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
		int index = 0;

		// xor of 2 diffs
		for (int num : nums) {
			value ^= num;
		}
		// index different bit
		for (int i = 0; i < 32; i++) {
			if ((value & (1 << i)) != 0) {
				index = i;
				break;
			}
		}
		// seperate nums
		for (int num : nums) {
			if ((num & (1 << index)) != 0) {
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

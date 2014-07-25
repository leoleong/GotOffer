package offer;

import java.io.IOException;
import java.io.StreamTokenizer;

public class _29_MoreThanHalfNumber {

	public static void main(String[] args) throws IOException {

		StreamTokenizer st = new StreamTokenizer(System.in);
		while (st.nextToken() != StreamTokenizer.TT_EOF) {
			int T = (int) st.nval;
			int[] nums = new int[T];
			for (int i = 0; i < T; i++) {
				st.nextToken();
				nums[i] = (int) st.nval;
			}
//			int result = moreThanHalfNumber(nums, 0, T - 1);
			int result = moreThanHalfNumber(nums);
			System.out.println(result);
		}
	}

	// ---------------------------------------------------------------------------
	// 1. recursion : stackoverflow
	/*private static int moreThanHalfNumber(int[] nums, int start, int end) {

		int index = getPivot(nums, start, end);
		int mid = nums.length / 2;
		int result = -1;

		if (index == mid) {
			result = nums[index];
		} else if (index < mid) {
			result = moreThanHalfNumber(nums, index + 1, end);
		} else {
			result = moreThanHalfNumber(nums, start, index - 1);
		}

		return checkValidity(nums, result) ? result : -1;
	}*/

	// ---------------------------------------------------------------------------
	// 2. iteration
	private static int moreThanHalfNumber(int[] nums, int start, int end) {

		int index = getPivot(nums, start, end);
		int mid = nums.length / 2;
		int result = -1;

		while (index != mid) {
			if (index < mid) {
				start = index + 1;
			} else {
				end = index - 1;
			}
			index = getPivot(nums, start, end);
		}
		result = nums[index];

		return checkValidity(nums, result) ? result : -1;
	}

	// ---------------------------------------------------------------------------
	// 3. O(n)
	private static int moreThanHalfNumber(int[] nums) {

		int result = nums[0];
		int count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == result) {
				count++;
			} else {
				count--;
			}
			if (count == 0) {
				result = nums[i];
				count = 1;
			}
		}

		return checkValidity(nums, result) ? result : -1;
	}

	private static int getPivot(int[] nums, int start, int end) {

		int key = nums[end];
		int i = start - 1;
		for (int j = start; j < end; j++) {
			if (nums[j] < key) {
				swap(nums, ++i, j);
			}
		}
		swap(nums, ++i, end);

		return i;
	}

	private static void swap(int[] nums, int src, int dst) {

		int temp = nums[src];
		nums[src] = nums[dst];
		nums[dst] = temp;
	}

	private static boolean checkValidity(int[] nums, int result) {

		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == result) {
				count++;
			}
		}

		return 2 * count > nums.length;
	}
}

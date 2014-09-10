package offer.tree;

import java.io.IOException;

public class _24_SequenceOfBST {

	public static void main(String[] args) throws IOException {

		int[] nums = new int[] { 5, 7, 6, 9, 11, 10, 8 };
		boolean result = isPostOrderTraversal(nums, 0, nums.length - 1);
		System.out.println(result ? "Yes" : "No");
	}

	private static boolean isPostOrderTraversal(int[] nums, int start, int end) {

		if (start >= end) {
			return true;
		}

		int mid = start;
		while (nums[mid] < nums[end]) {
			mid++;
		}
		for (int i = mid; i < end; i++) {
			if (nums[i] < nums[end]) {
				return false;
			}
		}

		// divide & conquer
		boolean left = isPostOrderTraversal(nums, start, mid - 1);
		boolean right = isPostOrderTraversal(nums, mid, end - 1);

		return left && right;
	}
}

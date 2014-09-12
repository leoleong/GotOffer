package offer.bs;

import java.io.IOException;

public class _08_MinimumOfRotatedArray {

	public static void main(String[] args) throws IOException {

		int[] nums = new int[] { 1, 1, 1, 0, 1, 1 };
		int min = minimumOfRotatedArray(nums);
		System.out.println(min);
	}

	private static int minimumOfRotatedArray(int[] nums) {

		int start = 0;
		int end = nums.length - 1;
		int min = Integer.MAX_VALUE;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] == nums[start]) {
				// couldn't judge order
				start++;
			} else if (nums[mid] > nums[start]) {
				if (nums[start] >= nums[end]) {
					start = mid + 1;
				} else {
					return nums[start];
				}
			} else {
				end = mid - 1;
			}
			min = min < nums[mid] ? min : nums[mid];
		}

		return min;
	}
}

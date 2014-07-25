package offer;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.Scanner;

public class _08_MinimumOfRotatedArray {

	// Scanner : TLE
	/*
	 * public static void main(String[] args) {
	 * 
	 * Scanner sc = new Scanner(System.in); while (sc.hasNext()) { int T =
	 * sc.nextInt(); int[] nums = new int[T]; for (int i = 0; i < T; i++) {
	 * nums[i] = sc.nextInt(); }
	 * 
	 * int min = minimumOfRotatedArray(nums); System.out.println(min); } }
	 */

	public static void main(String[] args) throws IOException {

		StreamTokenizer st = new StreamTokenizer(System.in);
		while (st.nextToken() != StreamTokenizer.TT_EOF) {
			int T = (int) st.nval;
			int[] nums = new int[T];
			for (int i = 0; i < T; i++) {
				st.nextToken();
				nums[i] = (int) st.nval;
			}

			int min = minimumOfRotatedArray(nums);
			System.out.println(min);
		}
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
				// left is sorted
				if (nums[start] > nums[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			} else {
				// right is sorted
				end = mid - 1;
			}
			min = min < nums[mid] ? min : nums[mid];
		}

		return min;
	}
}

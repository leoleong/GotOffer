package offer;

import java.io.IOException;
import java.io.StreamTokenizer;

public class _31_GreatestSumOfSubarrays {

	public static void main(String[] args) throws IOException {

		StreamTokenizer st = new StreamTokenizer(System.in);
		while (st.nextToken() != StreamTokenizer.TT_EOF) {
			int T = (int) st.nval;
			if (T == 0) {
				return;
			}
			int[] nums = new int[T];
			for (int i = 0; i < T; i++) {
				st.nextToken();
				nums[i] = (int) st.nval;
			}
			greatestSumOfSubarrays(nums);
		}
	}

	private static void greatestSumOfSubarrays(int[] nums) {

		int length = nums.length;
		int[] dp = new int[length];
		dp[0] = nums[0];
		int max = dp[0];
		int start, end, tStart, tEnd;
		start = end = tStart = tEnd = 0;

		for (int i = 1; i < length; i++) {
			if (dp[i - 1] < 0) {
				dp[i] = nums[i];
				tStart = i;
			} else {
				dp[i] = dp[i - 1] + nums[i];
				tEnd = i;
			}
			if (dp[i] > max) {
				max = dp[i];
				start = tStart;
				end = tEnd;
			}
		}
		System.out.println(max + " " + start + " " + end);
	}
}

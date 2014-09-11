package offer;

public class _31_GreatestSumOfSubarrays {

	public static void main(String[] args) {

		int[] nums = new int[] { 1, -2, 3, 10, -4, 7, 2, -5 };
		greatestSumOfSubarrays(nums);
	}

	private static void greatestSumOfSubarrays(int[] nums) {

		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		int max = 0;
		int start, end, tStart, tEnd;
		start = end = tStart = tEnd = 0;

		for (int i = 1; i < nums.length; i++) {
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

		System.out.println("Max : " + max);
		System.out.println("Start : " + start);
		System.out.println("End : " + end);
	}
}

package offer.dp;

public class _34_UglyNumber {

	public static void main(String[] args) {

		int n = 5;
		int result = getUglyNumber(n);
		System.out.println(result);
	}

	public static int getUglyNumber(int n) {

		if (n == 0) {
			return 0;
		}
		
		int[] nums = new int[n + 1];
		nums[1] = 1;

		for (int i = 2; i < nums.length; i++) {
			int temp = Integer.MAX_VALUE;
			for (int j = i - 1; j > 0; j--) {
				int temp2 = nums[j] * 2;
				int temp3 = nums[j] * 3;
				int temp5 = nums[j] * 5;

				// pruning
				if (temp5 < nums[i - 1]) {
					break;
				}

				if (temp2 > nums[i - 1] && temp2 < temp) {
					temp = temp2;
				} else if (temp3 > nums[i - 1] && temp3 < temp) {
					temp = temp3;
				} else if (temp5 > nums[i - 1] && temp5 < temp) {
					temp = temp5;
				}

			}
			nums[i] = temp;
		}

		return nums[n];
	}
}

package offer.dp;

public class _34_UglyNumber {

	public static void main(String[] args) {

		int result = getUglyNumber(5);
		System.out.println(result);
	}

	public static int getUglyNumber(int index) {

		int[] nums = new int[index + 1];
		nums[0] = 1;

		for (int i = 1; i < nums.length; i++) {
			int current = Integer.MAX_VALUE;
			for (int j = i - 1; j >= 0; j--) {
				int temp5 = nums[j] * 5;
				int temp3 = nums[j] * 3;
				int temp2 = nums[j] * 2;

				if (temp5 < nums[i - 1]) {
					break;
				}

				if (temp5 > nums[i - 1] && temp5 < current) {
					current = temp5;
				}
				if (temp3 > nums[i - 1] && temp3 < current) {
					current = temp3;
				}
				if (temp2 > nums[i - 1] && temp2 < current) {
					current = temp2;
				}

			}
			nums[i] = current;
		}

		return nums[index];
	}
}

package offer.bs;

public class _38_GetNumberOfK {

	public static void main(String[] args) {

		int[] nums = new int[] { 1, 2, 3, 3, 3, 3, 4, 5 };
		int target = 3;
		int result = getNumberOfK(nums, target);
		System.out.println(result);
	}

	private static int getNumberOfK(int[] nums, int target) {
		int lower = getLowerK(nums, target);
		int higher = getHigherK(nums, target);

		return lower == -1 ? 0 : higher - lower + 1;
	}

	private static int getLowerK(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		int index = -1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				end = mid - 1;
				index = mid;
			} else if (nums[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return index;
	}

	private static int getHigherK(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		int index = -1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] == target) {
				start = mid + 1;
				index = mid;
			} else if (nums[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return index;
	}
}

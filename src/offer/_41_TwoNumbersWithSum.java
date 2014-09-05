package offer;

public class _41_TwoNumbersWithSum {

	public static void main(String[] args) {

		int[] array = new int[] { 1, 2, 4, 7, 11, 15 };
		int target = 27;
		boolean result = hasTwoSum(array, target);
		System.out.println(result);
	}

	private static boolean hasTwoSum(int[] array, int target) {

		if (array == null || array.length == 0) {
			return false;
		}

		int start = 0;
		int end = array.length - 1;

		while (start < end) {
			int sum = array[start] + array[end];
			if (sum == target) {
				return true;
			} else if (sum < target) {
				start++;
			} else {
				end--;
			}
		}

		return false;
	}
}

package offer;

import java.util.Arrays;

public class _44_ContinousCards {

	public static void main(String[] args) {

		int[] array = new int[] { 1, 2, 3, 4, 5 };
		boolean result = isContinous(array);
		System.out.println(result);
	}

	private static boolean isContinous(int[] array) {

		if (array == null || array.length != 5) {
			return false;
		}

		int wildCard = 0;
		Arrays.sort(array);
		int start;

		for (start = 0; start < array.length; ++start) {
			if (array[start] != 0) {
				break;
			}
			wildCard++;
		}

		for (int i = start + 1; i < array.length; i++) {
			if (array[i] == array[i - 1]) {
				return false;
			}
			wildCard -= array[i] - 1 - array[i - 1];
		}

		return wildCard >= 0;
	}
}

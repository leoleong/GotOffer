package offer.dc;

import java.util.Arrays;

public class _14_ReorderArray {

	public static void main(String[] args) {

		int[] array = new int[] { 4, 6, 8, 1, 3, 5 };
		reorder(array);
		System.out.println(Arrays.toString(array));
	}

	private static void reorder(int[] array) {

		if (array == null || array.length <= 1) {
			return;
		}

		partition(array);
	}

	private static void partition(int[] array) {

		int i = -1;
		for (int j = 0; j < array.length; j++) {
			if (array[j] % 2 == 1) {
				i++;
				swap(array, i, j);
			}
		}
	}

	private static void swap(int[] array, int src, int dst) {

		int temp = array[src];
		array[src] = array[dst];
		array[dst] = temp;
	}
}

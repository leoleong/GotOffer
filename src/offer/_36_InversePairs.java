package offer;

import java.util.Arrays;

public class _36_InversePairs {

	public static void main(String[] args) {

		int[] array = new int[] { 7, 5, 6, 4 };
		int result = computePairs(array);
		System.out.println(result);
	}

	public static int computePairs(int[] array) {

		if (array == null || array.length <= 1) {
			return 0;
		}

		int result = mergeSort(array, 0, array.length - 1);

		return result;
	}

	private static int mergeSort(int[] array, int start, int end) {

		if (start >= end) {
			return 0;
		}

		int sum = 0;
		int mid = start + (end - start) / 2;
		sum += mergeSort(array, start, mid);
		sum += mergeSort(array, mid + 1, end);
		sum += merge(array, start, mid, end);

		return sum;
	}

	private static int merge(int[] array, int start, int mid, int end) {

		int[] L = Arrays.copyOfRange(array, start, mid + 1);
		int[] R = Arrays.copyOfRange(array, mid + 1, end + 1);
		int sum = 0;
		int k = start;
		int i = 0;
		int j = 0;

		while (i < L.length && j < R.length) {
			if (L[i] > R[j]) {
				sum += L.length - i;
				array[k++] = R[j++];
			} else {
				array[k++] = L[i++];
			}
		}
		while (i < L.length) {
			array[k++] = L[i++];
		}
		while (j < R.length) {
			array[k++] = R[j++];
		}

		return sum;
	}
}

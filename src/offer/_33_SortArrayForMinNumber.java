package offer;

public class _33_SortArrayForMinNumber {

	public static void main(String[] args) {

		int[] array = { 23456, 56 };
		String result = printMinNumber(array);
		System.out.println(result);
	}

	public static String printMinNumber(int[] array) {

		quickSort(array, 0, array.length - 1);
		StringBuilder sb = new StringBuilder();
		for (int arr : array) {
			sb.append(arr);
		}

		return sb.toString();
	}

	private static void quickSort(int[] array, int start, int end) {

		if (start >= end) {
			return;
		}

		int pivot = partition(array, start, end);
		quickSort(array, start, pivot - 1);
		quickSort(array, pivot + 1, end);
	}

	private static int partition(int[] array, int start, int end) {

		int i = start - 1;
		for (int j = start; j < end; j++) {
			if (compare(array[j], array[end]) < 0) {
				i++;
				swap(array, i, j);
			}
		}
		i++;
		swap(array, i, end);

		return i;
	}

	private static int compare(int src, int dst) {

		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		sb1.append(src).append(src);
		sb2.append(dst).append(src);

		for (int i = 0; i < sb1.length(); i++) {
			if (sb1.charAt(i) < sb2.charAt(i)) {
				return -1;
			} else if (sb1.charAt(i) > sb2.charAt(i)) {
				return 1;
			}
		}

		return 0;
	}

	private static void swap(int[] array, int src, int dst) {

		int temp = array[src];
		array[src] = array[dst];
		array[dst] = temp;
	}
}

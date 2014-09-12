package offer;

public class _03_FindinPartiallySortedMatrix {

	public static void main(String[] args) {

		int[][] array = new int[][] { { 1, 2, 8, 9 }, { 2, 4, 9, 12 },
				{ 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
		int target = 7;
		boolean exist = search(array, target);
		System.out.println(exist);
	}

	private static boolean search(int[][] array, int target) {

		if (array == null || array.length < 1) {
			return false;
		}

		int i = 0;
		int j = array[0].length - 1;

		while (i < array.length && j >= 0) {
			if (array[i][j] > target) {
				j--;
			} else if (array[i][j] < target) {
				i++;
			} else {
				return true;
			}
		}

		return false;
	}
}

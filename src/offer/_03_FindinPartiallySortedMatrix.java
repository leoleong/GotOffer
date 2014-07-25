package offer;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.Scanner;

public class _03_FindinPartiallySortedMatrix {

	// TLE
	/*public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int row = sc.nextInt();
			int column = sc.nextInt();
			int target = sc.nextInt();

			int[][] array = new int[row][column];
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					array[i][j] = sc.nextInt();
				}
			}

			boolean exist = search(array, target);
			System.out.println(exist ? "Yes" : "No");
		}
	}*/

	public static void main(String[] args) throws IOException {

		StreamTokenizer st = new StreamTokenizer(System.in);
		while (st.nextToken() != StreamTokenizer.TT_EOF) {
			int row = (int) st.nval;
			st.nextToken();
			int column = (int) st.nval;
			st.nextToken();
			int target = (int) st.nval;

			int[][] array = new int[row][column];
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					st.nextToken();
					array[i][j] = (int) st.nval;
				}
			}

			boolean exist = search(array, target);
			System.out.println(exist ? "Yes" : "No");
		}
	}

	private static boolean search(int[][] array, int target) {

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

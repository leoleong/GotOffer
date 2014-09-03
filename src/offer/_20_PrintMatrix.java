package offer;

import java.util.ArrayList;
import java.util.List;

public class _20_PrintMatrix {

	public static void main(String[] args) {

		int[][] matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 },
				{ 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		printMatrixClockWise(matrix);
	}

	private static void printMatrixClockWise(int[][] matrix) {
		if (matrix == null) {
			return;
		}

		int startRow = 0;
		int endRow = matrix.length - 1;
		int startCol = 0;
		int endCol = matrix[0].length - 1;
		List<Integer> result = new ArrayList<Integer>();

		while (true) {
			for (int i = startCol; i <= endCol; i++) {
				result.add(matrix[startRow][i]);
			}
			if (++startRow > endRow) {
				break;
			}
			for (int i = startRow; i <= endRow; i++) {
				result.add(matrix[i][endCol]);
			}
			if (--endCol < startCol) {
				break;
			}
			for (int i = endCol; i >= startCol; i--) {
				result.add(matrix[endRow][i]);
			}
			if (--endRow < startRow) {
				break;
			}
			for (int i = endRow; i >= startRow; i--) {
				result.add(matrix[i][startCol]);
			}
			if (++startCol > endCol) {
				break;
			}
		}

		System.out.println(result.toString());
	}
}

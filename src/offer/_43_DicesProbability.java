package offer;

import java.util.Arrays;

public class _43_DicesProbability {

	public static void main(String[] args) {

		int n = 11;
		int sides = 6;
		double[] probability = calculateProbability(n, sides);

		for (int i = n; i <= 6 * n; i++) {
			System.out.println(i + " " + probability[i]);
		}
	}

	private static double[] calculateProbability(int n, int sides) {

		if (n <= 0) {
			return null;
		}

		int[][] array = new int[2][sides * n + 1];
		for (int i = 1; i <= 6; i++) {
			array[1][i] = 1;
		}

		for (int i = 2; i <= n; i++) {
			Arrays.fill(array[i % 2], 0);
			for (int j = sides * i; j >= i; j--) {
				for (int k = sides; k > 0; k--) {
					if (j - k >= i - 1) {
						array[i % 2][j] += array[(i + 1) % 2][j - k];
					}
				}
			}
		}

		double[] probability = new double[sides * n + 1];
		for (int i = n; i <= sides * n; i++) {
			probability[i] = (double) array[n % 2][i] / Math.pow(sides, n);
		}

		return probability;
	}
}

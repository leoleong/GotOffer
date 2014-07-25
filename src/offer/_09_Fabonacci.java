package offer;

import java.util.Scanner;

public class _09_Fabonacci {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			long result = Fabonacci(n);
			System.out.println(result);
		}
	}

	// result should be long, otherwise might cross boarder
	private static long Fabonacci(int n) {

		long[] result = new long[] { 0, 1 };
		if (n < 2) {
			return result[n];
		}

		for (int i = 2; i <= n; i++) {
			long fab = result[1];
			result[1] = result[0] + result[1];
			result[0] = fab;
		}

		return result[1];
	}
}

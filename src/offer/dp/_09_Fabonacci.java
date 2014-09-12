package offer.dp;

public class _09_Fabonacci {

	public static void main(String[] args) {

		int n = 4;
		long result = Fabonacci(n);
		System.out.println(result);
	}

	// result should be long, otherwise might overflow
	private static long Fabonacci(int n) {

		if (n < 1) {
			return 0;
		}

		long[] fab = new long[n + 1];
		fab[1] = 1;

		for (int i = 2; i <= n; i++) {
			fab[i] = fab[i - 1] + fab[i - 2];
		}

		return fab[n];
	}
}

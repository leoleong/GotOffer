package offer.dc;

public class _11_Power {

	public static void main(String[] args) {

		double base = 2;
		int exponent = 0;
		double result = pow(base, exponent);
		System.out.println(result);
	}

	private static double pow(double base, int exponent) {

		long exp = exponent;

		if (exp >= 0) {
			return power(base, exp);
		} else {
			return 1 / power(base, -exp);
		}
	}

	private static double power(double base, long exponent) {

		if (exponent == 0) {
			return 1;
		}
		if (exponent == 1) {
			return base;
		}

		double half = power(base, exponent >> 1);
		if ((exponent & 1) == 0) {
			return half * half;
		} else {
			return half * half * base;
		}
	}
}

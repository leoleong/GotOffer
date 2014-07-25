package offer;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;

public class _11_Power {

	// cost too much time for formation, go over leetcode.pow instead
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			BigDecimal base = new BigDecimal(sc.next());
			int exponent = sc.nextInt();
			double result = power(base, exponent);
			System.out.println(result);
		}
	}

	private static double power(BigDecimal base, int exponent) {

		double result = base.doubleValue();
		return result;
//		if (result == 0) {
//			return result;
//		}
//		
//		return 1;
	}
}

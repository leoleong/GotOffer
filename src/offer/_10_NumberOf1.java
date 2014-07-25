package offer;

import java.util.Scanner;

public class _10_NumberOf1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();
			int result = numberOf1(n);
			System.out.println(result);
		}
	}

	private static int numberOf1(int n) {

		int count = 0;
		for (int i = 0; i < 32; i++) {
			if ((n & (1 << i)) != 0) {
				count++;
			}
		}

		return count;
	}
}

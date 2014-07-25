package offer;

import java.util.Scanner;

public class _47_AddTwoNumbers {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int op1 = sc.nextInt();
			int op2 = sc.nextInt();
			int result = addTwoNumbers(op1, op2);
			System.out.println(result);
		}
	}

	private static int addTwoNumbers(int op1, int op2) {

		int value = 0;
		int carry = 0;
		do {
			value = op1 ^ op2;
			carry = (op1 & op2) << 1;
			op1 = value;
			op2 = carry;
		} while (carry != 0);

		return value;
	}
}

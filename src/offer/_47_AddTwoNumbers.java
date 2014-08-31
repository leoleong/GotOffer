package offer;

public class _47_AddTwoNumbers {

	public static void main(String[] args) {

		int op1 = -1;
		int op2 = 1;
		int result = addTwoNumbers(op1, op2);
		System.out.println(result);
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

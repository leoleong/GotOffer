package offer;

public class _49_StringToInt {

	public static void main(String[] args) throws Exception {

		System.out.println(Integer.MAX_VALUE);
		String str = "  2147483648  ";
		int result = atoi(str);
		System.out.println(result);
	}

	private static int atoi(String str) throws Exception {

		if (str == null || str.length() < 1) {
			throw new Exception("Invalid String");
		}

		int MAX = Integer.MAX_VALUE;
		int sign = 1;
		int num = 0;
		int start = 0;
		int end = str.length() - 1;

		while (start <= end && str.charAt(start) == ' ') {
			start++;
		}
		while (start <= end && str.charAt(end) == ' ') {
			end--;
		}
		if (start >= end) {
			throw new Exception("Invalid String");
		}

		if (str.charAt(start) == '-') {
			sign = -1;
			start++;
		} else if (str.charAt(start) == '+') {
			start++;
		}

		for (int i = start; i <= end; i++) {
			char ch = str.charAt(i);
			if (ch < '0' || ch > '9') {
				throw new Exception("Invalid String");
			}
			if (num > MAX / 10
					|| (num == MAX / 10 && (sign > 0 ? ch - '0' > MAX % 10
							: ch - '0' > MAX % 10 + 1))) {
				throw new Exception("Overflow");
			}
			num = num * 10 + ch - '0';
		}

		return sign * num;
	}
}

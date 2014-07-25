package offer;

import java.util.Scanner;

public class _04_ReplaceBlank {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		char[] source = str.toCharArray();
		char[] transformed = replaceBlank(source);
		
		System.out.println(new String(transformed));
	}

	private static char[] replaceBlank(char[] source) {

		int count = 0;
		for (char ch : source) {
			if (ch == ' ') {
				count++;
			}
		}
		char[] transformed = new char[source.length + 2 * count];

		int j = transformed.length - 1;
		for (int i = source.length - 1; i >= 0; i--) {
			if (source[i] == ' ') {
				transformed[j--] = '0';
				transformed[j--] = '2';
				transformed[j--] = '%';
			} else {
				transformed[j--] = source[i];
			}
		}

		return transformed;
	}
}

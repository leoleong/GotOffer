package offer.dfs;

import java.util.ArrayList;
import java.util.List;

public class _12_Print1ToMaxOfDigits {

	public static void main(String[] args) {
		
		List<String> result = new ArrayList<String>();
		StringBuilder path = new StringBuilder();
		int n = 5;
		int start = 0;
		
		generateNumbers(result, path, n, start);

		System.out.println(result.toString());
	}

	private static void generateNumbers(List<String> result,
			StringBuilder path, int n, int start) {
		
		if (start == n) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < path.length(); i++) {
				char ch = path.charAt(i);
				if (ch == '0' && sb.length() == 0) {
					continue;
				}
				sb.append(ch);
			}
			if (sb.length() != 0) {
				result.add(sb.toString());
			}
			return;
		}

		for (char ch = '0'; ch <= '9'; ch++) {
			path.append(ch);
			generateNumbers(result, path, n, start + 1);
			path.deleteCharAt(path.length() - 1);
		}
	}
}

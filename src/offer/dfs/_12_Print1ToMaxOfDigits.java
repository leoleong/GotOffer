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
			StringBuilder ret = new StringBuilder();
			for (int i = 0; i < path.length(); i++) {
				char ch = path.charAt(i);
				if (ch == '0' && ret.length() == 0) {
					continue;
				}
				ret.append(ch);
			}
			if (ret.length() != 0) {
				result.add(ret.toString());
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

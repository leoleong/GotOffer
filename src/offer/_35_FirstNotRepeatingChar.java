package offer;

import java.util.HashMap;
import java.util.Map;

public class _35_FirstNotRepeatingChar {

	public static void main(String[] args) {

		String str = "abaccdeff";
		char[] chars = str.toCharArray();
		char ch = firstNotRepeatingChar(chars);
		System.out.println(ch);
	}

	private static char firstNotRepeatingChar(char[] chars) {

		if (chars == null || chars.length == 0) {
			return Character.MAX_VALUE;
		}

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < chars.length; i++) {
			char ch = chars[i];
			if (map.containsKey(ch)) {
				int val = map.get(ch);
				map.put(ch, ++val);
			} else {
				map.put(ch, 1);
			}
		}
		for (int i = 0; i < chars.length; i++) {
			char ch = chars[i];
			if (map.get(ch) == 1) {
				return ch;
			}
		}

		return Character.MAX_VALUE;
	}
}

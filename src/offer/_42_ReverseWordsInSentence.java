package offer;

import java.util.Arrays;

public class _42_ReverseWordsInSentence {

	public static void main(String[] args) {

		String str = "Talk is cheap.";
		char[] words = str.toCharArray();

		char[] result = reverse(words);

		System.out.println(Arrays.toString(result));
	}

	private static char[] reverse(char[] words) {

		if (words == null || words.length <= 1) {
			return words;
		}

		int start = 0;
		int end = words.length - 1;

		reverse(words, start, end);
		for (int i = 0; i < words.length; i++) {
			if (words[i] == ' ') {
				end = i - 1;
				reverse(words, start, end);
				start = i + 1;
			} else if (i == words.length - 1) {
				end = i;
				reverse(words, start, end);
			}
		}

		return words;
	}

	private static void reverse(char[] chars, int start, int end) {

		while (start < end) {
			swap(chars, start++, end--);
		}
	}

	private static void swap(char[] chars, int src, int dst) {

		char temp = chars[src];
		chars[src] = chars[dst];
		chars[dst] = temp;
	}
}

package offer;

import java.util.Arrays;

public class _42_LeftRotateString {

	public static void main(String[] args) {

		String str = "abcdefg";
		char[] seqs = str.toCharArray();
		int k = 2;

		reverse(seqs, k);

		System.out.println(Arrays.toString(seqs));
	}

	private static char[] reverse(char[] seqs, int k) {

		if (seqs == null || seqs.length <= 1) {
			return seqs;
		}

		k = k % seqs.length;

		reverse(seqs, 0, seqs.length - 1);
		reverse(seqs, 0, seqs.length - 1 - k);
		reverse(seqs, seqs.length - k, seqs.length - 1);

		return seqs;
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

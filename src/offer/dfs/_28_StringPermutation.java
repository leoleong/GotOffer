package offer.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _28_StringPermutation {

	public static void main(String[] args) {

		String str = "aabc";
		char[] array = str.toCharArray();
		List<String> result = permute(array);
		System.out.println(result);
	}

	private static List<String> permute(char[] array) {

		if (array == null || array.length == 0) {
			return new ArrayList<String>();
		}

		List<String> result = new ArrayList<String>();
		StringBuilder path = new StringBuilder();
		boolean[] isUsed = new boolean[array.length];

		// in case of duplicates
		Arrays.sort(array);
		generatePath(result, path, array, isUsed);

		return result;
	}

	private static void generatePath(List<String> result, StringBuilder path,
			char[] array, boolean[] isUsed) {

		if (path.length() == array.length) {
			result.add(path.toString());
			return;
		}

		for (int i = 0; i < array.length; i++) {
			if (i > 0 && array[i] == array[i - 1] && !isUsed[i - 1]) {
				continue;
			}
			if (!isUsed[i]) {
				isUsed[i] = true;
				path.append(array[i]);
				generatePath(result, path, array, isUsed);
				path.deleteCharAt(path.length() - 1);
				isUsed[i] = false;
			}
		}
	}
}

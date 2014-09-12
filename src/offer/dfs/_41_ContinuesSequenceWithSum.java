package offer.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _41_ContinuesSequenceWithSum {

	public static void main(String[] args) {

		int[] array = new int[] { 1, 2, 3, 4, 5, 6 };
		int target = 7;
		List<List<Integer>> result = findSequence(array, target);
		System.out.println(result.toString());
	}

	private static List<List<Integer>> findSequence(int[] array, int target) {

		if (array == null || array.length == 0) {
			return new ArrayList<List<Integer>>();
		}

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();

		Arrays.sort(array);
		dfs(result, path, array, target, 0);

		return result;
	}

	private static void dfs(List<List<Integer>> result, List<Integer> path,
			int[] array, int target, int start) {

		if (target == 0) {
			result.add(new ArrayList<Integer>(path));
			return;
		}

		for (int i = start; i < array.length; i++) {
			if (array[i] > target) {
				return;
			}
			path.add(array[i]);
			dfs(result, path, array, target - array[i], i + 1);
			path.remove(path.size() - 1);
		}
	}
}

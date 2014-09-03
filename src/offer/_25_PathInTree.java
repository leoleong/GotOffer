package offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class _25_PathInTree {

	public static void main(String[] args) {

		int[] array = new int[] { 10, 5, 12, 4, 7 };
		TreeNode root = parseTree(array);
		int sum = 22;
		List<List<Integer>> result = generatePath(root, sum);
		System.out.println(result.toString());
	}

	private static List<List<Integer>> generatePath(TreeNode root, int sum) {

		if (root == null) {
			return new ArrayList<List<Integer>>();
		}

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();
		generatePath(result, path, root, sum);

		return result;
	}

	private static void generatePath(List<List<Integer>> result,
			List<Integer> path, TreeNode root, int sum) {

		if (root == null) {
			return;
		}

		path.add(root.val);
		if (root.left == null && root.right == null && sum == root.val) {
			result.add(new ArrayList<Integer>(path));
		}

		generatePath(result, path, root.left, sum - root.val);
		generatePath(result, path, root.right, sum - root.val);
		path.remove(path.size() - 1);
	}

	private static TreeNode parseTree(int[] array) {

		if (array == null || array.length == 0) {
			return null;
		}

		int NIL = -1;
		int count = 1;
		Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
		TreeNode root = new TreeNode(array[0]);
		queue.offer(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (count < array.length && array[count] != NIL) {
					node.left = new TreeNode(array[count]);
					queue.offer(node.left);
				}
				count++;
				if (count < array.length && array[count] != NIL) {
					node.right = new TreeNode(array[count]);
					queue.offer(node.right);
				}
				count++;
			}
		}

		return root;
	}

	private static class TreeNode {
		int val;
		TreeNode left, right;

		TreeNode(int val) {
			this.val = val;
		}
	}
}

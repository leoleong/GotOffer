package offer.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class _18_SubstructureInTree {

	public static void main(String[] args) {

		int[] array1 = new int[] { 8, 8, 7, 9, 2, -1, -1, -1, -1, 4, 7 };
		int[] array2 = new int[] { 8, 9, 2 };
		TreeNode root = parseTree(array1);
		TreeNode subRoot = parseTree(array2);

		boolean result = traversal(root, subRoot);
		System.out.println(result);
	}

	private static boolean traversal(TreeNode root, TreeNode subRoot) {

		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();

		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				boolean result = hasSubTree(root, subRoot);
				if (result) {
					return true;
				}
				stack.push(root);
				root = root.left;
			} else {
				root = stack.pop();
				root = root.right;
			}
		}

		return false;
	}

	private static boolean hasSubTree(TreeNode root, TreeNode subRoot) {

		if (subRoot == null) {
			return true;
		}
		if (root == null) {
			return false;
		}

		boolean left = hasSubTree(root.left, subRoot.left);
		boolean right = hasSubTree(root.right, subRoot.right);

		return root.val == subRoot.val && left && right;
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

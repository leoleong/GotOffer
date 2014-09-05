package offer.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class _23_BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 3, -1, -1, 4, 5, 6, 7, 8, 9 };
		TreeNode root = parseTree(array);

		levelOrderTraversal(root);
	}

	private static void levelOrderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Queue<TreeNode> queue = new ArrayDeque<TreeNode>();

		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> level = new ArrayList<Integer>();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				level.add(node.val);
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			result.add(level);
		}

		System.out.println(result.toString());
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

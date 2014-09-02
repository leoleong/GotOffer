package offer;

import java.io.IOException;

public class _39_TreeDepth {

	public static void main(String[] args) throws IOException {

	}

	private static int treeDepth(TreeNode root) {

		// convergence condition
		if (root == null) {
			return 0;
		}

		int left = treeDepth(root.left);
		int right = treeDepth(root.right);

		return Math.max(left, right) + 1;
	}

	private class TreeNode {
		int val;
		TreeNode left, right;

		TreeNode(int val) {
			this.val = val;
		}
	}
}

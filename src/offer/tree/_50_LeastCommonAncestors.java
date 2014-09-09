package offer.tree;

public class _50_LeastCommonAncestors {

	public static void main(String[] args) {

	}

	private static TreeNode getLCA(TreeNode root, TreeNode node1, TreeNode node2) {

		if (root == null || root == node1 || root == node2) {
			return root;
		}

		// divide
		TreeNode left = getLCA(root.left, node1, node2);
		TreeNode right = getLCA(root.right, node1, node2);

		// conquer
		if (left != null && right != null) {
			return root;
		}

		return left != null ? left : right;
	}

	private static class TreeNode {
		int val;
		TreeNode left, right;

		TreeNode(int val) {
			this.val = val;
		}
	}
}

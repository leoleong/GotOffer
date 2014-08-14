package offer;

public class _27_BinarySearchTreetoDoublyLinkedList {

	public static void main(String[] args) {

	}

	public static TreeNode preorderTreeToList(TreeNode root) {
		if (root == null) {
			return root;
		}

		TreeNode lHead = preorderTreeToList(root.left);
		TreeNode rHead = preorderTreeToList(root.right);

		TreeNode node = lHead;
		while (node != null && node.right != null) {
			node = node.right;
		}
		if (node == null) {
			root.right = rHead;
			rHead.left = root;
		} else {
			root.right = lHead;
			lHead.left = root;
			node.right = rHead;
			rHead.left = node;
		}

		return root;
	}

	public static TreeNode inorderTreeToList(TreeNode root) {
		if (root == null) {
			return root;
		}

		TreeNode lHead = inorderTreeToList(root.left);
		TreeNode rHead = inorderTreeToList(root.right);

		TreeNode node = lHead;
		while (node != null && node.right != null) {
			node = node.right;
		}
		if (node != null) {
			node.right = root;
		}
		root.left = node;
		if (rHead != null) {
			rHead.left = root;
		}
		root.right = rHead;

		return lHead == null ? root : lHead;
	}

	// Definition for binary tree
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}

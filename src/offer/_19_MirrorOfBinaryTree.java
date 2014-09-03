package offer;

public class _19_MirrorOfBinaryTree {

	public static void main(String[] args) {

	}

	private static TreeNode generateMirrorTree(TreeNode root) {
		if (root == null) {
			return null;
		}

		TreeNode mirrorRoot = new TreeNode(root.val);
		mirrorRoot.right = generateMirrorTree(root.left);
		mirrorRoot.left = generateMirrorTree(root.right);

		return mirrorRoot;
	}

	private static class TreeNode {
		int val;
		TreeNode left, right;

		TreeNode(int val) {
			this.val = val;
		}
	}
}

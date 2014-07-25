package offer;

import java.io.IOException;
import java.io.StreamTokenizer;

public class _06_ConstructBinaryTree {

	private static boolean isValid;
	private static String result;

	public static void main(String[] args) throws IOException {

		StreamTokenizer st = new StreamTokenizer(System.in);
		while (st.nextToken() != StreamTokenizer.TT_EOF) {
			int T = (int) st.nval;
			int[] preorder = new int[T];
			int[] inorder = new int[T];
			for (int i = 0; i < preorder.length; i++) {
				st.nextToken();
				preorder[i] = (int) st.nval;
			}
			for (int i = 0; i < inorder.length; i++) {
				st.nextToken();
				inorder[i] = (int) st.nval;
			}
			
			isValid = true;
			result = "";
			TreeNode root = buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
			postorderTraversal(root);
			System.out.println(isValid ? result : "No");
		}
	}

	private static TreeNode buildTree(int[] preorder, int[] inorder, int preFirst, int preLast, int inFirst, int inLast) {

		if (preFirst > preLast || inFirst > inLast) {
			return null;
		}

		TreeNode root = new TreeNode(preorder[preFirst]);
		int inRootPos = -1;
		for (int i = inFirst; i <= inLast; i++) {
			if (inorder[i] == root.val) {
				inRootPos = i;
				break;
			}
		}
		if (inRootPos == -1) {
			isValid = false;
			return null;
		}
		int distance = inRootPos - inFirst;

		root.left = buildTree(preorder, inorder, preFirst + 1, preFirst + distance, inFirst, inRootPos - 1);
		root.right = buildTree(preorder, inorder, preFirst + distance + 1, preLast, inRootPos + 1, inLast);

		return root;
	}

	private static void postorderTraversal(TreeNode root) {

		if (root == null) {
			return;
		}
		postorderTraversal(root.left);
		postorderTraversal(root.right);
		result += root.val + " ";
	}

	// Definition for binary tree
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}

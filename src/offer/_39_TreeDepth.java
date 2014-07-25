package offer;

import java.io.IOException;
import java.io.StreamTokenizer;

public class _39_TreeDepth {

	// use sequential storage structure instead of linked storage structure for
	// tree
	public static void main(String[] args) throws IOException {

		StreamTokenizer st = new StreamTokenizer(System.in);
		while (st.nextToken() != StreamTokenizer.TT_EOF) {
			int T = (int) st.nval;
			int[] leftNode = new int[T + 1];
			int[] rightNode = new int[T + 1];
			for (int i = 1; i <= T; i++) {
				st.nextToken();
				leftNode[i] = (int) st.nval;
				st.nextToken();
				rightNode[i] = (int) st.nval;
			}

			int result = treeDepth(leftNode, rightNode, 1);
			System.out.println(result);
		}
	}

	private static int treeDepth(int[] leftNode, int[] rightNode, int root) {

		// convergence condition
		if (root == -1) {
			return 0;
		}
		
		int left = treeDepth(leftNode, rightNode, leftNode[root]);
		int right = treeDepth(leftNode, rightNode, rightNode[root]);
		
		return Math.max(left, right) + 1;
	}
}

package offer;

import java.io.IOException;
import java.io.StreamTokenizer;

public class _18_SubstructureInTree {

	private static int[] pNode, plNode, prNode, cNode, clNode, crNode;

	public static void main(String[] args) throws IOException {

		StreamTokenizer st = new StreamTokenizer(System.in);
		while (st.nextToken() != StreamTokenizer.TT_EOF) {
			int N = (int) st.nval;
			st.nextToken();
			int M = (int) st.nval;
			pNode = new int[N + 1];
			plNode = new int[N + 1];
			prNode = new int[N + 1];
			cNode = new int[M + 1];
			clNode = new int[M + 1];
			crNode = new int[M + 1];
			for (int i = 1; i <= N; i++) {
				st.nextToken();
				pNode[i] = (int) st.nval;
			}
			for (int i = 1; i <= M; i++) {
				st.nextToken();
				cNode[i] = (int) st.nval;
			}
			for (int i = 1; i <= N; i++) {
				st.nextToken();
				int val = (int) st.nval;
				if (val == 0) {
					plNode[i] = prNode[i] = -1;
				} else if (val == 2) {
					st.nextToken();
					plNode[i] = (int) st.nval;
					st.nextToken();
					prNode[i] = (int) st.nval;
				}
			}
			for (int i = 1; i <= M; i++) {
				st.nextToken();
				int val = (int) st.nval;
				if (val == 0) {
					clNode[i] = crNode[i] = -1;
				} else if (val == 2) {
					st.nextToken();
					clNode[i] = (int) st.nval;
					st.nextToken();
					crNode[i] = (int) st.nval;
				}
			}
			boolean result = traversal(1, 1);
			System.out.println(result ? "Yes" : "No");
		}
	}

	private static boolean traversal(int pRoot, int cRoot) {

		boolean hasSubTree = false;
		if (pNode[pRoot] != -1 && cNode[cRoot] != -1) {
			if (pNode[pRoot] == cNode[cRoot]) {
				hasSubTree = hasSubTree(pRoot, cRoot);
			}
			if (!hasSubTree) {
				hasSubTree = traversal(plNode[pRoot], cRoot) || traversal(prNode[pRoot], cRoot);
			}
		}

		return hasSubTree;
	}

	private static boolean hasSubTree(int pRoot, int cRoot) {

		// convergence condition
		if (cNode[cRoot] == -1) {
			return true;
		}
		// pruning condition
		if (pNode[pRoot] == -1) {
			return false;
		}

		return pNode[pRoot] == cNode[cRoot] && hasSubTree(plNode[pRoot], clNode[cRoot]) && hasSubTree(prNode[pRoot], crNode[cRoot]);
	}
}

package offer;

import java.io.IOException;
import java.io.StreamTokenizer;

public class _24_SequenceOfBST {

	public static void main(String[] args) throws IOException {

		StreamTokenizer st = new StreamTokenizer(System.in);
		while (st.nextToken() != StreamTokenizer.TT_EOF) {
			int T = (int) st.nval;
			int[] nums = new int[T];
			for (int i = 0; i < T; i++) {
				st.nextToken();
				nums[i] = (int) st.nval;
			}

			boolean result = isPostOrderTraversal(nums, 0, T - 1);
			System.out.println(result ? "Yes" : "No");
		}
	}

	private static boolean isPostOrderTraversal(int[] nums, int start, int end) {

		if (start >= end) {
			return true;
		}
		
		int mid = start;
		while (nums[mid] < nums[end]) {
			mid++;
		}
		for (int i = mid; i < end; i++) {
			if (nums[i] < nums[end]) {
				return false;
			}
		}

		return isPostOrderTraversal(nums, start, mid - 1) && isPostOrderTraversal(nums, mid, end - 1);
	}
}

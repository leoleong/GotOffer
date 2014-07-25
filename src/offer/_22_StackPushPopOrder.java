package offer;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.ArrayDeque;
import java.util.Deque;

public class _22_StackPushPopOrder {

	public static void main(String[] args) throws IOException {

		StreamTokenizer st = new StreamTokenizer(System.in);
		while (st.nextToken() != StreamTokenizer.TT_EOF) {
			int T = (int) st.nval;
			int[] pushSeq = new int[T];
			int[] popSeq = new int[T];
			for (int i = 0; i < T; i++) {
				st.nextToken();
				pushSeq[i] = (int) st.nval;
			}
			for (int i = 0; i < T; i++) {
				st.nextToken();
				popSeq[i] = (int) st.nval;
			}
			boolean result = isPopOrder(pushSeq, popSeq);
			System.out.println(result ? "Yes" : "No");
		}
	}

	private static boolean isPopOrder(int[] pushSeq, int[] popSeq) {

		int length = pushSeq.length;
		Deque<Integer> stack = new ArrayDeque<Integer>(length);

		int i = 0;
		int j = 0;
		while (i < length) {
			stack.push(pushSeq[i]);
			while (!stack.isEmpty() && stack.peek() == popSeq[j]) {
				stack.pop();
				j++;
			}
			i++;
		}

		return stack.isEmpty() ? true : false;
	}
}

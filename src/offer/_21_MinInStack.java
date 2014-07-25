package offer;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.ArrayDeque;
import java.util.Deque;

public class _21_MinInStack {

	public static void main(String[] args) throws IOException {

		StreamTokenizer st = new StreamTokenizer(System.in);
		Stack stack = new Stack();
		while (st.nextToken() != StreamTokenizer.TT_EOF) {
			int T = (int) st.nval;
			for (int i = 0; i < T; i++) {
				st.nextToken();
				String ch = st.sval;
				if (ch.equals("s")) {
					st.nextToken();
					int val = (int) st.nval;
					stack.push(val);
				} else {
					stack.pop();
				}
				System.out.println(stack.min());
			}
		}
	}

	static class Stack {
		Deque<Integer> master;
		Deque<Integer> assit;

		Stack() {
			master = new ArrayDeque<Integer>();
			assit = new ArrayDeque<Integer>();
		}

		void push(int val) {
			master.push(val);
			if (assit.isEmpty() || assit.peek() > val) {
				assit.push(val);
			} else {
				assit.push(assit.peek());
			}
		}

		int pop() {
			if (master.isEmpty()) {
				return -1;
			} else {
				assit.pop();
				return master.pop();
			}
		}

		String min() {
			if (assit.isEmpty()) {
				return "NULL";
			} else {
				return assit.peek().toString();
			}
		}
	}
}

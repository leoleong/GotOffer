package offer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _07_QueueWithTwoStacks {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Queue queue = new Queue(T);
		for (int i = 0; i < T; i++) {
			String op = sc.next();
			if (op.equals("PUSH")) {
				queue.push(sc.nextInt());
			} else {
				System.out.println(queue.pop());
			}
		}
	}

	// implements Queue with 2 Stacks
	static class Queue {
		Deque<Integer> stack1;
		Deque<Integer> stack2;

		Queue(int size) {
			stack1 = new ArrayDeque<Integer>(size);
			stack2 = new ArrayDeque<Integer>(size);
		}

		void push(int val) {
			stack1.push(val);
		}

		int pop() {
			if (!stack2.isEmpty()) {
				return stack2.pop();
			} else {
				while (!stack1.isEmpty()) {
					stack2.push(stack1.pop());
				}
				if (!stack2.isEmpty()) {
					return stack2.pop();
				} else {
					return -1;
				}
			}
		}
	}

	// implements Stack with 2 Queues
	static class Stack {
		java.util.Queue<Integer> queue1;
		java.util.Queue<Integer> queue2;

		Stack(int size) {
			queue1 = new ArrayDeque<Integer>(size);
			queue2 = new ArrayDeque<Integer>(size);
		}

		void push(int val) {
			queue1.offer(val);
		}

		int pop() {
			if (queue1.isEmpty()) {
				return -1;
			}
			while (queue1.size() > 1) {
				queue2.offer(queue1.poll());
			}
			int value = queue1.poll();
			java.util.Queue<Integer> tmp = queue2;
			queue2 = queue1;
			queue1 = tmp;
			return value;
		}
	}
}

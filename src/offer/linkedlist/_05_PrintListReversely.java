package offer.linkedlist;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class _05_PrintListReversely {

	public static void main(String[] args) throws IOException {

		int[] array = new int[] { 1, 2, 3, 4, 5 };
		ListNode head = parseListNode(array);
		reverseUsingStack(head);
		reverseUsingRecursion(head);
	}

	// Method 1: stack
	private static void reverseUsingStack(ListNode head) {

		if (head == null) {
			return;
		}

		Deque<Integer> stack = new ArrayDeque<Integer>();
		while (head != null) {
			stack.push(head.val);
			head = head.next;
		}

		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

	// Method 2: recursion
	private static void reverseUsingRecursion(ListNode head) {

		if (head == null) {
			return;
		}

		reverseUsingRecursion(head.next);
		System.out.println(head.val);
	}

	private static ListNode parseListNode(int[] array) {

		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		ListNode cur = dummy;

		for (int i : array) {
			cur.next = new ListNode(i);
			cur = cur.next;
		}

		return dummy.next;
	}

	private static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}
}

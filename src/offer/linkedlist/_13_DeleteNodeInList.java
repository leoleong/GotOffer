package offer.linkedlist;

import java.util.Random;

public class _13_DeleteNodeInList {

	public static void main(String[] args) {

		int[] array = new int[] { 1, 2, 3, 4 };
		ListNode head = parseListNode(array);
		ListNode node = head;
		int i = new Random().nextInt(array.length);
		while (i-- > 0) {
			node = node.next;
		}

		head = deleteNode(head, node);

		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}

	private static ListNode deleteNode(ListNode head, ListNode node) {

		// assume node is in the list
		if (head == null) {
			return null;
		}

		// use dummy node while head is ambiguous
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode prev, cur;

		if (node.next != null) {
			// node is not tail, O(1)
			prev = node;
			cur = node.next;
			prev.val = cur.val;
			prev.next = cur.next;
			cur.next = null;
		} else {
			// node is tail, O(n)
			prev = dummy;
			cur = head;
			while (cur != node) {
				prev = cur;
				cur = cur.next;
			}
			prev.next = cur.next;
			cur.next = null;
		}

		return dummy.next;
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

		ListNode(int x) {
			this.val = x;
		}
	}
}

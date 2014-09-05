package offer.linkedlist;

public class _13_DeleteNodeInList {

	public static void main(String[] args) {

		int[] array = new int[] { 1, 2, 3, 4 };
		ListNode dummy = new ListNode(-1);
		ListNode node = dummy;
		ListNode node1 = null;
		for (int i = 0; i < array.length; i++) {
			node.next = new ListNode(array[i]);
			node = node.next;
			if (i == 3) {
				node1 = node;
			}
		}

		ListNode head = deleteNode(dummy.next, node1);

		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}

	private static ListNode deleteNode(ListNode head, ListNode node) {

		// assume node is in the list
		if (head == null) {
			return head;
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

	private static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			this.val = x;
		}
	}
}

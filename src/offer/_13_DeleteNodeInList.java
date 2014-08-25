package offer;

public class _13_DeleteNodeInList {

	public static void main(String[] args) {

		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;

		ListNode head = deleteNode(node1, node2);

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

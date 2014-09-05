package offer.linkedlist;

public class _15_KthNodeFromEnd {

	public static void main(String[] args) {

		int[] array = new int[] { 1, 2, 3, 4 };
		ListNode dummy = new ListNode(-1);
		ListNode node = dummy;
		for (int i : array) {
			node.next = new ListNode(i);
			node = node.next;
		}

		node = findNode(dummy.next, 4);

		System.out.println(node == null ? "NULL" : node.val);
	}

	private static ListNode findNode(ListNode head, int k) {

		if (head == null || k <= 0) {
			return null;
		}

		ListNode fast = head;
		ListNode slow = head;
		while (k > 0 && fast != null) {
			fast = fast.next;
			k--;
		}

		// list.length < k
		if (k > 0) {
			return null;
		}

		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}

		return slow;
	}

	private static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			this.val = x;
		}
	}
}

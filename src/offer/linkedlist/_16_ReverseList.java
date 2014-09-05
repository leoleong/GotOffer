package offer.linkedlist;

public class _16_ReverseList {

	public static void main(String[] args) {

		int[] array = new int[] { 1, 2, 3, 4 };
		ListNode dummy = new ListNode(-1);
		ListNode node = dummy;
		for (int i : array) {
			node.next = new ListNode(i);
			node = node.next;
		}

		ListNode head = reverse(dummy.next);

		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}

	private static ListNode reverse(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		dummy.next = head;
		ListNode tail = head;
		ListNode cur;

		while (tail.next != null) {
			cur = tail.next;
			tail.next = cur.next;
			cur.next = dummy.next;
			dummy.next = cur;
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

package offer.linkedlist;

public class _17_MergeSortedList {

	public static void main(String[] args) {

		int[] array1 = new int[] { 1, 3, 5, 7 };
		int[] array2 = new int[] { 2, 4, 6, 8 };
		ListNode head1 = parseListNode(array1);
		ListNode head2 = parseListNode(array2);

		ListNode head = merge(head1, head2);

		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}

	private static ListNode merge(ListNode l1, ListNode l2) {

		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		ListNode node = dummy;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				node.next = l1;
				l1 = l1.next;
			} else {
				node.next = l2;
				l2 = l2.next;
			}
			node = node.next;
		}
		node.next = l1 != null ? l1 : l2;

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

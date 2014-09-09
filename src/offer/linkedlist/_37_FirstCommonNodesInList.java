package offer.linkedlist;

public class _37_FirstCommonNodesInList {

	public static void main(String[] args) {

		int[] array1 = new int[] { 1, 2, 3, 6, 7 };
		int[] array2 = new int[] { 4, 5, 6, 7 };
		ListNode head1 = parseListNode(array1);
		ListNode head2 = parseListNode(array2);

		ListNode node = findNode(head1, head2);

		System.out.println(node == null ? "NULL" : node.val);
	}

	private static ListNode findNode(ListNode l1, ListNode l2) {

		if (l1 == null || l2 == null) {
			return null;
		}

		int length1 = getLength(l1);
		int length2 = getLength(l2);
		if (length1 > length2) {
			l1 = relocate(l1, length1 - length2);
		} else if (length2 > length1) {
			l2 = relocate(l2, length2 - length1);
		}

		while (l1 != null && l2 != null) {
			if (l1.val == l2.val) {
				return l1;
			}
			l1 = l1.next;
			l2 = l2.next;
		}

		return null;
	}

	private static int getLength(ListNode head) {

		if (head == null) {
			return 0;
		}

		int length = 0;
		while (head != null) {
			length++;
			head = head.next;
		}

		return length;
	}

	private static ListNode relocate(ListNode head, int step) {

		while (step > 0) {
			head = head.next;
			step--;
		}

		return head;
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

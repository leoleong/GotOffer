package offer.linkedlist;

public class _37_FirstCommonNodesInList {

	public static void main(String[] args) {

		int[] array1 = new int[] { 1, 2, 3, 6, 7 };
		ListNode dummy1 = new ListNode(-1);
		ListNode l1 = dummy1;
		for (int i : array1) {
			l1.next = new ListNode(i);
			l1 = l1.next;
		}
		int[] array2 = new int[] { 4, 5, 6, 7 };
		ListNode dummy2 = new ListNode(-1);
		ListNode l2 = dummy2;
		for (int i : array2) {
			l2.next = new ListNode(i);
			l2 = l2.next;
		}

		ListNode node = findNode(dummy1.next, dummy2.next);

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

		int count = 0;
		while (head != null) {
			count++;
			head = head.next;
		}

		return count;
	}

	private static ListNode relocate(ListNode head, int step) {

		while (step > 0) {
			head = head.next;
			step--;
		}

		return head;
	}

	private static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			this.val = x;
		}
	}
}

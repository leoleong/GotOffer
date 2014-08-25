package offer;

public class _17_MergeSortedList {

	public static void main(String[] args) {

		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(5);
		ListNode node4 = new ListNode(7);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;

		ListNode node5 = new ListNode(2);
		ListNode node6 = new ListNode(4);
		ListNode node7 = new ListNode(5);
		ListNode node8 = new ListNode(8);
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;

		ListNode head = merge(node1, node5);

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

	private static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			this.val = x;
		}
	}
}

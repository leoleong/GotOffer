package offer;

public class _16_ReverseList {

	public static void main(String[] args) {

		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;

		ListNode head = reverse(node1);

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

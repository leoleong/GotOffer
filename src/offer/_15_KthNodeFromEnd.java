package offer;

public class _15_KthNodeFromEnd {

	public static void main(String[] args) {

		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;

		ListNode node = findNode(node1, 4);

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

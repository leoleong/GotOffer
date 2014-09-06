package offer.linkedlist;

public class _45_LastNumberInCircle {

	public static void main(String[] args) {

		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		ListNode node = dummy;
		int[] array = new int[] { 0, 1, 2, 3 };
		for (int i : array) {
			node.next = new ListNode(i);
			node = node.next;
		}

		// Method 1
		// make circle
		node.next = dummy.next;
		ListNode remain = lastRemaining(dummy.next, 4, 2);
		System.out.println(remain.val);

		// Method 2
		int remains = lastRemaining(array, 4, 2);
		System.out.println(remains);
	}

	// Method 1: cyclic linkedlist
	private static ListNode lastRemaining(ListNode head, int n, int k) {

		if (head == null || n <= 0 || k <= 0) {
			return null;
		}

		ListNode prev = head;
		ListNode cur = head;
		int temp = n - 1;
		while (temp > 0) {
			prev = prev.next;
			temp--;
		}

		while (cur != cur.next) {
			int count = k - 1;
			while (count > 0) {
				prev = cur;
				cur = cur.next;
				count--;
			}
			prev.next = cur.next;
			cur = cur.next;
		}

		return cur;
	}

	// Method 2: DP
	private static int lastRemaining(int[] array, int n, int k) {

		if (array == null || n <= 0 || k <= 0) {
			return -1;
		}

		int[] dp = new int[array.length + 1];
		dp[1] = 0;

		for (int i = 2; i < dp.length; i++) {
			dp[i] = (dp[i - 1] + k) % i;
		}

		return dp[n];
	}

	private static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			this.val = x;
		}
	}
}

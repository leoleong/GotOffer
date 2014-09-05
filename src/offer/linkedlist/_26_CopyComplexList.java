package offer.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class _26_CopyComplexList {

	public static void main(String[] args) {

		int[] array = new int[] { 1, 2, 3, 4 };
		RandomListNode dummy = new RandomListNode(-1);
		RandomListNode node = dummy;
		for (int i : array) {
			node.next = new RandomListNode(i);
			node = node.next;
		}

		// RandomListNode head = cloneWithMap(dummy.next);
		RandomListNode head = clone(dummy.next);

		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}

	// Method 1 : copy with HashMap
	private static RandomListNode cloneWithMap(RandomListNode head) {

		if (head == null) {
			return null;
		}

		Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode node = head;

		// clone nodes
		while (node != null) {
			RandomListNode cur = new RandomListNode(node.val);
			map.put(node, cur);
			node = node.next;
		}
		map.put(null, null);

		// add pointer
		node = head;
		while (node != null) {
			RandomListNode cur = map.get(node);
			cur.next = map.get(node.next);
			cur.random = map.get(node.random);
			node = node.next;
		}

		return map.get(head);
	}

	// Method 2 : copy with insertion
	private static RandomListNode clone(RandomListNode head) {

		if (head == null) {
			return null;
		}

		RandomListNode node = head;

		// copy nodes and next pointer
		while (node != null) {
			RandomListNode cur = new RandomListNode(node.val);
			cur.next = node.next;
			node.next = cur;
			node = cur.next;
		}

		// copy random pointer
		node = head;
		while (node != null) {
			if (node.random != null) {
				node.next.random = node.random.next;
			}
			node = node.next.next;
		}

		// seperate list
		RandomListNode dummy = new RandomListNode(Integer.MIN_VALUE);
		RandomListNode cur = dummy;
		node = head;
		while (node != null) {
			cur.next = node.next;
			cur = cur.next;
			node.next = cur.next;
			node = node.next;
		}

		return dummy.next;
	}

	private static class RandomListNode {
		int val;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.val = x;
		}
	}
}

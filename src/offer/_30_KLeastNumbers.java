package offer;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class _30_KLeastNumbers {

	public static void main(String[] args) throws IOException {

		StreamTokenizer st = new StreamTokenizer(System.in);
		while (st.nextToken() != StreamTokenizer.TT_EOF) {
			int T = (int) st.nval;
			st.nextToken();
			int K = (int) st.nval;
			int[] nums = new int[T];
			for (int i = 0; i < T; i++) {
				st.nextToken();
				nums[i] = (int) st.nval;
			}
			kLeastNumbers_2(nums, K);
		}
	}

	// 1. transformation of QuickSort : TLE
	private static void kLeastNumbers(int[] nums, int k) {

		int start = 0;
		int end = nums.length - 1;
		int index = getPivot(nums, start, end);

		while (index != k) {
			if (index < k) {
				start = index + 1;
				index = getPivot(nums, start, end);
			} else {
				end = index - 1;
				index = getPivot(nums, start, end);
			}
		}

		Arrays.sort(nums, 0, k - 1);
		String result = "";
		for (int i = 0; i < k; i++) {
			result += nums[i] + " ";
		}
		System.out.println(result.trim());
	}

	private static int getPivot(int[] nums, int start, int end) {

		int key = nums[end];
		int i = start - 1;
		for (int j = start; j <= end; j++) {
			if (nums[j] <= key) {
				swap(nums, ++i, j);
			}
		}

		return i;
	}

	private static void swap(int[] nums, int src, int dst) {

		int tmp = nums[src];
		nums[src] = nums[dst];
		nums[dst] = tmp;
	}

	// -----------------------------------------------------------------------------
	// 2. PriorityQueue : TLE
	private static void kLeastNumbers_1(int[] nums, int k) {

		Queue<Integer> heap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 > o2) {
					return -1;
				} else if (o1 < o2) {
					return 1;
				} else {
					return 0;
				}
			}
		});

		for (int i = 0; i < nums.length; i++) {
			if (heap.size() < k) {
				heap.offer(nums[i]);
			} else {
				if (heap.peek() > nums[i]) {
					heap.poll();
					heap.offer(nums[i]);
				}
			}
		}

		Deque<Integer> stack = new ArrayDeque<Integer>(k);
		for (int i = 0; i < k; i++) {
			stack.push(heap.poll());
		}
		String result = "";
		for (int i = 0; i < k; i++) {
			result += stack.pop() + " ";
		}
		System.out.println(result.trim());
	}

	// -----------------------------------------------------------------------------
	// 3. HeapSort : TLE
	private static void kLeastNumbers_2(int[] nums, int k) {

		int[] heap = new int[k];
		for (int i = 0; i < nums.length; i++) {
			if (i == k - 1) {
				heap[i] = nums[i];
				for (int j = (i - 1) / 2; j >= 0; j--) {
					adjust(heap, j, i);
				}
			} else if (i > k - 1) {
				if (nums[i] < heap[0]) {
					heap[0] = nums[i];
					adjust(heap, 0, k - 1);
				}
			} else {
				heap[i] = nums[i];
			}
		}
		Arrays.sort(heap);
		String result = "";
		for (int i = 0; i < k; i++) {
			result += heap[i] + " ";
		}
		System.out.println(result.trim());
	}

	private static void adjust(int[] nums, int start, int end) {
		int sentinel = nums[start];
		int parent = start;
		int child = parent * 2 + 1;

		for (; child <= end; child = child * 2 + 1) {
			if (child < end && nums[child + 1] > nums[child]) {
				child++;
			}
			if (sentinel >= nums[child]) {
				break;
			}
			nums[parent] = nums[child];
			parent = child;
		}
		nums[parent] = sentinel;
	}
}

package offer.linkedlist;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _05_PrintListReversely {

	public static void main(String[] args) throws IOException {

		// 1. Scanner, Stack(TLE)
//		 Scanner sc = new Scanner(System.in);
//		 reverseUsingRecursion(sc);
		// 2. Scanner, Recursion(TLE)
//		 Scanner sc = new Scanner(System.in);
//		 reverseUsingRecursion(sc);
		// 3. StreamTokenizer, Recursion(TLE)
//		 StreamTokenizer st = new StreamTokenizer(System.in);
//		 reverseUsingRecursion(st);
		// 4. StreamTokenizer, Stack(PASS)
		StreamTokenizer st = new StreamTokenizer(System.in);
		reverseUsingStack(st);
	}

	// PASS
	private static void reverseUsingStack(StreamTokenizer st) throws IOException {

		Deque<Integer> stack = new ArrayDeque<Integer>();
		int value;
		st.nextToken();
		while ((value = (int) st.nval) != -1) {
			stack.push(value);
			st.nextToken();
		}
		while (stack.size() > 0) {
			System.out.println(stack.pop());
		}
	}

	// TLE
	private static void reverseUsingRecursion(StreamTokenizer st) throws IOException {

		st.nextToken();
		int value = (int) st.nval;
		if (value == -1) {
			return;
		}
		reverseUsingRecursion(st);
		System.out.println(value);
	}

	// --------------------------------------------------------------------------------
	// TLE with scanner
	private static void reverseUsingStack(Scanner sc) {

		Deque<Integer> stack = new ArrayDeque<Integer>();
		int value;
		while ((value = sc.nextInt()) != -1) {
			stack.push(value);
		}
		while (stack.size() > 0) {
			System.out.println(stack.pop());
		}
	}

	// TLE
	private static void reverseUsingRecursion(Scanner sc) {

		int value = sc.nextInt();
		if (value == -1) {
			return;
		}

		reverseUsingRecursion(sc);
		System.out.println(value);
	}
}

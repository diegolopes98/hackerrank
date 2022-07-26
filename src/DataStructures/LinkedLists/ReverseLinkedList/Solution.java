package DataStructures.LinkedLists.ReverseLinkedList;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class SinglyLinkedListNode {
	public int data;
	public SinglyLinkedListNode next;

	public SinglyLinkedListNode(int nodeData) {
		this.data = nodeData;
		this.next = null;
	}
}

class SinglyLinkedList {
	public SinglyLinkedListNode head;
	public SinglyLinkedListNode tail;

	public SinglyLinkedList() {
		this.head = null;
		this.tail = null;
	}

	public void insertNode(int nodeData) {
		SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

		if (this.head == null) {
			this.head = node;
		} else {
			this.tail.next = node;
		}

		this.tail = node;
	}
}

class SinglyLinkedListPrintHelper {
	public static void printList(SinglyLinkedListNode node, String sep) {
		while (node != null) {
			System.out.println(node.data);

			node = node.next;

			if (node != null) {
				System.out.println(sep);
			}
		}
	}
}

class Result {

	/*
	 * Complete the 'reverse' function below.
	 *
	 * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
	 * The function accepts INTEGER_SINGLY_LINKED_LIST llist as parameter.
	 */

	/*
	 * For your reference:
	 *
	 * SinglyLinkedListNode {
	 *     int data;
	 *     SinglyLinkedListNode next;
	 * }
	 *
	 */

	public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
		SinglyLinkedListNode curr = llist;
		SinglyLinkedListNode prev = null;
		SinglyLinkedListNode next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

}

public class Solution {
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		int tests = scanner.nextInt();

		IntStream.range(0, tests).forEach(testsItr -> {
			SinglyLinkedList llist = new SinglyLinkedList();

			int llistCount = scanner.nextInt();

			IntStream.range(0, llistCount).forEach(i -> {
				int llistItem = scanner.nextInt();

				llist.insertNode(llistItem);
			});

			SinglyLinkedListNode llist1 = Result.reverse(llist.head);

			SinglyLinkedListPrintHelper.printList(llist1, " ");
			System.out.println();
		});

		scanner.close();
	}
}


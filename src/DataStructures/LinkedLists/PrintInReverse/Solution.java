package DataStructures.LinkedLists.PrintInReverse;


import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;

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
			System.out.print(node.data);

			node = node.next;

			if (node != null) {
				System.out.print(sep);
			}
		}
	}
}

class Result {

	/*
	 * Complete the 'reversePrint' function below.
	 *
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

	public static void reversePrint(SinglyLinkedListNode llist) {
		if (llist.next != null) {
			reversePrint(llist.next);
		}
		if (llist != null) {
			System.out.println(llist.data);
		}
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

			Result.reversePrint(llist.head);
		});

		scanner.close();
	}
}

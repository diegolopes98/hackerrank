package DataStructures.LinkedLists.InsertNodeAtSpecificPosition;

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
	 * Complete the 'insertNodeAtPosition' function below.
	 *
	 * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
	 * The function accepts following parameters:
	 *  1. INTEGER_SINGLY_LINKED_LIST llist
	 *  2. INTEGER data
	 *  3. INTEGER position
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

	public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
		var idx = 0;
		var node = llist;
		while (node != null && idx < position - 1) {
			node = node.next;
			idx++;
		}
		if (node != null) {
			var newNode = new SinglyLinkedListNode(data);
			newNode.next = node.next;
			node.next = newNode;
		}
		return llist;
	}

}

public class Solution {
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		SinglyLinkedList llist = new SinglyLinkedList();

		int llistCount = scanner.nextInt();

		IntStream.range(0, llistCount).forEach(i -> {
			int llistItem = scanner.nextInt();

			llist.insertNode(llistItem);
		});

		int data = scanner.nextInt();

		int position = scanner.nextInt();

		SinglyLinkedListNode llist_head = Result.insertNodeAtPosition(llist.head, data, position);

		SinglyLinkedListPrintHelper.printList(llist_head, " ");
		System.out.println();
		scanner.close();
	}
}


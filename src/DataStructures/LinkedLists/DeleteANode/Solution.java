package DataStructures.LinkedLists.DeleteANode;

import java.io.*;
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
	public static void printList(
			SinglyLinkedListNode node,
			String sep
	) throws IOException {
		while (node != null) {
			System.out.println(String.valueOf(node.data));

			node = node.next;

			if (node != null) {
				System.out.println(sep);
			}
		}
	}
}

class Result {

	/*
	 * Complete the 'deleteNode' function below.
	 *
	 * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
	 * The function accepts following parameters:
	 *  1. INTEGER_SINGLY_LINKED_LIST llist
	 *  2. INTEGER position
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

	public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode node, int position) {
		if (node == null) return null;
		if (position == 0) {
			return node.next;
		}
		int idx = 1 ;
		var prevNode = node;
		while (prevNode != null && idx < position ) {
			prevNode = prevNode.next;
			idx++;
		}
		if (prevNode != null && prevNode.next != null) {
			prevNode.next = prevNode.next.next;
		}
		return node;
	}

}

public class Solution {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		SinglyLinkedList llist = new SinglyLinkedList();

		int llistCount = scanner.nextInt();

		IntStream.range(0, llistCount).forEach(i -> {
			int llistItem = scanner.nextInt();

			llist.insertNode(llistItem);
		});

		int position = scanner.nextInt();

		SinglyLinkedListNode llist1 = Result.deleteNode(llist.head, position);

		SinglyLinkedListPrintHelper.printList(llist1, " ");

		scanner.close();
	}
}

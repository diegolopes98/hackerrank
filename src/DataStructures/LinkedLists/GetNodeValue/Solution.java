package DataStructures.LinkedLists.GetNodeValue;

import java.io.BufferedWriter;
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

	public void insertNodeAtHead(int nodeData) {
		SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);
		node.next = this.head;
		this.head = node;
		if (this.tail == null) {
			this.tail = node;
		}
	}
}

class Result {

	/*
	 * Complete the 'getNode' function below.
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts following parameters:
	 *  1. INTEGER_SINGLY_LINKED_LIST llist
	 *  2. INTEGER positionFromTail
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

	public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {
		final var rllist = new SinglyLinkedList();
		var rnode = llist;
		while (rnode != null) {
			rllist.insertNodeAtHead(rnode.data);
			rnode = rnode.next;
		}
		int idx = 0;
		var node = rllist.head;
		while (node != null && idx < positionFromTail ) {
			node = node.next;
			idx++;
		}
		return node.data;
	}

}

public class Solution {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int tests = scanner.nextInt();

		IntStream.range(0, tests).forEach(testsItr -> {
			SinglyLinkedList llist = new SinglyLinkedList();

			int llistCount = scanner.nextInt();

			IntStream.range(0, llistCount).forEach(i -> {
				int llistItem = scanner.nextInt();

				llist.insertNode(llistItem);
			});

			int position = scanner.nextInt();

			int result = Result.getNode(llist.head, position);

			System.out.println(result);
			System.out.println();
		});

		scanner.close();
	}
}
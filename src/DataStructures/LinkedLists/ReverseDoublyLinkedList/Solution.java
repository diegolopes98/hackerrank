package DataStructures.LinkedLists.ReverseDoublyLinkedList;

import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;

class DoublyLinkedListNode {
    public int data;
    public DoublyLinkedListNode next;
    public DoublyLinkedListNode prev;

    public DoublyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    public DoublyLinkedListNode head;
    public DoublyLinkedListNode tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int nodeData) {
        DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
            node.prev = this.tail;
        }

        this.tail = node;
    }
}

class DoublyLinkedListPrintHelper {
    public static void printList(DoublyLinkedListNode node, String sep) throws IOException {
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
     * The function is expected to return an INTEGER_DOUBLY_LINKED_LIST.
     * The function accepts INTEGER_DOUBLY_LINKED_LIST llist as parameter.
     */

    /*
     * For your reference:
     *
     * DoublyLinkedListNode {
     *     int data;
     *     DoublyLinkedListNode next;
     *     DoublyLinkedListNode prev;
     * }
     *
     */

    public static DoublyLinkedListNode reverse(DoublyLinkedListNode llist) {
        DoublyLinkedListNode curr = llist;
        DoublyLinkedListNode prev = null;
        DoublyLinkedListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}

public class Solution {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();

        IntStream.range(0, t).forEach(tItr -> {
            try {
                DoublyLinkedList llist = new DoublyLinkedList();

                int llistCount = scanner.nextInt();

                IntStream.range(0, llistCount).forEach(i -> {
                    int llistItem = scanner.nextInt();

                    llist.insertNode(llistItem);
                });

                DoublyLinkedListNode llist1 = Result.reverse(llist.head);

                DoublyLinkedListPrintHelper.printList(llist1, " ");
                System.out.println();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        scanner.close();
    }
}
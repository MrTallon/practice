package todo;

/**
 * 单向链表的反转
 */
public class SingleReverse {

    class Node{

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    class LinkedList {

        Node head;
        Node tail;

        public void reverse() {
            Node current = head;
            Node temp = null;

            // 头尾相连
            while (current != null) {
                temp = current.next;
                current.next = tail;
                tail = current;
                current = temp;
            }

            // pre->next,next->pre
            current = head;
            while (current != null) {
                temp = current.next;
                current.next = temp.next;
                temp.next = current;
                current = temp;
            }

            // 头尾置换
            head = tail.next;
            tail.next = null;
        }

    }
}

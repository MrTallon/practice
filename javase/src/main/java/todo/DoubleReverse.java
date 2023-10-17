package todo;

/**
 * 双向链表的反转
 */
public class DoubleReverse {

    class Node{
        int data;
        Node pre;
        Node next;

        public Node(int data) {
            this.data = data;
            this.pre = null;
            this.next = null;
        }
    }

    class LinkedList{

        Node head;
        Node tail;

        public void reverse() {
            Node temp = null;
            Node current = head;

            // 头尾相连
            while (current != null) {
                temp = current.pre;
                current.pre = current.next;
                current.next = temp;
                current = current.pre;
            }

            // 遍历，pre-》next，next-》pre
            current = head;
            while (current != null) {
                temp = current.pre;
                current.pre = current.next;
                current.next = temp;
                current = current.pre;
            }

            head = tail;
            tail = head.pre;
        }
    }
}

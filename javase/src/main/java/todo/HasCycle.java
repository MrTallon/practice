package todo;

/**
 * 判断链表中是否有环
 */
public class HasCycle {

    class LinkedNode {
        int data;
        LinkedNode next;

        LinkedNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean method(LinkedNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        LinkedNode slow = head;
        LinkedNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
}

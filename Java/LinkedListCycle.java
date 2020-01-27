package business;
/*
* Given the head of a Singly LinkedList, write a function to determine if the LinkedList has a cycle in it or not.
 * */
class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

class LinkedListCycle {

    public static void main(String[] args) {

    }
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}


class LinkedList {
    Node head; 
  
  
    class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
  
    Node newNode(int key)
    {
        return new Node(key);
    }
  
    
    void sort()
    {
        Node Ahead = new Node(0), Dhead = new Node(0);
  
        splitList(Ahead, Dhead);
  
        Ahead = Ahead.next;
        Dhead = Dhead.next;
  
        Dhead = reverseList(Dhead);
  
        head = mergeList(Ahead, Dhead);
    }
  
    Node reverseList(Node Dhead)
    {
        Node current = Dhead;
        Node prev = null;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        Dhead = prev;
        return Dhead;
    }
  
    void printList()
    {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
  
    
    Node mergeList(Node head1, Node head2)
    {
        
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;
  
        Node temp = null;
        if (head1.data < head2.data) {
            temp = head1;
            head1.next = mergeList(head1.next, head2);
        }
        else {
            temp = head2;
            head2.next = mergeList(head1, head2.next);
        }
        return temp;
    }
  
    
    void splitList(Node Ahead, Node Dhead)
    {
        Node ascn = Ahead;
        Node dscn = Dhead;
        Node curr = head;
  
       
  
        while (curr != null) {
            ascn.next = curr;
            ascn = ascn.next;
            curr = curr.next;
  
            if (curr != null) {
                dscn.next = curr;
                dscn = dscn.next;
                curr = curr.next;
            }
        }
  
        ascn.next = null;
        dscn.next = null;
    }
  
    
    public static void main(String args[])
    {
        LinkedList llist = new LinkedList();
        llist.head = llist.newNode(10);
        llist.head.next = llist.newNode(40);
        llist.head.next.next = llist.newNode(53);
        llist.head.next.next.next = llist.newNode(30);
        llist.head.next.next.next.next = llist.newNode(67);
        llist.head.next.next.next.next.next = llist.newNode(12);
        llist.head.next.next.next.next.next.next = llist.newNode(89);
  
        System.out.println("Given linked list");
        llist.printList();
  
        llist.sort();
  
        System.out.println("Sorted linked list");
        llist.printList();
    }
  
} 

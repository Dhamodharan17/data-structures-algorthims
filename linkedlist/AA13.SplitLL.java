//create 2 heads
//point next to next.next

class Solution {
    // Function to append a new node with newData at the end of a linked list
    Node[] alternatingSplitList(Node head) {
    
    if(head == null) return new Node[]{};
    
    Node headA = head;
    Node headB = head.next;
    
    while(head!=null){
        Node next = head.next;
        if(head.next!=null)
            head.next = head.next.next;
        head = next;
    }
    
    
    return new Node[]{headA,headB};
    }
}

//detect cycle then make all next=null
//if the next is already null then it is first node of cycle

class Solution {
    //Function to find first node if the linked list has a loop.
    public static int findFirstNode(Node head){
        
        //check cycle
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast= fast.next.next;
            if(slow == fast) break;
        }
        if(slow != fast) return -1;// no cycle
        
        while(head!=null){
            if(head.next==null) return head.data;
            Node next = head.next;
            head.next=null;
            head=next;
        }
        
        return -1;
    }
}

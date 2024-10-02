//iterative

class Solution {
    public ListNode reverseList(ListNode head) {
        
        //reverse point next points prev
        ListNode prev=null;
        while(head!=null){
            ListNode nextNode = head.next;
            head.next=prev;
            prev=head;
            head = nextNode;
        }

    return prev;
    }
}

//recursive

class Solution {
    public ListNode reverseList(ListNode head) {
        
        //reverse -> point next points prev
        return revUtil(head,null);
    }

    ListNode revUtil(ListNode head,ListNode prev){

        if(head == null) return prev;
        
        ListNode next = head.next;
        head.next =prev;
        return revUtil(next,head);

    }
}


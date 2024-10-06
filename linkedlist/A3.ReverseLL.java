//prev is important in reverse since we are pointing next to prev

class Solution {
    public ListNode reverseList(ListNode head) {
      
     return reverseUtil(head,null);
      
    }
  
   public ListNode reverseUtil(ListNode head,ListNode prev){

    if(head == null) return prev;
    // same output will be returned to outer recursion

    ListNode next = head.next;
    head.next=prev;

    return reverseUtil(next,head);
   
   } 
}

//iteration

class Solution {
    public ListNode reverseList(ListNode head) {
        
    // reverse - point next to prev
    //forming new linkedlist 2->1->null
    ListNode prev = null;
    while(head!=null){
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        head = next;
    }    
    return prev;
    }
}

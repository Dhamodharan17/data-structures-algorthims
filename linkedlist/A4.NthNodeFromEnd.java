//move fast pointer k time then move slow and fast together, slow is the answer if k≥n

class Solution {
    int getKthFromLast(Node head, int k) {
        
        Node slow = head;
        Node fast = head;

      // move k times
        while(fast!=null && k!=0){
            fast = fast.next;
            k--;
        }

        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        
      // when k>=n
      if(k==0 && slow!=null) return slow.data;
      
      return -1;
        
    }
}

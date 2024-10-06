//Make 2 linked list to same size then iterate
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       
        //find the len
        int h1 = length(headA);
        int h2 = length(headB);
        int diff = Math.abs(h1-h2);
				// make both same size if not
        if(h1!=h2){
        if(h2>h1){
            headB = moveDSteps(headB,diff);
        }else{
            headA = moveDSteps(headA,diff);
        }
      }

        //find common point
        while(headB!=null && headA!=null){
         if(headB==headA) return headA;
            headB= headB.next;
            headA=headA.next;
        }

        return null;

    }

    ListNode moveDSteps(ListNode head,int diff){

        if(diff == 0 || head==null) return head;
        return moveDSteps(head.next,--diff);
    }

    int length(ListNode head){
        if(head == null) return 0;
        return length(head.next)+1;
    }
}

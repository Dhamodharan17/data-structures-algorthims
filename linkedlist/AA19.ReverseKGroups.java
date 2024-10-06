//find the kth node, break the chain. reverse it. attach to prevlast

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevLast = null;

        while(temp!=null){
            ListNode kthNode = getKthNode(temp,k);
            
            //edge case - length
            if(kthNode==null){
                if(prevLast!=null) prevLast.next = temp;
                break;
            }

            ListNode nxt = kthNode.next;
            kthNode.next =null;//break
            reverseLL(temp);

            //edgecase - head
            if(temp==head){
                head = kthNode;
            }else{
                prevLast.next = kthNode;
            }
            prevLast= temp;
            temp=nxt;
        }
    return head;
}


public ListNode getKthNode(ListNode temp,int k){
    k-=1;// as we start from 1st node already
    while(temp!=null &&k>0){
        k--;
        temp = temp.next;
    }
    return temp;
}

// reverse LL
public ListNode reverseLL(ListNode head){
    ListNode prev = null;
    while(head!=null){
        ListNode next = head.next;
        head.next=prev;
        prev = head;
        head = next;
    }
    return head;
}

}

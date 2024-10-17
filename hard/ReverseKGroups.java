
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode temp = head;
        ListNode prevBlock = null;

        while(temp!=null){

            ListNode kthNode = getKthNode(temp,k);
            if(kthNode == null){
                if(prevBlock!=null){
                    prevBlock.next = temp;
                }
                break;
            }

            ListNode next = kthNode.next;
            kthNode.next = null;

            //just reveresed the LL 
            reverse(temp);

            if(head==temp){
                head = kthNode;
            }else{
                prevBlock.next = kthNode;
            }

            prevBlock = temp;
            temp = next;
        }

        return head;

    }

    //get the kth node
    public ListNode getKthNode(ListNode head, int k){

        while(head!=null && k>1){
            head = head.next;
            k--;
        }
        
        return head;
    }

    //reverse
    public ListNode reverse(ListNode head){
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

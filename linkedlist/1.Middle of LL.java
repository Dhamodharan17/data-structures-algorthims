//https://leetcode.com/problems/middle-of-the-linked-list/

//solution 1 - linear T(n) = O(n) S(n) = O(n)

class Solution {
    public ListNode middleNode(ListNode head) {

        ListNode[] A = new ListNode[100];//100 constaint in question

        int t=0;
        while(head!=null){
            A[t++] = head;
            head =head.next;
        }

        return A[t/2];
    }
}


//solutuon 2 - slow and fast pointer T(n) = O(n) S(n) = O(1)
class Solution {
    public ListNode middleNode(ListNode head) {

    ListNode slow=head;
    ListNode fast=head;
    while(fast!=null && fast.next!=null){
        slow=slow.next;
        fast = fast.next.next;
    }
    return slow;
    }
}




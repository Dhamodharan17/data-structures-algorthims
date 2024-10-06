//create dummy head pointer
//compare both, whoever won move them with result
//put reamining
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode res = head;

        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                head.next=list1;
                list1=list1.next;
            }else{
                head.next=list2;
                list2=list2.next;
            }
            head=head.next;
        }
        // put remaining if any
        while(list1!=null){
            head.next = list1;
            list1=list1.next;
            head=head.next;
        }

        // put remaining if any
        while(list2!=null){
            head.next = list2;
            list2=list2.next;
            head = head.next;
        }

    return res.next;
    }
}

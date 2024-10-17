
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;

        return mergeSort(lists,0,lists.length-1);

    }

    ListNode mergeSort(ListNode[] lists, int low, int high){

      //when only one list return it
       if(low==high) return lists[low];

       int mid = low+(high-low)/2;
      
       ListNode l = mergeSort(lists,low,mid);
       ListNode r = mergeSort(lists,mid+1,high);

       return merge(l,r);

    }


    ListNode merge(ListNode list1,ListNode list2){

        ListNode dummy = new ListNode(0);
        ListNode itr = dummy;

        while(list1 != null && list2 != null){

            if(list1.val<=list2.val){
                itr.next = list1;
                list1 = list1.next;
            }else{
                itr.next = list2;
                list2 = list2.next; 
            }

            itr = itr.next;
        }

        itr.next = list1 != null?list1:list2;

        return dummy.next;


    }

}

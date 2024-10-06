//Convert to array and again convert to LL
class Solution
{
    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head)
    {
        int[] input = convert(head);
        mergeSort(input,0,input.length-1);
        
       return convertLL(input);    
    
    }
    
    //merge sort
    public static void mergeSort(int[] arr,int start,int end){
        
        // until 1 element
        if(start<end){
            int mid = start+(end-start)/2;//divide into 2
            mergeSort(arr,start,mid);
            mergeSort(arr,mid+1,end);
            merge(arr,start,mid,end);
        }
        
    }
    
    //merge
    public static void merge(int arr[],int start,int mid,int end){
        
        int n1 = mid-start+1;
        int n2 = end-mid;
        int[] left = new int[n1];
        int[] right = new int[n2];
        
        for(int i=0;i<n1;i++){
            left[i] = arr[i+start];//take values from 1st half
        }
        for(int i=0;i<n2;i++){
    right[i] = arr[mid+i+1];//take values from 2nd half
}
        
        int k=start,i=0,j=0;
        //2 pointer ap
        while(i<n1 && j<n2){
            if(left[i]>right[j]){
                arr[k++] = right[j++];//right won
            }else{
                arr[k++] = left[i++];//left won
            }
        }
        
        //fillup
        while(i<n1){
            arr[k++] = left[i++];
        }
        while(j<n2){
            arr[k++] = right[j++];
        }
        
        
    }
    //convert to LL
    static Node convertLL(int[] arr){
        
        Node dummy = new Node(0);
        Node head = dummy;
        
        for(int i=0;i<arr.length;i++){
           dummy.next = new Node(arr[i]);
           dummy = dummy.next;
        }
        return head.next;
    }
    
    //convert to array
    static int[] convert(Node head){
        List<Integer> list = new ArrayList<>();//maints insert order
        while(head!=null){
            list.add(head.data);
            head=head.next;
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}



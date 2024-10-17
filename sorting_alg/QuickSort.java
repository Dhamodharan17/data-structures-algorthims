class Solution
{
    //Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high)
    {
       // {9, 3, 8, 2, 7, 1, 5} quickSort(arr,0,n-1) - initial call
       if(low<high){
           int pi = partition(arr,low,high);
           quickSort(arr,low,pi-1);
           quickSort(arr,pi+1,high);
       }
    }
    static int partition(int arr[], int low, int high)
    {
        // {9, 3, 8, 2, 7, 1, 5}
        int pivot = arr[high];
        
        // all element greater then pivot should be on right of j
        int i=low;
        
        //basically i stops at smaller and swaps with j at greater element
        for(int j=low;j<high;j++){
            if(arr[j]<=pivot){//(3)
                swap(arr,i,j);//swap 9 and 3
                // {3, 9, 8, 2, 7, 1, 5}
                 i++;
            }else{
                //keep the i there itself - marking it is greater then pivot (9)
                //i wait here i will swap with smaller value so you go on right
            }
        }
        
        swap(arr,i,high);
        return i;
        
    } 
    
    static void swap(int arr[],int ele1,int ele2){
        int temp = arr[ele1];
        arr[ele1] = arr[ele2];
        arr[ele2] = temp;
    }
}

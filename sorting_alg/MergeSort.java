class Solution
{
    void merge(int arr[], int l, int m, int r)
    {
         int n1 = m-l+1;//since left side have mid
         int n2 = r-m;
         int[] left = new int[n1];
         int[] right = new int[n2];
         
         //fill temp array for left
         for(int i=0;i<n1;i++){
             left[i] = arr[l+i];
         }
         //fill temp array for right
         for(int i=0;i<n2;i++){
             right[i] = arr[m+1+i];//since mid+1 on right
         }
         
         //pointers
         int i=0,j=0;
         int k=l;//to start fill the orginal array from start i.e l
         
         //winner algorthim
         while(i<n1 && j<n2){
             if(left[i] <= right[j]){
                arr[k++] = left[i++];
             }else{
               arr[k++] = right[j++];  
             }
         }
         
         //add remaining elements
         while(i<n1){
             arr[k++] = left[i++];
         }
         while(j<n2){
             arr[k++] = right[j++];
         }
         
         
         
    }
    void mergeSort(int arr[], int l, int r)
    {
        
       //divide only one element
       if(l>=r) return;
       int mid = l+(r-l)/2;
       
       mergeSort(arr,l,mid);
       mergeSort(arr,mid+1,r);
       merge(arr,l,mid,r);
       
    }
}

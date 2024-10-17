class Solution
{
    //Function to build a Heap from array.
    void buildHeap(int arr[], int n)
    {
        //since leaf nodes do not have children, they do not need to be heapified.
      //heap prop is root should greater/less then children
        //The last level of the tree (leaf nodes) contains about n/2 and as we go n/2-1
        //as it is a complete tree
        //call for values from half to fist index of input array
        for(int i=n/2-1;i>=0;i--) heapify(arr,n,i);
    }
 
    //Heapify function to maintain heap property.
    void heapify(int arr[], int n, int i)
    {
        int left = 2*i+1;
        int right = 2*i+2;
        
        int largest = i; 
        
        if(left<n && arr[largest]<arr[left])
            largest = left;
        if(right<n && arr[largest] < arr[right])
            largest = right;
        
        if(largest!=i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr,n,largest);
        }
        
        
    }
    
    //Function to sort an array using Heap Sort.
    public void heapSort(int arr[], int n)
    {
        //convert to max heap
        buildHeap(arr,n);
       
        for(int i=n-1;i>=0;i--){
        //delete first element every time
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            heapify(arr,i,0);
        }
    }
 }
 
 

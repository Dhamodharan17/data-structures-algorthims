class Solution
{
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        
        ArrayList<Integer> sortedResult = new ArrayList<>();
        //2 pointer
        int p1=0,p2=0;
        
        while(p1<n && p2<m){
            
            //both are equal add once
            if(arr1[p1] <= arr2[p2]){
                 if( sortedResult.size() == 0 || sortedResult.get(sortedResult.size()-1) != arr1[p1])  sortedResult.add(arr1[p1]);
                 p1++;
            
            } else{// different add both in order
              if( sortedResult.size() == 0 || sortedResult.get(sortedResult.size()-1) != arr2[p2])  sortedResult.add(arr2[p2]);
              p2++;
            }
           
        }
        
        //edge case - one list ends early
        while(p1<n){
            if(  sortedResult.size() == 0 || sortedResult.get(sortedResult.size()-1) != arr1[p1])     sortedResult.add(arr1[p1]);
            p1++;
        }
        
         while(p2<m){
            if(  sortedResult.size() == 0 || sortedResult.get(sortedResult.size()-1) != arr2[p2])      sortedResult.add(arr2[p2]);
            p2++;
        }  
        
        return sortedResult;
    }
}

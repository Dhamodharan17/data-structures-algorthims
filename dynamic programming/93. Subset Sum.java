//memoization

class Solution{
    
    static Boolean[][] cache ;
    
    static Boolean isSubsetSum(int N, int arr[], int sum){
     cache = new Boolean[N][sum+1];
     return isSubset(0,arr,sum);
     
    }
    
    static Boolean isSubset(int index,int arr[],int sum){
        
        if(sum==0) return true;
        
        if(index==arr.length) return false;
        
        //return already cached value
        if(cache[index][sum]!=null) return cache[index][sum];
        
        //pick the sum
        Boolean selected = false;
        if(arr[index]<=sum){
            selected = isSubset(index+1,arr,sum-arr[index]); 
        }
        
        Boolean skipped = isSubset(index+1,arr,sum);
        
        return cache[index][sum] = selected || skipped;//if any one true -> true
        
    }
    
    
}

//Can I form the sum j by either including or excluding this element?

//tabulation

class Solution{

    static Boolean isSubsetSum(int N, int arr[], int sum){
   
        boolean dp[][] = new boolean[N][sum+1];
       
       //1st column sum = 0
       for(int i=0;i<N;i++){
           //all element can make sum 0, so all true
           dp[i][0] = true;
       }
       
       // for checking the index , when arr[0] value is less then sum then only we will get a index
      //order is important for subsets/subsequneces
       if(arr[0]<=sum) dp[0][arr[0]] = true;
      
    for(int i=1;i<N;i++){//take one element at time
    
        for(int target=1;target<=sum;target++ ){//check all target for taken
            
            // can i form the target?
        
            //1.using current element
            boolean taken = false;
            if(arr[i]<=target){
                //i have taken the element, 
                //the remaining sum should be present in subset
                taken = dp[i-1][target -arr[i]];
            }    
        
            //2. not using current element
            //current subset{1,2,3}
            // is {1,2} gives the sum im good
            boolean notTaken = dp[i-1][target];
            
          
            dp[i][target] = taken||notTaken;
        }
    }
    
    return dp[N-1][sum];
    
    }
    
}

//space opt - we only need previors row in both cases.

class Solution{

    static Boolean isSubsetSum(int N, int arr[], int sum){
   
        
        boolean prev[] = new boolean[sum+1];
       
       prev[0] = true;
       
       if(arr[0]<=sum) prev[arr[0]] = true;
      
    for(int i=1;i<N;i++){//take one element at time
        
        boolean[] cur = new boolean[sum+1];
        cur[0] = true;
        
        for(int target=1;target<=sum;target++ ){
            
            boolean taken = false;
            if(arr[i]<=target){
                taken = prev[target -arr[i]];
            }    
        
            boolean notTaken = prev[target];
            
            cur[target] = taken||notTaken;
        }
        prev = cur;
    }
    
    return prev[sum];
    
    }
    
}


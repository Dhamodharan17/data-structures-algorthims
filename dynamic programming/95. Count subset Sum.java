//recursion
class Solution{

	public int perfectSum(int arr[],int n, int sum) 
	{ 
	   return countAllSubsets(0,arr,n,sum);
	   
	} 
	
	
	int countAllSubsets(int index,int arr[],int n, int sum){
	   
	    if(sum==0) return 1;
	    
	    if(index==arr.length) return 0;
	    
	    int pick = 0;
	    if(arr[index]<=sum)
	      pick = countAllSubsets(index+1,arr,n,sum-arr[index]);
	    
	    int unPick = countAllSubsets(index+1,arr,n,sum);
	    
	    return pick + unPick;
	    
	}
}

//memoize

class Solution{
    Integer[][] cache;
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	   cache = new Integer[n][sum+1];
	   return countAllSubsets(n-1,arr,sum);
	   
	} 
	
	
	int countAllSubsets(int index,int arr[],int sum){
	   
	    if(sum==0) return 1;
	    
	    if(index==0) return arr[0]==sum?1:0;
	    
	    if(cache[index][sum]!=null) return cache[index][sum];
	    
	    int pick = 0;
	    if(arr[index]<=sum)
	      pick = countAllSubsets(index-1,arr,sum-arr[index]);
	    
	    int unPick = countAllSubsets(index-1,arr,sum);
	    
	    return cache[index][sum] = pick + unPick;
	    
	}
}


//tabulation

class Solution{
 
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	  //count
	  
	   int[] prev = new int[sum+1];
        
       prev[0] =1;//sum can be formed by any nunber 
       
       if(arr[0]<=sum)
            prev[arr[0]] = 1;
       
       for(int i=1;i<n;i++){//take each number in array
           
           int temp[] = new int[sum+1];
           temp[0] =1;
           for(int currentSum = 0;currentSum<=sum;currentSum++){//take each sum
               
               int pick=0;
               //pick - if it forms profir
               if(arr[i]<=currentSum)
                   pick= prev[currentSum-arr[i]];
               //don't pick - if prev +ve now positive
               int unPick = prev[currentSum];
               
               temp[currentSum] = pick+unPick;
               //number of ways fot form this target
               
           }
          prev= temp;
           
       }
       
       return prev[sum]; 

	} 
	

}

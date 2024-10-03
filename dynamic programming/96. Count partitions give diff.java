
class Solution {
    public static int countPartitions(int n, int d, int[] arr) {
     
     
     int totalSum = Arrays.stream(arr).sum();
     
     boolean[][] subsetSums = new boolean[n][totalSum+1];
     
     computeSubsets(subsetSums,arr,totalSum);
     
     int count = 0;
     
     for(int sum =0;sum<=totalSum;sum++){
         if(subsetSums[n-1][sum]){
             int s1=sum;
             int s2=totalSum-s1;
             int diff = Math.abs(s1-s2);
             if(diff==d) count++;
         }
     }
     
     
    return count;
    }
    
    //compute the subsetSums
    
   static public void computeSubsets(boolean[][] subsetSums,int[] arr,int totalSum){
        
        //basecase 1 - all elements can make sum 0
        for(int index=0;index<subsetSums.length;index++){
            subsetSums[index][0] =true;
        }
        
        //basecase 2 - 1st element can make the subset sum of arr[0] so true
        if(arr[0]<=totalSum) subsetSums[0][arr[0]] = true;
        
        
        //take each element - check that can form sum
        for(int index=1;index<subsetSums.length;index++){
            for(int sum=1;sum<=totalSum;sum++){
                
                boolean pick = false;
                //remaining should be there
                if(arr[index]<=sum)
                    //does the remaining sum present so i can say true
                    pick = subsetSums[index-1][sum-arr[index]];
                
                //previous subset
                boolean unPick =subsetSums[index-1][sum];
                
                subsetSums[index][sum] = pick || unPick;
                
            }
        }        
    
    }
    
}
        

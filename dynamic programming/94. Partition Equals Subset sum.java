
//recursion
boolean knapsack(int[] nums,int index,int target,Boolean[][] dp){

    if(index>=nums.length) return false;
  
    if(target<0) return false;

    if(target==0) return true;

    if(dp[index][target]!=null) return dp[index][target];

       boolean picked=  knapsack(nums,index+1,target-nums[index],dp);

       boolean nonpicked =  knapsack(nums,index+1,target,dp);

       return  dp[index][target] = (picked || nonpicked);
    
    }

//tabulation - we only need prev row

class Solution {
    public boolean canPartition(int[] nums) {
      
    int total = Arrays.stream(nums).sum();
    int target = total/2;
    if(total%2==1) return false;

    boolean[][] dp = new boolean[nums.length][target+1];

    //base case 1 - all elements can make target 0
     for(int values=0;values<nums.length;values++){
        dp[values][0] = true;
    }

     //1st element can be individual subset without depdendent
      if(nums[0]<=target) dp[0][nums[0]] = true;

      for(int index=1;index<nums.length;index++){
        for(int sum=1;sum<=target;sum++){

            //inside this loop only sum is our concern
            //iterative
            boolean useCurrentElement = false;
            if(nums[index]<=sum){
               useCurrentElement = dp[index-1][sum-nums[index]]; 
            }
            boolean skip = dp[index-1][sum];

            dp[index][sum] = skip||useCurrentElement;
        }
      }
        
        return dp[nums.length-1][target];
    }


}

//space

class Solution {
    public boolean canPartition(int[] nums) {
      
    int total = Arrays.stream(nums).sum();
    int target = total/2;
    if(total%2==1) return false;

    //previous subset
    boolean[] prev = new boolean[target+1];
    prev[0] = true;//all elements can make target 0


     //1st element can be individual subset without depdendent
      if(nums[0]<=target) prev[nums[0]] = true;

      for(int index=1;index<nums.length;index++){
         boolean[] temp = new boolean[target+1];
        for(int sum=1;sum<=target;sum++){

            boolean useCurrentElement = false;
            if(nums[index]<=sum){
               useCurrentElement = prev[sum-nums[index]]; 
            }
            boolean skip = prev[sum];

            temp[sum] = skip||useCurrentElement;
        }
        prev = temp;
      }
        
        return prev[target];
    }


}



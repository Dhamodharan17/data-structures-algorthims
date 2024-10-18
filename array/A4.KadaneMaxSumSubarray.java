class Solution {
    public int maxSubArray(int[] nums) {
        
        int ans=nums[0];
        int sum=0;
        for(int i=0;i<nums.length;i++){
            //start new subarray or continue it
            sum = Math.max(nums[i],sum+nums[i]);
            ans = Math.max(sum,ans);//we don't miss any subarray
        }

        return ans;
    }
}

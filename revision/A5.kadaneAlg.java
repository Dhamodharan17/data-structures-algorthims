class Solution {
    public int maxSubArray(int[] nums) {
      int ans=0;
      int sum=0;  

      for(int i=0;i<nums.length;i++){
        //continue or create new sum
        sum  = Math.max(nums[i],sum+nums[i]);
        ans = Math.max(sum,ans);

      }
      return ans;
    }
}

//https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
class Solution {
    public boolean check(int[] nums) {
        int drop=0;

        // for rotated array it should be one drop
        for(int index=1;index<nums.length;index++){
            if(nums[index] < nums[index-1]) drop++;
        }
        //if rotated array this will not be true
        if(nums[0] < nums[nums.length-1]) drop++;

        return drop<=1;
    }
}

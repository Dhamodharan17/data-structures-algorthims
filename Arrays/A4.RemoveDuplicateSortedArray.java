class Solution {
    public int removeDuplicates(int[] nums) {
        
        //holds unduplicate array
        int p1=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]!=nums[p1]){
                nums[++p1] = nums[i];
            }
        }

        return p1+1;
    }
}

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        return expressionFinder(0,nums,0,target);

    }

    int expressionFinder(int index,int[] nums,int target,int S){

        
        if(index==nums.length){
            if(target==S) return 1;
            else return 0;
        }


        int plusOperation = expressionFinder(index+1,nums,target+nums[index],S);

        int minusOperation = expressionFinder(index+1,nums,target-nums[index],S);

        return plusOperation + minusOperation;

    }
}

//memo
class Solution {
    Integer[][] cache;
    int total;
    public int findTargetSumWays(int[] nums, int target) {

        total = Arrays.stream(nums).sum();
        cache = new Integer[nums.length][2*total+1];
        return expressionFinder(0,nums,0,target);

    }

    int expressionFinder(int index,int[] nums,int target,int S){

        
        if(index==nums.length){
            if(target==S) return 1;
            else return 0;
        }

        if(cache[index][target+total]!=null) return cache[index][target+total];


        int plusOperation = expressionFinder(index+1,nums,target+nums[index],S);

        int minusOperation = expressionFinder(index+1,nums,target-nums[index],S);

        return cache[index][target+total] = plusOperation + minusOperation;

    }
}

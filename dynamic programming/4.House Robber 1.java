//https://leetcode.com/problems/house-robber/

//recursion
class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length-1;
        return robUtil(n,nums);

    }

    int robUtil(int index,int[] nums){

        if(index<0) return 0;
        //when no house he cannot rob anthing

        int robCurrentHouse = nums[index] + robUtil(index-2,nums);

        int skipCurrentHouse = robUtil(index-1,nums);

        return Math.max(robCurrentHouse,skipCurrentHouse);
    }
}

//memoization

class Solution {

    Integer[] cache ;
    public int rob(int[] nums) { 
        int n = nums.length-1;
        cache = new Integer[n+1];
        return robUtil(n,nums);
    }

    int robUtil(int index,int[] nums){

        if(index<0) return 0;
        //when no house he cannot rob anthing
        if(cache[index] !=null) return cache[index];
        int robCurrentHouse = nums[index] + robUtil(index-2,nums);

        int skipCurrentHouse = robUtil(index-1,nums);

        return cache[index] = Math.max(robCurrentHouse,skipCurrentHouse);
    }
}

//tabulation

class Solution {

    Integer[] cache ;
    public int rob(int[] nums) { 

        //step1
        int n = nums.length-1;
        cache = new Integer[nums.length];
        //step2
        cache[0] = nums[0];
        if(n>0)
          cache[1] = Math.max(nums[0],nums[1]);

        for(int i=2;i<=n;i++){

            // if you rob, take value form2 house back since we cannot rob adjcent
            int rob = nums[i] + cache[i-2];
            // if you skip, u can take previous house value alone
            int skip = cache[i-1];
            cache[i] = Math.max(rob,skip);
        }

        return cache[n];
    }

    int robUtil(int index,int[] nums){

        if(index<0) return 0;
        //when no house he cannot rob anthing
        if(cache[index] !=null) return cache[index];
        int robCurrentHouse = nums[index] + robUtil(index-2,nums);

        int skipCurrentHouse = robUtil(index-1,nums);

        return cache[index] = Math.max(robCurrentHouse,skipCurrentHouse);
    }
}

//space optimization

class Solution {

    public int rob(int[] nums) { 

        //step1
        int n = nums.length-1;
        
        if(n==0) return nums[0];

        int back = nums[0];
        int immediateBack = Math.max(nums[0],nums[1]);

        for(int i=2;i<=n;i++){

            // if you rob, take value form2 house back since we cannot rob adjcent
            int rob = nums[i] + back;
            // if you skip, u can take previous house value alone
            int skip = immediateBack;
            
            back = immediateBack;
            immediateBack = Math.max(rob,skip);//immediate back will new value
        }

        return immediateBack;
    }

}


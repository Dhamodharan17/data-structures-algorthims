//https://leetcode.com/problems/house-robber-ii/
class Solution {
    public int rob(int[] nums) {

    int n = nums.length-1;

     int[] houseSet1 = new int[nums.length-1];
     int[] houseSet2 = new int[nums.length-1];
    
    //leave last house
    for(int i=0;i<houseSet1.length;i++){
        houseSet1[i] = nums[i];
    }

    //leave 1st house
     for(int i=0;i<houseSet2.length;i++){
        houseSet2[i] = nums[i+1];
    }

     return Math.max(robUtil(n-1,houseSet1),robUtil(n-1,houseSet2));

    }

    int robUtil(int index,int[] nums){

        if(index<0) return 0;
        //when no house he cannot rob anthing

        int robCurrentHouse = nums[index] + robUtil(index-2,nums);

        int skipCurrentHouse = robUtil(index-1,nums);

        return Math.max(robCurrentHouse,skipCurrentHouse);
    }
    
}

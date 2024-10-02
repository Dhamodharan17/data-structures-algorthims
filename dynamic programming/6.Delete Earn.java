//recursion
/*
https://leetcode.com/problems/delete-and-earn/
In this problem, if you pick nums[i] to earn points, you must also delete all occurrences of nums[i] - 1 and nums[i] + 1 from the array. 
This means that by choosing a number, you lose the opportunity to pick its immediate neighbors, either lower or higher by one.
*/

class Solution {
    //rules - when u pick a element you should pick any neighbouring element
    
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int maxNum = nums[n-1];
        int[] freq = new int[maxNum+1];

        for(int num:nums){
            freq[num]++;
        }

        return findMaxPointsRec(freq,maxNum);

    }   
        
       int findMaxPointsRec(int[] freq,int n) {

            if(n<=0) return 0;
            // if delete, cannot delete next immediate greater
            int delete = n*freq[n] + findMaxPointsRec(freq,n-2);
            int notDelete = findMaxPointsRec(freq,n-1);

            return Math.max(delete,notDelete);
        }
}

//memoize
class Solution {
    //rules - when u pick a element you should pick any neighbouring element

    Integer[] cache;
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
    
        int maxNum = nums[n-1];
        int[] freq = new int[maxNum+1];
        cache =  new Integer[maxNum+1];

        for(int num:nums){
            freq[num]++;
        }

        return findMaxPointsRec(freq,maxNum);

    }   
        
       int findMaxPointsRec(int[] freq,int n) {

            if(n<=0) return 0;

            if(cache[n]!=null) return cache[n];

            // if delete, cannot delete next immediate greater
            int delete = n*freq[n] + findMaxPointsRec(freq,n-2);
            int notDelete = findMaxPointsRec(freq,n-1);

            return cache[n]= Math.max(delete,notDelete);
        }
}


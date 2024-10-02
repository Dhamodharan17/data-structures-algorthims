// https://leetcode.com/problems/climbing-stairs/


// solution 1 - reursion
class Solution {
    public int climbStairs(int n) {
    
        if(n==0 || n==1) return 1;

        return climbStairs(n-1) + climbStairs(n-2);
    }
}

//solution 2 - memoization
class Solution {

    public int climbStairs(int n) {
        
        Integer[] dp = new Integer[n+1];
        climbStairsHelper(n,dp);
        return dp[n];

    }

    int climbStairsHelper(int n,Integer[] dp){

        if(dp[n]!=null) return dp[n];

        if(n==0 || n==1) return dp[n]=1;

        return dp[n] = climbStairsHelper(n-1,dp) + climbStairsHelper(n-2,dp);
    }
}

//solution 3 - tabulation

class Solution {

    public int climbStairs(int n) {
        
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
       
        return dp[n];

    }
}

// solution 4 - space optimized

class Solution {

    public int climbStairs(int n) {
        
        
       int immediateBack=1;
       int back=1;

        for(int i=2;i<=n;i++){
           int temp = immediateBack;
           immediateBack = immediateBack+back;
           back = temp;
        }
       
        return immediateBack;

    }
}




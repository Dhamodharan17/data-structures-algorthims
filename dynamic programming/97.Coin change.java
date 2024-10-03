//recursion

class Solution {
    public int coinChange(int[] coins, int amount) {

        //knapsack
        //whenever we react 0 send me 1 i will 
        int numberOfCoins = coins.length;
        int ans =minCoinChangeFinder(numberOfCoins-1,coins,amount);

        return ans==Integer.MAX_VALUE?-1:ans;
    }


    int minCoinChangeFinder(int index,int[] coins,int amount){


//reached last index amount =6 coin =2 used coins = 3
        if(index==0) return amount%coins[0]==0?(amount/coins[0]):Integer.MAX_VALUE;

        int pick=Integer.MAX_VALUE;
        if(coins[index]<=amount)
            pick= 1+minCoinChangeFinder(index,coins,amount-coins[index]);
        
        int skip = 0+minCoinChangeFinder(index-1,coins,amount);

        return Math.min(pick,skip);


    }
}

//memoization
class Solution {

    Integer[][] cache;
    public int coinChange(int[] coins, int amount) {

        int numberOfCoins = coins.length;
        cache = new Integer[numberOfCoins][amount+1];

        int ans =minCoinChangeFinder(numberOfCoins-1,coins,amount);

        return ans==100000?-1:ans;
    }


    int minCoinChangeFinder(int index,int[] coins,int amount){

        //reached last index amount =6 coin =2 used coins = 3
        if(index==0) return amount%coins[0]==0?(amount/coins[0]):100000;
    
        if(cache[index][amount]!=null) return cache[index][amount];

        int pick=100000;

        if(coins[index]<=amount)
            pick= 1+minCoinChangeFinder(index,coins,amount-coins[index]);
        
        int skip = 0+minCoinChangeFinder(index-1,coins,amount);

        return cache[index][amount]= Math.min(pick,skip);
    }
}

//tabulation

class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int n=coins.length;
        int[][] dp = new int[n][amount+1];

        //filling for 1sr coin
        for(int sum=0;sum<=amount;sum++){ //all sums
            if(sum%coins[0]==0)
                dp[0][sum] = sum/coins[0];
            else
                dp[0][sum] = (int) Math.pow(10,9);
        }

        for(int index = 1;index<n;index++){//take each value

            for(int sum=1;sum<=amount;sum++){
                
               int notTake = 0+dp[index-1][sum];

               int take = (int)Math.pow(10,9);
               //checking the amount is available for remaining notes
               if(coins[index]<=sum)
                    take = 1+dp[index][sum-coins[index]];


                dp[index][sum] = Math.min(take,notTake);
            }

        }

        return dp[n-1][amount]==(int)Math.pow(10,9)?-1:dp[n-1][amount];

    }
}


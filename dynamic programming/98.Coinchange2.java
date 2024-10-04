class Solution {

    Integer[][] cache;
    public int change(int amount, int[] coins) {
        int n=coins.length;
        cache = new Integer[n][amount+1];

        return coinChangeUtil(coins.length-1,coins,amount);

    }

    int coinChangeUtil(int index,int[] coins,int amount){

        if(amount==0) return 1;

        if(index<0) return 0;

        if(cache[index][amount]!=null) return cache[index][amount];
        //if(index==0) return amount%coins[0]==0?1:0;

        int pick = 0;
        if(coins[index]<=amount)
            pick = coinChangeUtil(index,coins,amount-coins[index]);
        int skip = coinChangeUtil(index-1,coins,amount);

        return cache[index][amount]=pick + skip;
    }
}

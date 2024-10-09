class Solution {
    public int maxProfit(int[] prices) {

      //fix buy day
        int left=0;
        int right =0;
        int maxProfit=0;

        while(right<prices.length){
        
        if(prices[left] < prices[right]){
            maxProfit = Math.max(maxProfit,prices[right] - 
            prices[left]);
        }else{
          //change buy day, if we get lesser then current buy day
            left = right;
        }

        right++;
        }

    return maxProfit;

    }
}

class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        return collectKnapsack(N-1,N,W,val,wt);
    }
    
    
    static int collectKnapsack(int index,int N,int W,int[] val,int[] wt){
        
        // if(index==0){
        //      return ((int)W/wt[0] )* val[0];
        // }
        
        if(index<0) return 0;

        int pick = Integer.MIN_VALUE;
        if(wt[index]<=W)
            pick = val[index] + collectKnapsack(index,N,W-wt[index],val,wt);
        
        int skip = collectKnapsack(index-1,N,W,val,wt);
        
        
        return Math.max(pick,skip);
        
    }
}

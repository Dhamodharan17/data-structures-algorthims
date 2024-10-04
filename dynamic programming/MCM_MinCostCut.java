class Solution {
    public int minCost(int n, int[] cuts) {

        List<Integer> cutsList = new ArrayList<>();
        for(int x:cuts)
            cutsList.add(x);


        cutsList.add(0);
        cutsList.add(n);
        Collections.sort(cutsList);
      
        //passing original indexes
        int i=1,j=cuts.length;
        return minCostUtil(i,j,n,cutsList);
        
    }
       int  minCostUtil(int i,int j,int n,List<Integer> cutsList){
            
            if(i>j) return 0;

            int minCost = Integer.MAX_VALUE;
            // k paritions
            for(int k=i;k<=j;k++){
              
                //length of the stick
                int cost = cutsList.get(j+1) - cutsList.get(i-1)+
                minCostUtil(i,k-1,n,cutsList)+minCostUtil(k+1,j,n,cutsList);
                minCost = Math.min(cost,minCost);
              
            }

            return minCost;
        }
    
}

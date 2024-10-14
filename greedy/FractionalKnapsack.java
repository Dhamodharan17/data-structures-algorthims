class Solution {
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int w, Item arr[], int n) {
        
        //Decision 1 - Sort based on desc order (per kg value) so I will get more valuable item on top
        Arrays.sort(arr,(b,a)->Double.compare((double)a.value/a.weight,(double)b.value/b.weight));
        
        double profit=0;
        
        for(Item item:arr){
            
            if(w==0) break;
            
            int currentWeight = item.weight;
            //Decision 2 - Pick complete item or part of it
            if(currentWeight<=w){
                profit = profit + item.value;
                w = w-currentWeight;
            }else if(currentWeight>w){
                //how many times we can fit in current weight to w
                double fraction = (double)w/currentWeight;
                profit += item.value * fraction;
                w = 0;
            }
            
        }
        
        return profit;
    }
}

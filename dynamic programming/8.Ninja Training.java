
//recursion
class Solution {
    public int maximumPoints(int arr[][], int N) {
        
        //start training
        return startTraining(N-1,-1,arr);
        
    }
    
    int startTraining(int day,int last,int arr[][]){
        
        //base case
        if(day==0){
            int maxi=0;
            for(int i=0;i<=2;i++){
                //i should not practice last day skill
                if(i==last) continue;
                maxi = Math.max(maxi,arr[0][i]);//1st row ith skill
            }
            return maxi;
        }
        
        int maxi=0;
        for(int i=0;i<=2;i++){
            // current point + get remaining points for further days
            if(i==last) continue;
            //try remaining days
            int skill = arr[day][i] + startTraining(day-1,i,arr);
            maxi = Math.max(maxi,skill);
        }
        
        return maxi;
        
    }
    
}

//memoize
class Solution {
    Integer[][] cache;
    public int maximumPoints(int arr[][], int N) {
        
        //start training
        cache = new Integer[N+1][4];
        return startTraining(N-1,3,arr);
        
    }
    
    int startTraining(int day,int last,int arr[][]){
        
        // now im looking for what I can earn in a day when last day = last
        if(cache[day][last] != null) return cache[day][last];
        
        //base case
        if(day==0){
            int maxi=0;
            int i;
            for( i=0;i<=2;i++){
                //i should not practice last day skill
                if(i==last) continue;
                maxi = Math.max(maxi,arr[0][i]);//1st row ith skill
            }
            return cache[day][last]=maxi;
        }
        
        int maxi=0;
        int i;
        for( i=0;i<=2;i++){
            // current point + get remaining points for further days
            if(i==last) continue;
            //try remaining days
            int skill = arr[day][i] + startTraining(day-1,i,arr);
            maxi = Math.max(maxi,skill);
        }
        
        return cache[day][last]=maxi;
        
    }
    
}

//tabulation
class Solution {
    public int maximumPoints(int arr[][], int N) {
        //step1 - declare array
        int[][] dp = new int[N+1][4];
        
        //step2 - base case
        
        //day 1 last day 1
        dp[0][0] = Math.max(arr[0][1],arr[0][2]);
          //day  last day 2
        dp[0][1] = Math.max(arr[0][0],arr[0][2]);
           //day 1 last day 3
        dp[0][2] = Math.max(arr[0][1],arr[0][0]);
           //day 1 last day nothing
        dp[0][3] =Math.max(arr[0][0],
            Math.max(arr[0][1],arr[0][2]));
            
            //iteration
        for(int day=1;day<N;day++){
            for(int last=0;last<4;last++){
                dp[day][last]=0;
                for(int task = 0;task<=2;task++){
                    if(task==last) continue;
                    //current + cache of previous day different task
                    int skill = arr[day][task]+
                    dp[day-1][task];
                    dp[day][last] = Math.max(dp[day][last],skill);
                }
            }
        }
        
        return dp[N-1][3];
            
    }
}

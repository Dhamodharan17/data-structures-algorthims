//https://leetcode.com/problems/unique-paths/

//recursion
class Solution {
    public int uniquePaths(int m, int n) {
        
       return countUniquePaths(m-1,n-1); 

    }

    int countUniquePaths(int m,int n){

        if(m==0 && n==0) return 1;

        if(m<0 || n<0) return 0;

        int up = countUniquePaths(m-1,n);

        int left = countUniquePaths(m,n-1);

        return up+left;


    }
}

//memoize
class Solution {
    Integer[][] cache ;
    public int uniquePaths(int m, int n) {
        cache = new Integer[m][n];
       return countUniquePaths(m-1,n-1); 

    }

    int countUniquePaths(int m,int n){

        if(m==0 && n==0) return 1;

        if(m<0 || n<0) return 0;

        if(cache[m][n]!=null) return cache[m][n];


        int up = countUniquePaths(m-1,n);

        int left = countUniquePaths(m,n-1);

        return cache[m][n]=up+left;


    }
}

//tabulation
class Solution {
    Integer[][] cache ;
    public int uniquePaths(int m, int n) {
        
        //step1: declare
        int[][] dp = new int[m][n];

        //step2:base case
        dp[0][0] =1;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0) continue;
                int left = j>0? dp[i][j-1]:0;
                int right= i>0 ?dp[i-1][j]:0;
                dp[i][j] = left+right;
            }
        }

       return dp[m-1][n-1];

    }

    int countUniquePaths(int m,int n){

        if(m==0 && n==0) return 1;

        if(m<0 || n<0) return 0;

        if(cache[m][n]!=null) return cache[m][n];

        int up = countUniquePaths(m-1,n);

        int left = countUniquePaths(m,n-1);

        return cache[m][n]=up+left;

    }
}

//space opt

class Solution {

    public int uniquePaths(int m, int n) {
        
        //holds prev row
        int[] prev = new int[n];

        for(int i=0;i<m;i++){
            //left value
            int[] temp = new int[n];
            for(int j=0;j<n;j++){
                if(i==0 && j==0) {
                    temp[j]=1;
                    continue;
                }
                //get from previous column
                int left = j>0? temp[j-1]:0;
                //get from previous row
                int up= i>0?prev[j]:0;
                temp[j] = left+up;
            }
            prev=temp;
        }

       return prev[n-1];

    }
}










//recursion

  int function(int n1,String text1,int n2,String text2){

        if(n1<0 || n2< 0) return 0;

        if(text1.charAt(n1)==text2.charAt(n2)){
            return 1+function(n1-1,text1,n2-1,text2);
        }else{
            return Math.max(
                function(n1-1,text1,n2,text2),
                function(n1,text1,n2-1,text2)
            );
        }

    }

//tabulation

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int n1=text1.length();
        int n2=text2.length();

        int[][] dp = new int[n1+1][n2+1];

        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
              if(text1.charAt(i-1) == text2.charAt(j-1)){
                dp[i][j] = 1+dp[i-1][j-1];
            }else{
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        }
        return dp[n1][n2];

    }
}

//space

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        int n1 = text1.length();
        int n2 = text2.length();

        int[] dp = new int[n2 + 1];

        for (int i = 1; i <= n1; i++) {// string1
            int[] cur = new int[n2 + 1];
            for (int j = 1; j <= n2; j++) {// string 2
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    cur[j] = 1 + dp[j - 1];
                } else {
                    //dp[j] = prev cur[j-1] = current 
                    cur[j] = Math.max(dp[j], cur[j - 1]);
                }
            }
            dp=cur;
        }
        return dp[n2];

    }
}

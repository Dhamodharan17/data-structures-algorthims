class Solution {
    public int longestPalindromeSubseq(String s) {

        String revS = new StringBuilder(s).reverse().toString();
        int n1=s.length();
        int n2=revS.length();

        int[][] dp = new int[n1+1][n2+1];
        for(int s1=1;s1<=n1;s1++){
            for(int s2=1;s2<=n2;s2++){
                if(s.charAt(s1-1) == revS.charAt(s2-1)){
                    dp[s1][s2] = 1+dp[s1-1][s2-1];
                }else{
                    dp[s1][s2] = Math.max(dp[s1][s2-1],dp[s1-1][s2]);
                }
            }
        }

        return dp[n1][n2];
    }
}

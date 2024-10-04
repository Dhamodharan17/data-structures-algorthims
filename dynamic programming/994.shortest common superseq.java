class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {

        int n1 = str1.length();
        int n2 = str2.length();
        int[][] table = lcs(str1,str2,n1,n2);

        int i=n1,j=n2;
        StringBuffer ans = new StringBuffer();

    //travesing table from right bottom
        while(i>0 && j>0){

            if(str1.charAt(i-1) == str2.charAt(j-1)){
                //go diagonal
                ans.append(str1.charAt(i-1));
                i--;
                j--;
            }else if(table[i-1][j]>table[i][j-1]){
                //go up for more lcs
                ans.append(str1.charAt(i-1));
                i--; 
            }else{
                ans.append(str2.charAt(j-1));
                j--; 
            }
        }

        while(i>0){
             ans.append(str1.charAt(i-1));
                i--; 
        }

        while(j>0){
            ans.append(str2.charAt(j-1));
                j--; 
        }

        return ans.reverse().toString();

    }

    int[][] lcs(String str1,String str2,int n1,int n2){

        int[][] dp = new int[n1+1][n2+1];

        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){

                if(str1.charAt(i-1) ==  str2.charAt(j-1)){
                    dp[i][j] = 1+ dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max( dp[i-1][j] , dp[i][j-1]);
                }
           }
        }

        return dp;

    }
}


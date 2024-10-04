//tabulation

class Solution {
    public int longestCommonSubstr(String str1, String str2) {
    
    int n1 = str1.length();
    int n2 = str2.length();
    
    int[][] table = new int[n1+1][n2+1];
    int lcs=0;
    
    for(int s1=1;s1<=n1;s1++){
        for(int s2=1;s2<=n2;s2++){
            
            if(str1.charAt(s1-1) == str2.charAt(s2-1)){
                table[s1][s2] = 1+table[s1-1][s2-1];
                lcs = Math.max(lcs,table[s1][s2]);
            }else{
              //consective propery lost
                table[s1][s2]=0;
            }
            
        }
    }
    
    return lcs;
    }
}

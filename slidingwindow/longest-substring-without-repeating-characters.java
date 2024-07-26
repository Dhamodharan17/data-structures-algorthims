class Solution {

    // ap2: sliding window
    public int lengthOfLongestSubstring(String s) {

       int[] dam = new int[128];

       int left=0;//contract the window
       int right=0;//extend the window
    
       int res = 0;

       while(right<s.length()){
        char r = s.charAt(right);//s1: extend the windows to get the 
        dam[r]++;

        //s2: when duplicate make the left come to right to start new window
        while(dam[r]>1){
            char l = s.charAt(left);
            dam[l]--;
            left++;
        }

        res = Math.max(res,right-left+1);
        right++;
       }
    return res;   
    }
}

class Solution {
    public int numDistinct(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        return findLCS(n1-1,n2-1,s,t);

    }

    int findLCS(int s1,int t1,String s,String t){

        if(t1<0) return 1;//1 common subseq ""

        if(s1<0) return 0;

        if(s.charAt(s1) == t.charAt(t1)){
          //Input: s = "babgbag", t = "bag"
          //if we decrease both we will miss to match bag since will lose g.
          //also there might be multiple occurence of t1 in s2
            return findLCS(s1-1,t1-1,s,t) + findLCS(s1-1,t1,s,t);
        }else{
            return findLCS(s1-1,t1,s,t);
        }

    }

}

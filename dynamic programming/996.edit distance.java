class Solution {
    public int minDistance(String word1, String word2) {
        
        int n1 = word1.length();
        int n2 = word2.length();

        return minDistanceUtil(n1-1,n2-1,word1,word2);

    }

    int minDistanceUtil(int w1,int w2,String word1,String word2){

        //no words in word1 , put all word2 to word 1
        if(w1<0) return w2+1;

      //no words in word2 , delete allin word 1
        if(w2<0) return w1+1;

        if(word1.charAt(w1) == word2.charAt(w2)){
            return 0 + minDistanceUtil(w1-1,w2-1,word1,word2);
        }else{
            //1 + insert, , repalce,delete
            return 1+  Math.min(minDistanceUtil(w1-1,w2-1,word1,word2), minDistanceUtil(w1-1,w2,word1,word2));
        }

    }

}


/*

change one string to another

when characters doesn't match only we need perform operation. so 1
what happens after that make a function all

*/

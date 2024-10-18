//brute force
class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {

        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        
        int n = queries.length;
        int[] res = new int[n];
        for(int i=0;i<n;i++){
           int[] current = queries[i];
           int count=0;
            for(int j=current[0]; j<=current[1] ;j++){
                //check condition
                String cur = words[j];
                if(vowels.contains(cur.charAt(0)) && vowels.contains(cur.charAt(cur.length()-1))) count++;
            }
            res[i] = count;
        }
        return res;
    }
}

//prefix sum

class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        
        int n = queries.length;
        int w = words.length;

        //prefix array
        int[] prefixArray = new int[w];
        for(int i=0;i<w;i++){
             String cur = words[i];
             if(vowels.contains(cur.charAt(0)) && vowels.contains(cur.charAt(cur.length()-1))){
                prefixArray[i] =1;
             }else{
                prefixArray[i] = 0;
             }
        }
        // cumulative sum
         for(int i=1;i<w;i++){
            prefixArray[i] += prefixArray[i-1];
         }

        //result
        int[] result = new int[n];
        for(int i=0;i<n;i++){
            int[] current = queries[i];
            int start = current[0];
            int end = current[1];
           // ans = total - remove extra
            result[i] = (start>0)? prefixArray[end] - prefixArray[start-1]: prefixArray[end];
        }

        return result;
    }
}

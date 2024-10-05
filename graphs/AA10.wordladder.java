class Solution {

    // to store word and current sequence since we need to find the shortest sequence
    class Pair{
        String first;
        int second;
        Pair(String first,int second){
            this.first = first;
            this.second = second;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Queue<Pair> q = new LinkedList<>();
        //start point
        q.add(new Pair(beginWord,1));

        // for quick reference 
        Set<String> set = new HashSet<String>();
        for(String word:wordList)
            set.add(word);
        
        set.remove(beginWord);

        while(!q.isEmpty()){

            Pair current = q.remove();
            String word = current.first;
            int steps = current.second;

            if(word.equals(endWord)) return steps;

            //for each index of current word try all possible 
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    
                    StringBuffer newString = new StringBuffer(word);
                    newString.setCharAt(i,ch);
                    if(set.contains(newString.toString())){
                        set.remove(newString.toString());
                        q.add(new Pair(newString.toString(),steps+1));
                    }
                }
            }
        }

return 0;
    }
}

class TrieNode{

    TrieNode[] children;
    boolean isEnd;

    TrieNode(){
        children = new TrieNode[26];
    }
}

class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        
        TrieNode temp = root;
        for(int index=0;index<word.length();index++){
            int charIndx = word.charAt(index) - 'a';
            if(temp.children[charIndx] == null){
                temp.children[charIndx] = new TrieNode();
            }
            temp = temp.children[charIndx];
        }
        temp.isEnd = true;
    }
    
    public boolean search(String word) {  
        TrieNode temp = root;
        for(int index=0;index<word.length();index++){
            int charIndex = word.charAt(index) - 'a';
            if(temp.children[charIndex] == null) return false;
            temp = temp.children[charIndex];
        }

     return temp.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for(int index=0;index<prefix.length();index++){
            int charIndex = prefix.charAt(index) - 'a';
            if(temp.children[charIndex] == null) return false;
            temp = temp.children[charIndex];
        } 

        return true;
    }
}

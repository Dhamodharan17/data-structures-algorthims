
class Trie {
    TrieNode root;
  // go to the last node of prefix from there collect all words.
  //recursion and backtracking
    Trie() {
        root = new TrieNode();
    }
  
  
    public List<String> getAutoSuggestions(String prefix) {
        List<String> suggestions = new ArrayList<>();
        TrieNode node = searchNode(prefix);

        if (node == null) {
            return suggestions; // No suggestions if the prefix is not found
        }

        // Recursively collect all words from prefix end
        collectAllWords(node, new StringBuilder(prefix), suggestions);
        return suggestions;
    }
  
    //collect words
    private void collectAllWords(TrieNode node, StringBuilder currentWord, List<String> suggestions) {
      
        if (node.isEnd) {
            suggestions.add(currentWord.toString()); 
        }

        // Recursively search for all child nodes
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
              
                char nextChar = (char) ('a' + i); // Convert index to character
                collectAllWords(node.children[i], currentWord.append(nextChar), suggestions);
                currentWord.deleteCharAt(currentWord.length() - 1); // Backtrack after recursion
              
            }
        }
    }


   //prefix node
    private TrieNode searchNode(String prefix) {
        TrieNode temp = root;
        for (int i = 0; i < prefix.length(); i++) {
          
            int charIndex = prefix.charAt(i) - 'a';
            if (temp.children[charIndex] == null) {
                return null; // Prefix not found
            }
          
            temp = temp.children[charIndex];
        }
        return temp;
    }
  
}

public class AutoSuggestionSystem {
    public static void main(String[] args) {
        Trie trie = new Trie();
        String prefix = "art";
        List<String> suggestions = trie.getAutoSuggestions(prefix);
    }
}

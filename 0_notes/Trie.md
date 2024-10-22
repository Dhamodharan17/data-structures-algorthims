### Trie

#### TrieNode
```
class TrieNode{
    
    HashMap<Character,TrieNode> children;
    boolean isEnd;
    TrieNode(){
        isEnd = false;
    }
}
```
#### Iteration
```current = current.children.get(c);```
#### char checking
```current.children.containsKey(c)```

#### Delete
```
 static TrieNode remove(TrieNode root, char[] key, int level, int len) {
        
        if (root == null) return null;
        if (level == len) {
            if (root.isEnd) {
                root.isEnd = false;
            }
            if (isEmpty(root)) {
                root = null;
            }
            return root;
        }
        
        
        char currentChar = key[level];
        // root.children[index]=
        root.children.put(currentChar, remove(root.children.get(currentChar), key, level + 1, len));
        
        if (isEmpty(root) && !root.isEnd) {
          //no children and not end of any word - remove it
            root = null; 
        }

        return root;
    }
    static boolean isEmpty(TrieNode node) {
        return node.children.isEmpty(); // Return true if no children
    }
}
```
#### Recursion
```
 private void findAllSuggestions(TrieNode node, StringBuilder currentPrefix, List<String> suggestions) {
        // If this node marks the end of a word, add the word to suggestions
        if (node.isEnd) {
            suggestions.add(currentPrefix.toString());
        }

        // Recursively check all child nodes
        for (char c : node.children.keySet()) {
            currentPrefix.append(c);
            findAllSuggestions(node.children.get(c), currentPrefix, suggestions);
            currentPrefix.deleteCharAt(currentPrefix.length() - 1); // Backtrack
        }
    }
```

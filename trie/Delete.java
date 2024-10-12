class Solution
{
  // recursion return true or same node
    public static void deleteKey(TrieNode root,char[] key)
    {
     
        int len = key.length;
        if(len<=0) return;
        remove(root,key,0,len-1);
     }
     
     static TrieNode remove(TrieNode root,char key[] ,int level,int len){
         
         if(root==null) return null;
         
         if(level==len){
             
             //if its end of word - make it false;
             if(root.isEnd)
                root.isEnd = false;
            
            //check any other word sharing
            if(isEmpty(root)){
                root=null;
            }
            return root;
         }
         
        int index = key[level]-'a';
        
        //attach null or same node
        root.children[index] = remove(root.children[index],key,level+1,len);
        
        //current char doesn't have child and not end of any word - delete
        if(isEmpty(root) && root.isEnd == false){
            root = null;
        }
        return root;
        
     }
     
     static boolean isEmpty(TrieNode root){
         for(int i=0;i<26;i++){
             if(root.children[i]!=null) return false;
         }
         return true;
     }
}

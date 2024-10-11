class Solution {
    //2 steps
  // 1. swap with last node
  //2.delete the last node -> making it null and return root.
    public Node deletionBT(Node root, int key){
        
        Node tobeDelete= null;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        Node current = null;
        while(!queue.isEmpty()){
            
            current = queue.remove();
            
            if(current.data == key){
                tobeDelete = current;
            }
            if(current.left!=null){
                queue.add(current.left);
            }
            if(current.right!=null){
                queue.add(current.right);
            }
            
        }
        
        if(tobeDelete == null) return null;
        
        tobeDelete.data = current.data;
        //delete the current node
        return deleteDeeper(root,current);
    }
    
     public Node deleteDeeper(Node root,Node delete){
            
             
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        Node current = null;
        while(!queue.isEmpty()){
            
            current = queue.remove();
            
            if(current==delete){
                current=null;
                return root;
            }
            
            if(current.left!=null){
                if(current.left==delete){
                    current.left=null;
                    return root;
                }else{
                    queue.add(current.left);
                }
            }
            
           if(current.right!=null){
                if(current.right==delete){
                    current.right=null;
                    return root;
                }else{
                    queue.add(current.right);
                }
            }
            
        }
         
        return root; 
            
    }
}

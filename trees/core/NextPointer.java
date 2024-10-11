class Solution {
    public Node connect(Node root) {
        
        if(root == null) return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            Node prev = null;
            for(int i=0;i<size;i++){
            
                Node current = q.remove();
                // for previous current is answer
                if(prev!=null){
                    prev.next=current;
                }
                prev = current;
                if(current.left!=null) q.add(current.left);
                if(current.right!=null) q.add(current.right);         
            }
        }

    return root;
    }
}

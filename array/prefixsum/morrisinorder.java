class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> inorder = new ArrayList<>();
        TreeNode current= root;

        while(current != null){
            
            //no more left process and move right
            if(current.left== null){
                //process left - 1
                inorder.add(current.val);
                //use existing link if to come back to root if it is inorder successor
                current = current.right;
            }else{
                    TreeNode prev = current.left;.
                    while(prev.right!=null && prev.right!=current){
                        prev = prev.right;
                    }

                    if(prev.right==null){
                        //store to comeback to root again
                        prev.right = current;
                        //move left->left->left
                        current = current.left;
                    }else{
                        //executes after moving up and processing same node
                        prev.right=null;
                        inorder.add(current.val);//process after left 2
                        current = current.right;
                    }

            }//end of if else

        }//end of while
    return inorder;
    }
}

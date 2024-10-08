class Solution {
    TreeNode one=null;
    TreeNode two = null;
    TreeNode prev = null;

    public void recoverTree(TreeNode root) {

        inorder(root);
        int temp = one.val; 
        one.val = two.val;
        two.val = temp;
    }

    void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);

        if(prev != null && prev.val>root.val){
            if(one==null) one =prev;
            two = root;
        }
        prev =root;//will be on back
        inorder(root.right);

    }
}

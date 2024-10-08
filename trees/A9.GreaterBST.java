class Solution {
    int sum=0;
    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.right);
        sum=sum+root.val;
        root.val = sum;
        dfs(root.left);
    }

}

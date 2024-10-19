class Solution {
    public int maxAncestorDiff(TreeNode root) {
        if(root==null) return 0;
        return function(root,root.val,root.val);
    }

    int function(TreeNode root,int min,int max){ 
        // each path monitor min and max -> return at end
        if(root==null) return Math.abs(min-max);
  
        min = Math.min(min,root.val);
        max = Math.max(max,root.val);

        int left = function(root.left,min,max);
        int right = function(root.right,min,max);

        return Math.max(left,right);
    }
}

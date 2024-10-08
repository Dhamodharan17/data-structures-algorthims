
class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        
        if(original == null) return null;

        if(original == target) return cloned;

        TreeNode left = getTargetCopy(original.left,cloned.left,target);
        TreeNode right = getTargetCopy(original.right,cloned.right,target);

        return left!=null?left:right;
     
    }

 
}

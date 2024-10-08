class Solution {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        height(root);
        return max - 1;
    }

    int height(TreeNode root) {

        if (root == null)
            return 0;

        int left = height(root.left);
        int right = height(root.right);
        max = Math.max(max, left + right + 1);
        return Math.max(left, right) + 1;

    }
}

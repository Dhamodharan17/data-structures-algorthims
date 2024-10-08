class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        
        return build(nums,0,nums.length-1);
    }

    TreeNode build(int[] nums,int start,int end){

        if(start>end) return null;
        int mid = start + (end - start)/2;
        TreeNode head = new TreeNode(nums[mid]);
        head.left = build(nums,start,mid-1);
        head.right = build(nums,mid+1,end);
        return head;
    }


}

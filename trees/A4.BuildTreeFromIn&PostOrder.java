class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        return build(0,inorder.length-1,inorder,0,postorder.length-1,postorder);

    }


    public TreeNode build(int iStart,int iEnd,int[] inorder,int pStart,int pEnd,int[] postorder){

        if(iStart>iEnd || pStart>pEnd) return null;

        int root = postorder[pEnd];
        TreeNode head = new TreeNode(root);

        int index=0;
        for(int i=iStart;i<=iEnd;i++){
            if(inorder[i]==root){
                index = i;
                break;
            }
        }

        int numberofnodes = index - iStart;
        //divide and conquer
        head.left = build(iStart,index-1,inorder,
        pStart,pStart+numberofnodes-1,postorder);

        head.right = build(index+1,iEnd,inorder,
        pStart+numberofnodes,pEnd-1,postorder);

        return head;

    }
}

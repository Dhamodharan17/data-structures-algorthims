class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {

     return build(inorder,0,inorder.length-1,0,postorder.length-1,postorder);

    }

    TreeNode build(int[] inorder,int iStart,int iEnd,int pStart,int pEnd,int[] postorder){
        
        if(iStart>iEnd || pStart> pEnd) return null;

        TreeNode root = new TreeNode(postorder[pEnd]);

        int sep=-1;
        for(int i=iStart;i<=iEnd;i++){
            if(inorder[i] == root.val){
                sep =i;
                break;
            }
        }

        if(sep==-1) return root;

        int numberofnodes = sep - iStart;
        //postorder
        root.left = build(inorder,iStart,sep-1,pStart,pStart+numberofnodes-1,postorder);
        root.right = build(inorder,sep+1,iEnd,pStart+numberofnodes,pEnd-1,postorder);
        //preorder
        //root.left = build(iStart,sep-1,inorder,pStart+1,pStart+num,preorder);
        //root.right = build(sep+1,iEnd,inorder,pStart+num+1,pEnd,preorder);


        return root;
    }

}

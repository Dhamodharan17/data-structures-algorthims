class Solution {

    List<Integer> ans = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        findNode(root,target,k);
        return ans;

    }

    int findNode(TreeNode root,TreeNode target,int k){

        if(root == null) return -1;

        if(root == target){
            collectKNodesDown(root,k);
            return 0;
        }

        int left = findNode(root.left,target,k);

        // -1 indicates , we haven't found target
        if(left!=-1){
            if(left+1==k) ans.add(root.val);
            collectKNodesDown(root.right,k-left-2);
            return left+1;
        }


        int right = findNode(root.right,target,k);
        if(right!=-1){
            if(right+1==k) ans.add(root.val);
            // initially right=0, it will make 2 steps[target-root,root-left]
            //since target is found in right of it
            collectKNodesDown(root.left,k-right-2);
            return right+1;
        }

        return -1;

    }

    void collectKNodesDown(TreeNode root,int k){

        if(root == null) return;
        if(k==0){
            ans.add(root.val);
            return;
        }
        collectKNodesDown(root.left,k-1);
        collectKNodesDown(root.right,k-1);
    }
}

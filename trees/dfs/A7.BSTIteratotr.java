class BSTIterator {
    List<Integer> list;
    int index = 0;
    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        inorder(root);
    }

    void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    
    public int next() {
        return list.get(index++);
    }
    
    public boolean hasNext() {
        return index<list.size();
    }
}

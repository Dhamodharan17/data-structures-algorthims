/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    HashMap<Integer,TreeMap<Integer,List<Integer>>> map = new HashMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        List<List<Integer>>  result = new ArrayList<>();

        traverse(root,0,0);
        
        for(int i=minCol;i<=maxCol;i++){
           
            List<Integer> temp = new ArrayList<>();
            for(List<Integer> list:map.get(i).values()){
                Collections.sort(list);
                temp.addAll(list);
               
            }
             result.add(temp);
        }

        return result;
    }

    int minCol = Integer.MAX_VALUE;
    int maxCol = Integer.MIN_VALUE;

    void traverse(TreeNode root,int col,int row){
        if(root == null) return ;

        if(!map.containsKey(col))map.put(col,new TreeMap<>());

        if(!map.get(col).containsKey(row)) map.get(col).put(row,new ArrayList<>());

        minCol = Math.min(minCol,col);
        maxCol = Math.max(maxCol,col);

        map.get(col).get(row).add(root.val);

        traverse(root.left,col-1,row+1);
        traverse(root.right,col+1,row+1);
    }



}

class Solution {
    
   static ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        
        function(root,new ArrayList<>());
        return result;
    }
    
    static void function(Node root,ArrayList<Integer> list){
        
        if(root==null){
            return;
        }
        
        list.add(root.data);
          
        if(root.left==null && root.right == null){
            result.add(new ArrayList<>(list));
        }else{
            
        function(root.left,list);
        function(root.right,list); 
        
        }
        //after completing left and right remove it
        //but if were proccesing till null, we should remove the leaf node
        list.remove(list.size()-1);
        
    }
}

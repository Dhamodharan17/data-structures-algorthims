/*
data strcuture - stack
dfs
data strcuture - array
*/

class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
      Stack<Integer> stack = new Stack<>();
      boolean[] vis = new boolean[V];
      
      for(int i=0;i<V;i++){
          if(vis[i]) continue;
          dfs(i,adj,vis,stack);
      }
      
      int[] nodes = new int[V];
      int index=0;
      
      while(!stack.isEmpty()){
          nodes[index++] = stack.pop();
      }
      
      return nodes;
      
    }
    
    static void dfs(int current,ArrayList<ArrayList<Integer>> adj,boolean[] vis,Stack<Integer> stack){
        
        vis[current] = true;
        
        for(int next: adj.get(current)){
            if(vis[next]) continue;
            dfs(next,adj,vis,stack);
        }
        
        stack.add(current);
        
    }
}

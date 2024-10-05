/*
datastruture
dfs - return

*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
    
        boolean[] vis = new boolean[V];
        boolean[] rec = new boolean[V];
        
        for(int i=0;i<V;i++){
            if(dfs(i,adj,vis,rec)) return true;
        }
        
        return false;
        
    }
    
   static boolean dfs(int current, ArrayList<ArrayList<Integer>> adj,boolean[] vis,boolean[] rec){
        
        if(rec[current]) return true;
        
        if(vis[current]) return false;
        
        vis[current] = true;
        rec[current] = true;
        for(int next: adj.get(current)){
            if(dfs(next,adj,vis,rec)) return true;
        }
        rec[current] = false;
        
        return false;
    }
}

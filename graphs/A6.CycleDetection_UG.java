//https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
// key: parent variable
//when u see a node which is not your parent the cycle

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
     
     boolean[] visited = new boolean[V];
     
     for(int i=0;i<V;i++){
         if(visited[i]) continue;
         if(dfs(i,-1,adj,visited)) return true;
     }
      
     return false;
    }
    
    
    boolean dfs(int current,int parent,ArrayList<ArrayList<Integer>> adj,boolean[] vis){
       
       vis[current] = true;
       
       for(int next: adj.get(current)){
           
           // next edge already visited and next is not my parent(undirected graph)
           if(vis[next] && next!=parent) return true;
           
           if(vis[next]) continue;
           
           //if anytime this gets true(means cycle) return true
          if( dfs(next,current,adj,vis)) return true;
           
       }
       
       return false;
    }
}

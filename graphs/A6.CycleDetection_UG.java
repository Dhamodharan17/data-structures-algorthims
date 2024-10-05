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

//bfs

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean[] vis = new boolean[V];
        
        for(int i=0;i<V;i++){
            if(vis[i]) continue;
            if(bfs(i,-1,adj,vis)) return true;
        }
    
        return false;
    }
    
    
    boolean bfs(int current,int parent,ArrayList<ArrayList<Integer>> adj,boolean[] vis ){
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{current,parent});
        vis[current] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.remove();
            
            //level wise
            for(int next: adj.get(cur[0])){
                // I (current) see a node which is already visited. since we process 
                //level by level it means it is reached through different path
                if(vis[next] && next != cur[1]) return true;
                
                if(vis[next]) continue;
                
                q.add(new int[]{next,cur[0]});
                vis[next] = true;
           }
        }
        
        return false;
    }
    
}


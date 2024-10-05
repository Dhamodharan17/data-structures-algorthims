//DFS- call next and deeper

//matrix
class Solution {
    public int findCircleNum(int[][] isConnected) {
            
            int count =0;

            int n = isConnected.length;
            boolean[] visited = new boolean[n];
            for(int i=0;i<n;i++){
                if(visited[i]) continue;
                findNumberofProv(i,isConnected,visited);
                count++;
            }

            return count;
    }

    void findNumberofProv(int node,int[][] isConnected,boolean[] visited){

    visited[node]=true;
      //call next
     for(int next=0;next<isConnected.length;next++){
        if(visited[next] || isConnected[node][next]==0) continue;
        findNumberofProv(next,isConnected,visited);
     }   
       
    }

}
//adj list
class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        
        boolean[] vis = new boolean[V];
        int count=0;
        
        for(int i=0;i<V;i++){
            if(vis[i]) continue;
            count++;
            dfs(i,adj,vis);
        }
        
        return count;
        
    }
    
    static void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] vis){
        
        vis[node]=true;
        // call relatives
        for(int next:adj.get(node)){
            if(next==0 || vis[next]) continue;
            dfs(next,adj,vis);
        }
        
        
    }
    
};

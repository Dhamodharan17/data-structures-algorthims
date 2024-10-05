//matrix https://leetcode.com/problems/number-of-provinces/
class Solution {

    boolean[] visited;
    public int findCircleNum(int[][] isConnected) {

        int count=0;
        int  n = isConnected.length;
        visited = new boolean[n];

        for(int i=0;i<n;i++){
            if(visited[i]) continue;
            bfs(i,isConnected);
            count++;
        }

    return count;
    }


    void bfs(int node,int[][] isConnected){

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;

       while(!queue.isEmpty()){
        int current = queue.remove();
        //call next
        for(int i=0;i<isConnected.length;i++){
            if(visited[i] || isConnected[current][i]==0) continue;
            queue.offer(i);
            visited[i] = true;
        }

       }
    }


}

//adj list - https://www.geeksforgeeks.org/problems/number-of-provinces/1
class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        
        boolean[] vis = new boolean[V];
        int count=0;
        
        for(int i=0;i<V;i++){
            if(vis[i]) continue;
            count++;
            bfs(i,adj,vis);
        }
        
        return count;
        
    }
    
    static void bfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] vis){
        
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node]=true;
        
        while(!q.isEmpty()){
             // call relatives
            node = q.remove();
            for(int next:adj.get(node)){
            if(next==0 || vis[next]) continue;
            q.add(next);
            vis[next]=true;
        }
      }
}
    
};

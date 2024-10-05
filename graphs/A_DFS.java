//DFS- call next and deeper

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

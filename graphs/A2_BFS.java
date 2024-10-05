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

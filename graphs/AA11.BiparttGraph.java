/*
-conversion
-logic (colors array)
-bfs( return)

*/

class Solution {

    public void converter(int[][] graph, List<List<Integer>> list,int n){
        
        for(int i=0;i<n;i++)
            list.add(new ArrayList<>());

        for(int i=0;i<graph.length;i++){
            for(int next:graph[i]){
                list.get(i).add(next);
                list.get(next).add(i);
            }
        }

    }
    public boolean isBipartite(int[][] graph) {

        List<List<Integer>> list = new ArrayList<>();
        int n = graph.length;
        converter(graph,list,n);

        int[] colors = new int[n];
        Arrays.fill(colors,-1);

        for(int i=0;i<n;i++){
            if(colors[i]!=-1) continue;
            if(bfs(i,list,colors)) return false;
        }

        return true;

    }

    boolean bfs(int current,List<List<Integer>> list,int[] colors){
        
        Queue<Integer> q = new LinkedList<>();
        q.add(current);
        //give 1 to current
        colors[current] = 1;

        while(!q.isEmpty()){
            int cur = q.remove();
            
            for(int next:list.get(cur)){

                if(colors[cur] == colors[next]) return true;

                if(colors[next] == -1){
                    //opposite to next
                    colors[next] = colors[cur]^1;
                    //assigned a color check neighbour
                    q.add(next);
                }

            }
        }

    return false;
    }
}

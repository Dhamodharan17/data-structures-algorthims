class Solution {
    
    public void preProcess(int n,int[][] edges,List<List<Integer>> list){
        
        for(int iteration=0;iteration<n;iteration++){
            list.add(new ArrayList<>());
        }
        
        
        for(int[] edge:edges){
            list.get(edge[0]).add(edge[1]);
        }
        
    }
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        
        
       List<List<Integer>> list = new ArrayList<>();
       preProcess(n,edges,list);
        
       Queue<Integer> q = new LinkedList<>();
       q.add(src);
    
        int[] distance = new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[src] = 0;
        
       while(!q.isEmpty()){
            
            int current = q.remove();
            
            for(int next: list.get(current)){
                int newDistance = distance[current] +1;
                if(distance[next]>newDistance){
                 distance[next] = distance[current]+1;   
                 q.add(next);
                }
            }
       }
       
       for(int iteration=0;iteration<n;iteration++){
           if(distance[iteration] == Integer.MAX_VALUE){
               distance[iteration] = -1;
           }
       }
       
       
    return distance;
    }
}

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
    
    int[] inDegree = new int[V];
    
    for(int current=0;current<adj.size();current++){
        for(int next: adj.get(current)){
            inDegree[next]+=1;
        }
    }
    
    Queue<Integer> q = new LinkedList<>();
    for(int i=0;i<V;i++){
        if(inDegree[i] == 0){
            q.add(i);
        }
    }
    
    while(!q.isEmpty()){
        int current = q.remove();
        
        for(int next: adj.get(current)){
            inDegree[next]--;
            if(inDegree[next]==0){
                q.add(next);
            }
        }
    }
    
    
    for(int i=0;i<V;i++){
        if(inDegree[i]!=0) return true;
    }
    
    return false;
    }
}

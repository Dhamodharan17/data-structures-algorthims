class Solution {

    class Pair{
        int dest;
        int wt;
        Pair(int dest,int wt){
            this.dest = dest;
            this.wt = wt;
        }
    }

    void processInput(int N,int[][] edges,List<List<Pair>> list){
        
        for(int i=0;i<N;i++)
            list.add(new ArrayList<>());
            
        for(int[] edge: edges){
            list.get(edge[0]).add(new Pair(edge[1],edge[2]));
        }
        
    }
	public int[] shortestPath(int N,int M, int[][] edges) {
		
	  List<List<Pair>> list = new ArrayList<>();
	  processInput(N,edges,list);
	  
	  boolean[] vis = new boolean[N];
	  Stack<Integer> stack = new Stack<>();
	  toposort(0,list,vis,stack);
	  
	 int[] distance = new int[N];
	 Arrays.fill(distance,Integer.MAX_VALUE);
	 distance[0] = 0;
	 
	 while(!stack.isEmpty()){
	       //update distance
	     int current = stack.pop();
	     
	     for(Pair next:list.get(current)){
	         int newDistance = distance[current] + next.wt;
	         if(newDistance < distance[next.dest]){
	             distance[next.dest] = newDistance;
	         }
	     }
	 }
	 
	 for(int i=0;i<N;i++){
	     if(distance[i]==Integer.MAX_VALUE) distance[i] =-1;
	 }
	 
	 return distance;
	}
	
	void toposort(int current,List<List<Pair>> list,boolean[] vis,Stack<Integer> stack){
	    
	    vis[current] = true;
	    
	    for(Pair next:list.get(current)){
	        if(vis[next.dest]) continue;
	        toposort(next.dest,list,vis,stack);
	    }
	    
	    stack.add(current);
	    
	}
}

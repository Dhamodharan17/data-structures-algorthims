class Pair{
    int dest;
    int wt;
    Pair(int dest,int wt){
        this.dest = dest;
        this.wt = wt;
    }
}

class Solution {
    // minimum time to reach from src to all nodes
    public int networkDelayTime(int[][] times, int n, int k) {
        //from one node, we can multiple nodes
        List<List<Pair>> list = new ArrayList<>();
        for(int i=0;i<=n;i++)
            list.add(new ArrayList<>());

        for(int[] time: times){
            list.get(time[0]).add(new Pair(time[1],time[2]));
        }

        HashSet<Integer> visited = new HashSet<>();

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(p->p.wt));
        pq.add(new Pair(k,0));
        int cost = 0;

        while(!pq.isEmpty()){
            
            Pair current = pq.remove();
            visited.add(current.dest);
            cost = Math.max(current.wt,cost);
            for(Pair next:list.get(current.dest)){
                if(visited.contains(next.dest)) continue;
                pq.add(new Pair(next.dest,current.wt+next.wt));
            }
        }

        return visited.size()==n?cost:-1;
    }
}

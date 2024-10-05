/*

just change the direction

im not depent on you, u dependent on me
*/
class Solution {

    public List<Integer> eventualSafeNodes(int[][] graph) {

        int nodes = graph.length;

        //preprocess
        List<List<Integer>> adjList = new ArrayList<>();

        for(int iteration=0;iteration<=nodes;iteration++){
            adjList.add(new ArrayList<>());
        }    

        int inDegree[] = new int[nodes];

        for(int iteration=0;iteration<nodes;iteration++){
            int[] current = graph[iteration];
            for(int next:current){
                adjList.get(next).add(iteration);
                inDegree[iteration]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int iteration=0;iteration<nodes;iteration++){
            if(inDegree[iteration] == 0)  q.add(iteration);
        }

        List<Integer> result = new ArrayList<>();
        

        while(!q.isEmpty()){
            int current = q.remove();
            result.add(current);
            
            for(int next:adjList.get(current)){
                inDegree[next]--;
                if(inDegree[next]==0){
                    q.add(next);
                }
            }
        }

        Collections.sort(result);
        return result;

    }
}


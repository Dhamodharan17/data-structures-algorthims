class Solution {

    //process
    void process(int n,int[][] prerequisites,List<List<Integer>> list){

        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }

        for(int[] p:prerequisites){
            list.get(p[0]).add(p[1]);
        }
        
    }


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> list = new ArrayList<>();
        process(numCourses,prerequisites,list);

        int[] inDegree = new int[numCourses];
        for(int current=0;current<numCourses;current++){
            for(int next: list.get(current)){
                inDegree[next]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(inDegree[i] == 0) q.add(i);
        }

        while(!q.isEmpty()){

            int current = q.remove();
            for(int next:list.get(current)){
                inDegree[next]--;
                if(inDegree[next] == 0){
                    q.add(next);
                }
            }
        }

        for(int i=0;i<numCourses;i++){
            if(inDegree[i] != 0) return false;
        }

        return true;
    }
}

class Solution {

   void preProcessInput(int numCourses,int[][] prerequisites,List<List<Integer>> adjListInput){

    for(int n=0;n<numCourses;n++)
        adjListInput.add(new ArrayList<>());
    
    for(int[] prerequisite: prerequisites){
        adjListInput.get(prerequisite[1]).add(prerequisite[0]);
    }

   }


    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adjListInput = new ArrayList<>();

        preProcessInput(numCourses,prerequisites,adjListInput);

        int[] inDegree = new int[numCourses];

        for(int current=0;current<numCourses;current++){
            for(int next:adjListInput.get(current))
                inDegree[next]++;
        }

        Queue<Integer> q = new LinkedList<>();

       for(int course=0;course<numCourses;course++){
        if(inDegree[course]==0) q.add(course);
       }

       int[] courseCompletionOrder = new int[numCourses];
       int index=0;

        while(!q.isEmpty()){
            
            int currentCourse = q.remove();
            courseCompletionOrder[index++] = currentCourse;

            for(int next:adjListInput.get(currentCourse)){
                inDegree[next]--;
                if(inDegree[next]==0) q.add(next);
            } 
        }

        return index==numCourses?courseCompletionOrder:new int[]{};

    }
}

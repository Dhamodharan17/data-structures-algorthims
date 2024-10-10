class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals,(a,b)-> a[0]-b[0]);

        List<int[]> merge = new ArrayList<>();
        int[] newInterval = intervals[0];

        for(int[] interval : intervals){
            
            //merge if end and start collides
            if(newInterval[1] >= interval[0]){
                newInterval[1] = Math.max(interval[1] , newInterval[1]);
            }else{
                merge.add(newInterval);
                newInterval = interval;
            }
        }

         merge.add(newInterval);
         return merge.toArray(new int[merge.size()][]);

    }
}

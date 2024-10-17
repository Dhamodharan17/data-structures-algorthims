class Solution {
    public int[][] merge(int[][] intervals) {

        List<int[]> result = new ArrayList<>();
        int[] prevInterval = intervals[0];

        for(int[] interval: intervals){

            //if current interval starts within previous interval - merge it
            if(interval[0]<=prevInterval[1]){
                prevInterval[1] = Math.max(prevInterval[1],interval[1]);
            }else{
                result.add(prevInterval);
                prevInterval = interval;
            }
        }
        result.add(prevInterval);
        return result.toArray(new int[result.size()] []);

    }
}



class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));

        int count=1;
        int lastInterval = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            //non overlapping case - current meeting start after last meeting
           if( intervals[i][0] >= lastInterval){
            count++;
            lastInterval = intervals[i][1];
           }

        }
    // total - overlap
    return intervals.length-count;
    }
}

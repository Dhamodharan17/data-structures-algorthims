class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        int n = intervals.length;
        List<int[]> result = new ArrayList<>();

        int i=0;
    
        //case 1: whoever ended before I start - don't overlap
        //I went homw by 6AM, he came  by 8AM(newinteval)
        while(i<n && intervals[i][1] < newInterval[0]){
            result.add(intervals[i]);
            i++;
        }

        //case 2 : whoever within me
        //I came by 8AM , he(newinterval) worked till 9 AM (overlap)
        //new interval then old interval plot like this
        while(i<n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            i++;
        }

        result.add(newInterval);

        //whoever start after I ended - overlap
        while(i<n){
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);

    }
}

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

     
        //case 1: whatever ends before my start i can ignore
        //if consider whatever starts before, it can end before me also

        //case 2 : whatever start after my end i can ignore
        //if consider whatever end before

    List<int[]> res = new ArrayList<>();
    for(int[] inter : intervals){

        if(newInterval == null || inter[1]<newInterval[0]){//case 1
            res.add(inter);
        }else if(inter[0] >newInterval[1]){ //case 2
            res.add(newInterval);
            res.add(inter);
            newInterval = null;
        }else{
            newInterval[0] = Math.min(inter[0],newInterval[0]);
            newInterval[1] = Math.max(inter[1],newInterval[1]);
        }

    }
        if(newInterval!=null) res.add(newInterval);
        return res.toArray(new int[res.size()][]);

    }
}

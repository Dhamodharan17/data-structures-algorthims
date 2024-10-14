class Solution {
    
    static class StationEvent{
        int time;
        int arrival;
        StationEvent(int time,int arrival){
            this.time = time;
            this.arrival = arrival;
        }
    }
    
    static int findPlatform(int arr[], int dep[]) {
    
    List<StationEvent> events = new ArrayList<>();


    for(int index=0;index<arr.length;index++){
        events.add(new StationEvent(arr[index],1));
        events.add(new StationEvent(dep[index],0));
    }
  
//Decision 1: Sort based on  time and give preference to early arrival      
 events.sort((o1, o2) -> {
    int timeComparison = Integer.compare(o1.time, o2.time);
    if (timeComparison != 0) {
        return timeComparison; // If times are different, return the comparison result
    }
    // If times are the same, compare arrival times
    return Integer.compare(o2.arrival, o1.arrival); // Reverse order for arrival
});
    
    //Decision 2 - arrival increase platform , departure decrease platform
    int platforms=0;
    int minPlatform=0;
    for(StationEvent event:events){
        
        if(event.arrival == 1){
           platforms++; 
        }else{
            platforms--;
        }
        minPlatform = Math.max(minPlatform,platforms);
    }
    
    return minPlatform;
    
    }
}

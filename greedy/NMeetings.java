class Solution {
    
   //record Meeting(int start, int end) {}
   
   class Meeting{
       int start;
       int end;
       Meeting(int start,int end){
           this.start = start;
           this.end = end;
       }
   }
   
    public int maxMeetings(int n, int start[], int end[]) {
      
     List<Meeting> meetings = new ArrayList<>();
     for(int i=0;i<n;i++){
         meetings.add(new Meeting(start[i],end[i]));
     }
     
     //Decision 1 - sort based on who ends early(asc)
     meetings.sort((a,b)->Integer.compare(a.end,b.end));
     
     //Decision 2 - give room ends early (spends less time)
     int count=0;
     int startTime=-1;
     for(Meeting meeting:meetings){
         
         if(meeting.start>=startTime){
             count++;
             //making current end time as new start time
             startTime = meeting.end;
         }
         
     }
     
      return count;
    }
}

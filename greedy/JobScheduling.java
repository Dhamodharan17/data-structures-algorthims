//https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1
class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        /*
        
        Greedy Decision we made is
        1. take items which gives more profit (sorted desc)
        2. use the exact deadline then come to next so other lower
        deadline jobs will get chance to execute 
        */
        
        //Decision 1
        Arrays.sort(arr,(j1,j2)->Integer.compare(
            j2.profit,j1.profit));
            
       boolean[] slots = new boolean[n+1];
       Arrays.fill(slots,true);
       int profit = 0,slotUsed=0;
       
       for(Job job:arr){
           int deadline = job.deadline;
           
           //Decision 2
           while(deadline>0 && !slots[deadline]){
               deadline--;
           }
           
           //if all deadline are filled will get -ve , as we are decrementing above
           if(deadline>0){
               profit += job.profit;
               slotUsed++;
               slots[deadline]=false;
               
           }
       }
       
       return new int[]{slotUsed,profit};
    }
}

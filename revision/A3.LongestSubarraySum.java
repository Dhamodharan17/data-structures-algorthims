
class Solution {
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr(int A[], int N, int K) {
        
        HashMap<Integer,Integer> prefixSum = new HashMap<>();
        prefixSum.put(0,-1);
        int max = 0;
        
        int sum =0;
    
        for(int i=0;i<N;i++){
            
            sum = sum+A[i];
            int prefix = sum - K;
            
            if(prefixSum.containsKey(prefix)){
                max = Math.max(max,i-prefixSum.get(prefix));
            }
        
            if(!prefixSum.containsKey(sum)) {
                prefixSum.put(sum, i);
            }        
        }
        
        return max;
        
    }
}

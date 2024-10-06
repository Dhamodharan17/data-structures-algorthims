//https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        
        Queue<Integer> pq = new PriorityQueue<>();
        int[] out = new int[k];

        for(int n:nums){
            pq.add(n);
            if(pq.size()>k) pq.poll();
        }

        int idx=0;

        // for maintaining input order
       for(int n:nums){
        if(pq.contains(n)){
            out[idx++] = n;
            pq.remove(n);
            if(pq.size() == 0) break;
        }
       }

    return out;
    }
}

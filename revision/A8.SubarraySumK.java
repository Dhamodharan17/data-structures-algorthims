class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int count=0;
        HashMap<Integer,Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1);

        int sum = 0;
        for(int n:nums){
            sum = sum+n;
            int prefix = sum-k;

            if(sumMap.containsKey(prefix)){
                count+= sumMap.get(prefix);
            }

            sumMap.put(sum, sumMap.getOrDefault(sum,0)+1);
        }

    return count;
    }
}

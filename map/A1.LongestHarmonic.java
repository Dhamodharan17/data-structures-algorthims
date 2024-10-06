Aclass Solution {
    public int findLHS(int[] nums) {
        
        int count = 0;

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int n:nums)
            map.put(n, map.getOrDefault(n,0)+1);
        
        for(int key:map.keySet()){
            //since the the next element can only make the diff
            if(map.containsKey(key+1)){
                count = Math.max(count,
                map.get(key) + map.get(key+1));
            }
        }

        return count;
    }
}

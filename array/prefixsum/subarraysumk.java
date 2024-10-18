//prefix sum
class Solution {
    public int subarraySum(int[] arr, int k) {
        int count = 0, n = arr.length;
        int arraySum = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 1);

        for (int i = 0; i < n; i++) {
            arraySum = arraySum + arr[i];
            // does any subarray i can ignore
            int prefix = arraySum - k;

            if (countMap.containsKey(prefix)) {
                // number of subarray having prefix
                count = count + countMap.get(prefix);
            }
            countMap.put(arraySum, countMap.getOrDefault(arraySum, 0) + 1);
        }
        return count;
    }
}

//brute force
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count=0, n = nums.length;
        for(int i=0;i<n;i++){
            int sum = nums[i];
            if(sum==k) count++;
            for(int j=i+1;j<n;j++){
                sum += nums[j];
                if(sum == k) count++;
            }
        }  
        return count;
    }
}


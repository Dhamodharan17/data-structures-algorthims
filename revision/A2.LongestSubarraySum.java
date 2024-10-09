


import java.util.*;

public class Main {
    public static int getLongestSubarray(int []a, long k) {
        int n = a.length;

        int left = 0, right = 0; // 2 pointers
        long sum = a[0];
        int maxLen = 0;
        while (right < n) {

          // reduce untill sum becomes less the k or left crosses
            while (left <= right && sum > k) {
                sum -= a[left];
                left++;
            }
          
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
          
            right++;
            if (right < n) sum += a[right];
        }

        return maxLen;
    }

 
}


/*
AP1: Linear search with max variable O(n)
AP2: Sort and pick the last element O(nlogn)
AP3: add to heap and pick the top O(n)
*/

class Solution {
    public static int largest(int[] arr) {
        int max=arr[0];
        
        for(int index=1;index<arr.length;index++){
            if(arr[index]>max){
                max = arr[index];
            }
        }
        
        return max;
    }
}

//https://www.naukri.com/code360/problems/counting-sort_2663351
import java.util.* ;
import java.io.*; 
public class Solution {
	//arr = {4, 2, -2, 8, 3, 3, 1, -2, 0, 3}
    public static int[] sort(int n, int arr[]) {
		
		if(arr.length == 0) return null;

		int max = Arrays.stream(arr).max().getAsInt();
		int min = Arrays.stream(arr).min().getAsInt();

		int n1 = max-min +1;// range of values
		int[] count = new int[n1];

		//count array
		for(int num : arr){
			count[num-min]++;//-2-(-2) =0;
		}

		//count sum array
		for(int i=1;i<count.length;i++){
			count[i] += count[i-1];
		}

		int output[] = new int[n];
		for(int i=n-1;i>=0;i--){
			//count[arr[i]] - ideal
			//- 1 since count sum will give 1 based indexing
			int position = count[arr[i] - min] - 1;
			//how many elements less then = arr[i] including itself
			//position how small it is , if 8 it means it is 8th smallest and 7 are in back
			output[position] = arr[i];
			count[arr[i] - min]--;
		}

		return output;

	}

}

/*
find the smallest and largest
again find smallest which should not be previosulsy found
same for largest
https://www.naukri.com/code360/problems/ninja-and-the-second-order-elements_6581960
*/
public class Solution {
    public static int[] getSecondOrderElements(int n, int []a) {
    
     int small = Integer.MAX_VALUE;
     int large = Integer.MIN_VALUE;

     int secondSmall = Integer.MAX_VALUE;
     int secondLarge = Integer.MIN_VALUE;


     for(int index =0 ;index<n;index++){
         large = Math.max(large, a[index]);
         small = Math.min(small, a[index]);
     }

     for(int index =0 ;index<n;index++){
         
         if(a[index] < secondSmall && small!=a[index]){
             secondSmall = a[index];
         }
         else if (a[index] > secondLarge && large!=a[index]){
             secondLarge = a[index];
         }
     }

    return new int[]{secondLarge,secondSmall};

    }
}

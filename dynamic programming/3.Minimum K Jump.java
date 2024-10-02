//https://www.geeksforgeeks.org/problems/minimal-cost/1

//recursion

class Solution {
    public int minimizeCost(int k, int arr[]) {
        
        return minimizeCostUtil(arr.length-1,arr,k);   
    }
    public int minimizeCostUtil(int index,int arr[],int k) {
        
    if(index<0) return Integer.MAX_VALUE;//no way to reach n
    
    if(index==0) return 0;//energy required to each 0 from 0
    
    int minEnergy = Integer.MAX_VALUE;
    //from every index we can go to next k index
    for(int i=1;i<=k;i++){
        
        //jump should be valid
        if(index<i) continue;// if index is smaller then i will get -ve index
         //jump linearly till k
        int currentEnergy = Math.abs(arr[index] - arr[index-i]);
       // find energy lost from index+i to end
       int furtherEnergyRequired = minimizeCostUtil(index-i,arr,k);
       
       minEnergy = Math.min(minEnergy,currentEnergy+furtherEnergyRequired);
        
    }
    
    return minEnergy;
    
  }
}


//memoization

class Solution {
    Integer[] cache;
    public int minimizeCost(int k, int arr[]) {
        cache = new Integer[arr.length];
        return minimizeCostUtil(arr.length-1,arr,k);
        
    }
    
    
    public int minimizeCostUtil(int index,int arr[],int k) {
        
    if(index<0) return Integer.MAX_VALUE;//no way to reach n
    
    if(cache[index]!=null) return cache[index];
    
    if(index==0) return cache[index]= 0;//energy required to each 0 from 0
    
    int minEnergy = Integer.MAX_VALUE;
    //from every index we can go to next k index
    for(int i=1;i<=k;i++){
        
        //jump should be valid
        if(index<i) continue;// if index is smaller then i will get -ve index
         //jump linearly till k
        int currentEnergy = Math.abs(arr[index] - arr[index-i]);
       // find energy lost from index+i to end
       int furtherEnergyRequired = minimizeCostUtil(index-i,arr,k);
       
       minEnergy = Math.min(minEnergy,currentEnergy+furtherEnergyRequired);
        
    }
    
    return cache[index]= minEnergy;
    
  }
}


//tabulation

class Solution {
    Integer[] cache;
    public int minimizeCost(int k, int arr[]) {
        
        cache = new Integer[arr.length];
        
        cache[0] = 0;//energy required to reach 0 from 0
        
        for(int i=1;i<arr.length;i++){
            //energy required to reach i min(any k jump)
            int energy = Integer.MAX_VALUE;
            
            //perform k jumps from each index in back
            for(int j=1;j<=k;j++){
                
                int jumpRange = i-j;
                //jump should be valid
                if(jumpRange<0) continue;
                //prev jump + current jump
                int temp = cache[jumpRange] + Math.abs(arr[i] - arr[jumpRange]);
                //update min jump of k jumps
                energy = Math.min(temp,energy);
                
            }
            
            cache[i] = energy;
        }
        
        return cache[arr.length-1];
        
    }
        
    }


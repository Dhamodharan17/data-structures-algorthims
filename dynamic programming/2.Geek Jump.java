//https://www.geeksforgeeks.org/problems/geek-jump/1
//recursion

class Solution{
    public int minimumEnergy(int arr[],int N){
      
      return minimumEnergyUtil(arr,N-1);
        
    }
    
    int minimumEnergyUtil(int arr[],int N){
          
        if(N<0) return Integer.MAX_VALUE;
        
        if(N==0) return 0;
    
        int oneStep = Math.abs(arr[N]-arr[N-1]) + 
        minimumEnergyUtil(arr,N-1);
            
        int twoStep = Integer.MAX_VALUE;
        if(N>1)
             twoStep = Math.abs(arr[N]-arr[N-2]) + 
        minimumEnergyUtil(arr,N-2);
        
        return Math.min(oneStep,twoStep);
    }
    
}

// memoization

class Solution{
    
    Integer[] cache ;
      
    public int minimumEnergy(int arr[],int N){
      cache = new Integer[N];
      return minimumEnergyUtil(arr,N-1);
        
    }
    
    int minimumEnergyUtil(int arr[],int N){
          
        if(N<0) return Integer.MAX_VALUE;
        
        if(cache[N]!=null) return cache[N];
        
        if(N==0) return cache[N]= 0;
    
        int oneStep = Math.abs(arr[N]-arr[N-1]) + 
        minimumEnergyUtil(arr,N-1);
            
        int twoStep = Integer.MAX_VALUE;
        if(N>1)
             twoStep = Math.abs(arr[N]-arr[N-2]) + 
        minimumEnergyUtil(arr,N-2);
        
        return cache[N]= Math.min(oneStep,twoStep);
    }
    
}

// tabulation

class Solution{

    public int minimumEnergy(int arr[],int N){
      
      //if(N==1) return 0;
      
      Integer[]  cache = new Integer[N];
      cache[0]=0;//energy required to reach 0 from 0 = 1
      if(N>1)
         cache[1] = Math.abs(arr[0] - arr[1]);
      
      for(int i=2;i<N;i++){
          //energy requred to reach i =>min(1step,2step)
          int jump1 = cache[i-1]+  Math.abs(arr[i] - arr[i-1]);
          int jump2 = cache[i-2]+  Math.abs(arr[i] - arr[i-2]);
          
          cache[i] = Math.min(jump1,jump2);
      }
   
      return cache[N-1];
        
    }
}

//space optmization - use value from cache and array

class Solution{

    public int minimumEnergy(int arr[],int N){
      
      int back=0;
      if(N==1) return back;
      
      int immediateBack=Math.abs(arr[0] - arr[1]);;
      
      for(int i=2;i<N;i++){
          
          //came from 1
          int jump1 = immediateBack+  Math.abs(arr[i] - arr[i-1]);
          //came from 0
          int jump2 = back+  Math.abs(arr[i] - arr[i-2]);
          
          back = immediateBack;
          
          //energy requred to reach i =>min(1step,2step)
          immediateBack = Math.min(jump1,jump2);// immediate back = new value
      }
   
      return immediateBack;
        
    }
}

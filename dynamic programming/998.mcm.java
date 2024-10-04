class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
        return mcm(arr,1,N-1);
        
    }
    
    static int mcm(int[] arr,int i,int j){
        
        //only element in matrix -> takes 0 operation to mutiply
        if(i==j) return 0;
        
        int mini = Integer.MAX_VALUE;

        //try all possible paritions
        for(int k=i;k<=j-1;k++){
            //left + right + current
            int ans = mcm(arr,i,k) + mcm(arr,k+1,j)+
            arr[i-1]*arr[k]*arr[j];//number of operation required to multiply current 3 matices
            mini = Math.min(mini,ans);
        }
        
        return mini;
    }
    
}
//tabulation (oppsite) start from small build to big


class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
        int dp[][] = new int[N][N];
        for(int i=0;i<N;i++)dp[i][i]=0;
      
      //till 1 because array start at 1
      for(int i=N-1;i>=1;i--){
          //block
          for(int j=i+1;j<N;j++){
              int mini = Integer.MAX_VALUE;
              //parition
              for(int k=i;k<j;k++){
                  
                  int steps = arr[i-1]*arr[k]*arr[j] + dp[i][k] + dp[k+1][j];
                  mini = Math.min(mini,steps);
              }
              dp[i][j] = mini;
          }
      }
      
     return dp[1][N-1];
        
    }


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
            int ans = mcm(arr,i,k) + mcm(arr,k+1,j)+
            arr[i-1]*arr[k]*arr[j];//number of operation required to multiply current 3 matices
            mini = Math.min(mini,ans);
        }
        
        return mini;
    }
    
}

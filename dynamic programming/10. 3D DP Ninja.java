
//recursion - simple just think like graph dfs
class Solution {
    public int solve(int n, int m, int grid[][]) {
        // Code here
        return maxChoclateUtil(0,0,m-1,n,m,grid);
    }
    
    int maxChoclateUtil(int i,int j1,int j2,int n,int m,int[][] grid){
        
        //basecase 1
        if(j1<0 || j1>=m || j2<0 || j2>=m) return Integer.MIN_VALUE;
        
        //basecase 2 - last row
        if(i==n-1){
            //only one chocate counted
            if(j1==j2) return grid[i][j1];
            //both got chocolate
            return grid[i][j1] + grid[i][j2];
        }
        
        int maxi=Integer.MIN_VALUE;
        //for each position of robot 1 try all other for robot2
        for(int di= -1 ;di<=1;di++){
            for(int dj=-1;dj<=1;dj++){
                int ans;
                if(j1==j2)
                    ans = grid[i][j1] + maxChoclateUtil(i+1,j1+di,j2+dj,n,m,grid);
                    //increase row and try directions
                else
                    ans = grid[i][j1] + grid[i][j2]+ maxChoclateUtil(i+1,j1+di,j2+dj,n,m,grid);
                
                maxi = Math.max(maxi,ans);
                
            }
        }
        
        return maxi;
    }
}

//memoization
class Solution {
    Integer[][][] cache;
    public int solve(int n, int m, int grid[][]) {
        // Code here
        cache = new Integer[n][m][m];
        return maxChoclateUtil(0,0,m-1,n,m,grid);
    }
    
    int maxChoclateUtil(int i,int j1,int j2,int n,int m,int[][] grid){
        
        //basecase 1
        if(j1<0 || j1>=m || j2<0 || j2>=m) return Integer.MIN_VALUE;
        
        if(cache[i][j1][j2]!=null) return cache[i][j1][j2];
      
        //basecase 2 - last row
        if(i==n-1){
            //only one chocate counted
            if(j1==j2) return cache[i][j1][j2] = grid[i][j1];
            //both got chocolate
            return cache[i][j1][j2] = grid[i][j1] + grid[i][j2];
        }
        
        int maxi=Integer.MIN_VALUE;
        //for each position of robot 1 try all other for robot2
        for(int di= -1 ;di<=1;di++){
            for(int dj=-1;dj<=1;dj++){
                int ans;
                if(j1==j2)
                    ans = grid[i][j1] + maxChoclateUtil(i+1,j1+di,j2+dj,n,m,grid);
                    //increase row and try directions
                else
                    ans = grid[i][j1] + grid[i][j2]+ maxChoclateUtil(i+1,j1+di,j2+dj,n,m,grid);
                
                cache[i][j1][j2] = maxi = Math.max(maxi,ans);
                
            }
        }
        
        return cache[i][j1][j2];
    }
}

//tabulation


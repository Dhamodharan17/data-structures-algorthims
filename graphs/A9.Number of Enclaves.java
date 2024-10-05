/*
operation - add 1's to queue
bfs
operation - count number of 1's

*/
//https://leetcode.com/problems/number-of-enclaves/

class Solution {
    int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
    
    public int numEnclaves(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        preprocess(grid,q,rows,cols);

        while(!q.isEmpty()){
            int[] current = q.remove();
            int x = current[0],y=current[1];
            grid[x][y]=0;
            for(int[] d:directions){
                int x1 = x+d[0];
                int y1 = y+d[1];
                if(!isSafe(x1,y1,grid))continue;
                //if we didn't change next guy will see the 
                //same index and look as it is unvisted.
                grid[x1][y1]=0;
                q.add(new int[]{x1,y1});
            }
        }

        int num=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1) num++;
            }
        }

    return num;
    }

    boolean isSafe(int x,int y,int[][] grid){
        if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || grid[x][y] == 0) return false;

        return true;
    }

    void preprocess(int[][] grid,Queue<int[]> q, int rows,int cols){

        //capture all ones on border because they only can give path to other to come out


        //goes all cols but we want start and end
         for(int i=0;i<cols;i++){
            if(grid[0][i] == 1) q.add(new int[]{0,i});
            if(grid[rows-1][i] == 1) q.add(new int[]{rows-1,i});
        }


        //goes all rows but we want start and end
        
        for(int i=0;i<rows;i++){
            if(grid[i][0] == 1) q.add(new int[]{i,0});
            if(grid[i][cols-1] == 1) q.add(new int[]{i,cols-1});
        }
       

    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

        Queue<int[]> q = new LinkedList<>();

        //push all rotton oranges
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2) q.add(new int[]{i,j});
            }
        }

        while(!q.isEmpty()){

            int size = q.size();
            for(int i=0;i<size;i++){
                
                int[] current = q.remove();
                int x = current[0], y = current[1];

                for(int[] direct:directions){
                    int nextX = x+direct[0];
                    int nextY = y+direct[1];
                    if(!isSafe(nextX,nextY,grid)) continue;
                    grid[nextX][nextY] +=grid[x][y];
                    //add to u can rotte (nextX,nextY) neighbours
                    q.add(new int[]{nextX,nextY});
                } 

            }  // end of size for 

        }//end of while
        
          int max = 0;
          for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1) return -1;
                max = Math.max(max,grid[i][j]);
            }
        }

        return max>2?max-2:0;


    }//end of method

    boolean isSafe(int x,int y,int[][] grid){
        // rotten fruits are added in queue, no need to add again
        if(x>=grid.length || y>=grid[0].length || x<0 || y<0 || grid[x][y]>=2 || grid[x][y] == 0) return false;

        return true;
    }
}

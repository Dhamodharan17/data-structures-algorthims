/*
https://leetcode.com/problems/rotting-oranges/description/
https://leetcode.com/problems/shortest-distance-from-all-buildings/description/
https://leetcode.com/problems/as-far-from-land-as-possible/description/
*/

/*
operation - add 2s to queue
bfs
operation - get max value and check 1 present
*/
class Solution {
    public int orangesRotting(int[][] grid) {

        int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};

        int n = grid.length;
        int m = grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();

        //push all rotten orange
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
            }
        }

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){
                int[] current = q.remove();
                int x = current[0];
                int y = current[1];
                //check 4 directions and rotte
                for(int[] d:direction){
                    int x1 = x+d[0];
                    int y1 = y+d[1];
                    if(!isSafe(x1,y1,grid))continue;
                    grid[x1][y1] += grid[x][y];
                    q.add(new int[]{x1,y1});
                }
            }
        }
    //at end all oranges should be rotten

        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1) return -1;
               max = Math.max(max,grid[i][j]);
            }
        }

        //since the box had 2
        return max>2?max-2:0;
    }

    boolean isSafe(int x,int y, int[][] grid){

        if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || grid[x][y] == 0 || grid[x][y]>= 2) return false;

        return true;
    }
}

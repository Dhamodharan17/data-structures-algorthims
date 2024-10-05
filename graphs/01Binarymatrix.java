//https://leetcode.com/problems/01-matrix/

//we need to update right distance from 0
//push all 1's find righ distance from 4 directions
//add in queue again, all neighbors will also get new distance
class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;
        Queue<int[]> q = new LinkedList<>();

        //push all 1's
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                //find right distance for all 1's
                if(mat[i][j]==1) q.add(new int[]{i,j});
            }
        }

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){

                int[] current = q.remove();
                int x = current[0];
                int y = current[1];

                //get min from 1 directions
                int left= y>0?mat[x][y-1]:Integer.MAX_VALUE;
                int right= y<m-1?mat[x][y+1]:Integer.MAX_VALUE;
                int top = x>0?mat[x-1][y]:Integer.MAX_VALUE;
                int bot = x<n-1?mat[x+1][y]:Integer.MAX_VALUE;

                int temp=mat[x] [y];

                int min = Math.min(left , Math.min(right,Math.min(top,bot)))+1;

                mat[x] [y] = min;
                if(temp!=min){
                    q.add(new int[]{x,y});
                }       
        }

    }
        return mat;
    }
}

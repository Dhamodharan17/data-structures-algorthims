/*
https://leetcode.com/problems/surrounded-regions/
we need to mark all the 0's not connected to border 0's to X
differinate the border connected and normal O's
and mark it X
*/

class Solution {

    int[][] directions = {{0,-1},{0,1},{1,0},{-1,0}};

    public void solve(char[][] board) {
        
        int m = board.length;
        int n = board[0].length;
        Queue<int[]> q = new LinkedList<>();

          //push all border 0's
        for(int i=0;i<n;i++){
            if(board[0][i] == 'O') q.add(new int[]{0,i});
            if(board[m-1][i] == 'O') q.add(new int[]{m-1,i});
        }

        for(int i=0;i<m;i++){
            if(board[i][0] == 'O') q.add(new int[]{i,0});
            if(board[i][n-1] == 'O') q.add(new int[]{i,n-1});
        }


        //whatever in queue are border attached
        while(!q.isEmpty()){
            
            int[] current = q.remove();
            int x = current[0];
            int y = current[1];
            board[x][y] = '#';

            for(int[] d: directions){
                int x1 = x+d[0];
                int y1 = y+d[1];
                if(!isSafe(x1,y1,board)) continue;
                q.add(new int[]{x1,y1});
            }
        }

    //post processing
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }

    }

    boolean isSafe(int x,int y,char[][] board){
        if(x<0 || y<0 || x>=board.length || y>=board[0].length || board[x][y] == 'X' || board[x][y] =='#') return false;

        return true;
    }

}

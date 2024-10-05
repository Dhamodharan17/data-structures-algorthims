class Solution {

    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

    //color whoever have starting pixel    
    int myColor = image[sr][sc];
    image[sr][sc] = color;
    deeper(sr,sc,myColor,color,image);

    return image;

    }

    void deeper(int sr,int sc, int myColor,int color,int[][] image){

        for(int[] dir:directions){
            int x = sr+dir[0];
            int y = sc+dir[1];
           if( !isSafe(x,y,myColor,color,image) ) continue;
            image[x][y] = color;
            deeper(x,y,myColor,color,image);
        }

    }

    boolean isSafe(int x,int y,int myColor,int color,int[][] image){
        if(x<0 || y<0 || x>=image.length || y>=image[0].length ||
        image[x][y] == color || image[x][y]!=myColor) return false;
//image[x][y] == color   - if already colored //image[x][y]!=myColor - not my color to color -> return false;
          return true;
    }
  

}

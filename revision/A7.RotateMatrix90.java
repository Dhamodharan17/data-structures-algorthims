class Solution {
    public void rotate(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        //transpose
        for(int i=0;i<rows;i++){
            for(int j=0;j<i;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
          }
        }

        //reverse each row
        for(int i=0;i<rows;i++){
            int[] row = matrix[i];
            int left=0,right = matrix[i].length-1;

            while(left<right){
                int temp = row[left];
                row[left] = row[right];
                row[right] = temp;
                left++;
                right--;
            }
        }


    }
}

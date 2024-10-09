class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int left = 0, right = matrix[0].length-1, top=0, bottom = matrix.length-1;

        int size = matrix.length * matrix[0].length;

        List<Integer> list = new ArrayList<>();

        while(list.size()<size){

            for(int i=left;i<=right && list.size()<size;i++){
                list.add(matrix[top][i]);
            }
            top++;

            for(int i=top;i<=bottom && list.size()<size;i++){
                list.add(matrix[i][right]);
            }

            right--;
            for(int i=right;i>=left && list.size()<size;i--){
                list.add(matrix[bottom][i]);
            }

            bottom--;
            for(int i=bottom;i>=top && list.size()<size ;i--){
                list.add(matrix[i][left]);
            }

            left++;
        }

    return list;
    }
}

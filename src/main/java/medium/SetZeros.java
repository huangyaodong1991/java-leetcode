package medium;

public class SetZeros {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0){
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        int lastZeroLine = -1;
        for (int i = 0; i < m; i++){
            for (int j = 0; i< n; j++){
                if (matrix[i][j] == 0){
                    lastZeroLine = i;
                    break;
                }
            }
        }

        if (lastZeroLine < 0){
            return;
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j <= lastZeroLine; j++){
                if (matrix[j][i] == 0){
                    matrix[lastZeroLine][i] = 0;
                    break;
                }
            }
        }

        //先将设为0
        //再将列设为0


    }
}

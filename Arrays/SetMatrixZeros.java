/**
 * Created by juanyan.li on 3/24/17.
 */
public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean col0 = false;
        for (int i=0; i<m; i+=1) {
            if (matrix[i][0] == 0) col0 = true;
            for (int j=1; j<n; j+=1) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i=m-1; i>=0; i-=1) { // rows
            for (int j=1; j<n; j+=1) { // columns
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0) matrix[i][0] = 0;
        }
    }
}

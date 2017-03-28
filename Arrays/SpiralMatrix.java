/**
 * Created by juanyan.li on 3/26/17.
 */
public class SpiralMatrix {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int fill = 1;
        int ub = 0, lb = 0;
        int db = n-1, rb = n-1;
        while (fill <= n*n) {
            for (int i=lb; i<=rb; i+=1) { // go right
                matrix[ub][i] = fill;
                fill += 1;
            }
            ub += 1;
            for (int j=ub; j<=db; j+=1) { // go down
                matrix[j][rb] = fill;
                fill += 1;
            }
            rb -= 1;
            for (int i=rb; i>=lb; i-=1) { // go left
                matrix[db][i] = fill;
                fill += 1;
            }
            db -= 1;
            for (int j=db; j>=ub; j-=1) { // go up
                matrix[j][lb] = fill;
                fill += 1;
            }
            lb += 1;
        }
        return matrix;
    }
}

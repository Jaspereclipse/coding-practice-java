/**
 * Created by juanyan.li on 4/1/17.
 */
import java.util.Arrays;

import static java.lang.Math.max;
import static java.lang.Math.min;
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        int m = matrix.length;
        if (m < 1) return maxArea;
        int n = matrix[0].length;
        int[] lb = new int[n]; // left boundary
        int[] rb = new int[n]; // right boundary
        int[] h = new int[n]; // height
        Arrays.fill(rb, n-1);
        for (int i=0; i<m; i+=1) {
            int crt_lb = 0;
            int crt_rb = n - 1;
            for (int j=0; j<n; j+=1) {
                if (matrix[i][j] == '1') {
                    h[j] += 1;
                    lb[j] = max(lb[j], crt_lb);
                } else {
                    h[j] = lb[j] = 0;
                    crt_lb = j+1;
                }
                if (matrix[i][n-j-1] == '1') {
                    rb[n-j-1] = min(rb[n-j-1], crt_rb);
                } else {
                    rb[n-j-1] = n-1;
                    crt_rb = n-j-2;
                }
            }
            for (int j=0; j<n; j+=1){
                maxArea = max(maxArea, (rb[j]-lb[j]+1)*h[j]);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        MaximalRectangle mr = new MaximalRectangle();
        char[][] inputs = {{'1','0'}};
        mr.maximalRectangle(inputs);
    }
}

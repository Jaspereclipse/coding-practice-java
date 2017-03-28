import static java.lang.Math.min;

/**
 * Created by juanyan.li on 3/26/17.
 */
public class UniquePaths {
    public int findPathsI(int m, int n) {
        long result = 1;
        int sum = n+m;
        m = min(m, n);
        n = sum - m;
        for (int i=1; i<=m-1; i+=1) {
            result *= n-1+i;
            result /= i;
        }
        return (int) result;
    }

    public int findPathsII(int[][] obstacleGrid) {
        int m = obstacleGrid.length; // row
        int n = obstacleGrid[0].length; // col
        boolean trackCol = true;
        if (n < m) {
            trackCol = false;
            int sum = n+m;
            m = n;
            n = sum - m;
        }
        int[] track = new int[m];
        track[0] = 1;
        for (int j=0; j<n; j+=1) {
            if (trackCol) track[0] = obstacleGrid[0][j] == 1 ? 0 : track[0];
            else track[0] = obstacleGrid[j][0] == 1 ? 0 : track[0];
            for (int i=1; i<m; i+=1) {
                if (trackCol) track[i] = obstacleGrid[i][j] == 1 ? 0 : track[i-1] + track[i];
                else track[i] = obstacleGrid[j][i] == 1 ? 0 : track[i-1] + track[i];

            }
        }
        return track[m-1];
    }
}

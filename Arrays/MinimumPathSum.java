import static java.lang.Math.min;
/**
 * Created by juanyan.li on 3/27/17.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean useCol = true;
        if (n < m) { // always use smaller dimension to reduce memory
            int tmp = n;
            n = m;
            m = tmp;
            useCol = false;
        }
        int[] track = new int[m];
        track[0] = grid[0][0];
        for (int j=1; j<m; j+=1) {
            track[j] = (useCol ? grid[j][0] : grid[0][j])
                    + track[j-1];
        }
        for (int i=1; i<n; i+=1) {
            track[0] += useCol ? grid[0][i] : grid[i][0];
            for (int j=1; j<m; j+=1) {
                track[j] = (useCol ? grid[j][i] : grid[i][j])
                        + min(track[j], track[j-1]);
            }
        }
        return track[m-1];
    }
}

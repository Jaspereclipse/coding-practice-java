/**
 * Created by juanyan.li on 3/27/17.
 */
public class Search2dMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m < 1) return false;
        int n = matrix[0].length;
        int low = 0;
        int high = m*n-1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int val = find(matrix, mid);
            if (val == target) return true; // found
            if (val > target) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }

    public int find(int[][] matrix, int index) {
        int n = matrix[0].length;
        return matrix[index / n][index % n];
    }
}

import java.util.List;
import static java.lang.Math.min;

/**
 * Created by juanyan.li on 3/23/17.
 */
public class Triangle {
    // DP bottom up
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] minSum = new int[n];
        for (int i=0; i<triangle.get(n-1).size(); i+=1) {
            minSum[i] = triangle.get(n-1).get(i);
        }
        for (int i=n-2; i>=0; i-=1) {
            List<Integer> layer = triangle.get(i);
            for (int j=0; j<layer.size(); j+=1) {
                minSum[j] = layer.get(j) + min(minSum[j], minSum[j+1]);
            }
        }
        return minSum[0];
    }
}

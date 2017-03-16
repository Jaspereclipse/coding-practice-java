import java.util.HashMap;
import java.util.Map;

/**
 * Created by juanyan.li on 3/6/17.
 */
public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int len = A.length;
        Map<Integer, Integer> firstMap = new HashMap<>();
        Map<Integer, Integer> secondMap = new HashMap<>();
        for (int i=0; i<len; i+=1) {
            for (int j=0; j<len; j+=1) {
                int firstHalf = A[i] + B[j];
                int secondHalf = - C[i] - D[j];
                firstMap.put(firstHalf, firstMap.containsKey(firstHalf) ? firstMap.get(firstHalf) + 1 : 1);
                secondMap.put(secondHalf, secondMap.containsKey(secondHalf) ? secondMap.get(secondHalf) + 1 : 1);
            }
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : firstMap.entrySet()) {
            int key = entry.getKey();
            if (secondMap.containsKey(key)) count += entry.getValue() * secondMap.get(key);
        }
        return count;
    }
}

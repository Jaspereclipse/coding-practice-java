import java.util.HashMap;
import java.util.Map;

/**
 * Created by juanyan.li on 3/14/17.
 */
public class KDiffPairs {
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.containsKey(num) ? map.get(num) + 1 : 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0 && entry.getValue() >= 2) {
                count += 1;
            } else if (k > 0 && map.containsKey(entry.getKey() + k)) {
                count += 1;
            }
        }
        return count;
    }
}

import java.util.HashMap;
import java.util.Map;
import static java.lang.Math.max;

/**
 * Created by juanyan.li on 3/8/17.
 */
public class LongestConsecutiveSequence {
    private int maxSize;
    private Map<Integer, Integer> nums; // num-size pair; size if the connected component's size

    public LongestConsecutiveSequence() {
        maxSize = 0;
        nums = new HashMap<>();
    }

    public void add(int num) {
        if (nums.containsKey(num)) return;
        int size = 1;
        int leftOne = num - 1;
        int rightOne = num + 1;
        int leftSize = nums.containsKey(leftOne) ? nums.get(leftOne) : 0;
        int rightSize = nums.containsKey(rightOne) ? nums.get(rightOne) : 0;
        size += leftSize + rightSize;
        nums.put(num, size);
        nums.put(num - leftSize, size);
        nums.put(num + rightSize, size);
        maxSize = max(maxSize, size);
    }

    public int size() {
        return maxSize;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        int[] intpus = new int[]{100,4,200,1,3,2,2};
        for (int num : intpus) {
            lcs.add(num);
        }
        System.out.println(lcs.size());
    }
}

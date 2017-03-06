import java.util.HashMap;
import java.util.Map;

/* use hash map */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i < nums.length; i+=1){
            int val = nums[i];
            if (map.containsKey(target - val)) {
                return new int[]{i, map.get(target-val)};
            }
            map.put(val, i);
        }
        throw new IllegalArgumentException("None found.");
    }

    public int[] sortedTwoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int sum = nums[left] + nums[right];
            if (sum == target){
                return new int[]{left, right};
            } else if (sum < target) {
                left += 1;
            } else {
                right -= 1;
            }
        }
        throw new IllegalArgumentException("None found.");
    }

    public void printRes(int[] res){
        System.out.println("[" + res[0] + ", " + res[1] + "]");
    }

    public static void main(String[] args){
        TwoSum ts = new TwoSum();
        // two sum - time: O(n); space: O(n)
        int[] inputs = new int[]{2,7,11,15};
        int[] res = ts.twoSum(inputs, 9);
        ts.printRes(res);
        // sorted two sum - time: O(n); space: O(1)
        inputs = new int[]{0,0,11,15};
        res = ts.sortedTwoSum(inputs, 0);
        ts.printRes(res);
    }
}

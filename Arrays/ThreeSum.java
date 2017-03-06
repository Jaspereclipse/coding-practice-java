import java.util.*;
import static java.lang.Math.abs;

/**
 * Created by juanyan.li on 3/5/17.
 */
public class ThreeSum {
    // triplets sum up to 0
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Integer prev = null;
        for (int i=0; i<nums.length; i+=1) {
            if (prev != null && prev.equals(nums[i])) continue;
            findTwoSum(map, res, -nums[i], nums, i+1, nums.length - 1);
            prev = nums[i];
            map.clear();
        }
        return res;
    }

    public void findTwoSum(Map<Integer, Integer> map, List<List<Integer>> res, int value, int[] nums, int start, int end) {

        for (int i=start; i<=end; i+=1) {
            int remain = value - nums[i];
            if (map.containsKey(remain) && map.get(remain) != -1) {
                res.add(Arrays.asList(new Integer[]{-value, nums[i], remain}));
                map.put(remain, -1);
            } else if (!map.containsKey(remain)){
                map.put(nums[i], 1);
            }
        }
    }

    // closest to target
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        Integer prev = null;
        int gap = Integer.MAX_VALUE;
        for (int i=0; i<nums.length; i+=1) {
            if (prev != null && prev.equals(nums[i])) continue;
            gap = findTwoSumClosest(gap, target - nums[i], nums, i+1, nums.length-1);
            if (gap == 0) return target;
        }
        return target - gap;
    }

    public int findTwoSumClosest(int gap, int value, int[] nums, int start, int end) {
        while (start < end) {
            int newGap = value - nums[start] - nums[end];
            gap = abs(gap) > abs(newGap) ? newGap : gap;
            if (newGap > 0) start += 1; // target is bigger than 3 sum
            else end -= 1; // smaller
        }
        return gap;
    }

    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        for (int i=0; i<nums.length; i+=1) {
            res += findTwoSumSmaller(target-nums[i], nums, i+1, nums.length-1);
        }
        return res;
    }

    public int findTwoSumSmaller(int value, int[] nums, int start, int end) {
        int local = 0;
        while (start < end) {
            int gap = value - nums[start] - nums[end];
            if (gap > 0) {
                local += end - start; // if triplet is smaller, all index smaller than end can pair with start
                start += 1;
            } else end -= 1; // too big
        }
        return local;
    }

    public void printRes(List<List<Integer>> res) {
        for (List<Integer> list : res) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public void printRes(int res) {
        System.out.println(res);
    }

    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();
        ts.printRes(ts.threeSum(new int[]{0,2,2,3,0,1,2,3,-1,-4,2}));
        ts.printRes(ts.threeSumClosest(new int[]{-1,2,1,-4}, 1));
        ts.printRes(ts.threeSumSmaller(new int[]{-2,0,1,3}, 2));
    }
}

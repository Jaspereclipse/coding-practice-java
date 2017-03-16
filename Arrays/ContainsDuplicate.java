import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.lang.Math.abs;

/**
 * Created by juanyan.li on 2/26/17.
 */
public class ContainsDuplicate {
    public boolean containsDuplicateI(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int num: nums){
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }

    // same value with indices' absolute diff at most k
    public boolean containsDuplicateII(int[] nums, int k){
        if (nums.length < 2 || k < 1) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i+=1){
            if (map.containsKey(nums[i]) && abs(i-map.get(nums[i])) <= k) return true;
            map.put(nums[i], i);
        }
        return false;
    }

    // value diff at most t with indices' absolute diff at most k
    public boolean containsDuplicateIII(int[] nums, int k, int t){
        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        long d = (long) t + 1;
        for (int i=0; i<nums.length; i+=1){
            long mappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long key = mappedNum / d;
            if (map.containsKey(key) ||
                    map.containsKey(key + 1) && map.get(key + 1) - mappedNum <= t ||
                    map.containsKey(key - 1) && mappedNum - map.get(key - 1) <= t)
                return true;
            if (map.size() >= k){
                long lastKey = ((long) nums[i-k] - Integer.MIN_VALUE) / d;
                map.remove(lastKey);
            }
            map.put(key, mappedNum);
        }
        return false;
    }

    public void printRes(boolean ind){
        System.out.println(ind);
    }

    public static void main(String[] args){
        ContainsDuplicate cd = new ContainsDuplicate();
        int[] inputs = new int[0];
        boolean res = cd.containsDuplicateI(inputs);
        cd.printRes(res);
        inputs = new int[]{1,2,3,4};
        res = cd.containsDuplicateI(inputs);
        cd.printRes(res);
        inputs = new int[]{1,1,2,4};
        res = cd.containsDuplicateI(inputs);
        cd.printRes(res);
        inputs = new int[]{1,2,3,1};
        res = cd.containsDuplicateII(inputs, 3); // true
        cd.printRes(res);
        inputs = new int[]{1,2,3,1};
        res = cd.containsDuplicateII(inputs, 2); // false
        cd.printRes(res);
        inputs = new int[]{-1,2147483647};
        res = cd.containsDuplicateIII(inputs, 1, 2147483647);
        cd.printRes(res);
    }
}
